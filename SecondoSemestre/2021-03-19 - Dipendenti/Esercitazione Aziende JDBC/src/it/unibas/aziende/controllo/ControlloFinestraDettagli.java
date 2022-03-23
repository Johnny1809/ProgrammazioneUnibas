package it.unibas.aziende.controllo;

import it.unibas.aziende.Applicazione;
import it.unibas.aziende.Costanti;
import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Dipendente;
import it.unibas.aziende.persistenza.DAOException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloFinestraDettagli {

    private static Logger logger = LoggerFactory.getLogger(ControlloFinestraDettagli.class);

    public Action azioneEliminaDipendente = new AzioneEliminaDipendente();
    public Action azioneAggiungiDipendente = new AzioneAggiungiDipendente();

    public Action getAzioneEliminaDipendente() {
        return azioneEliminaDipendente;
    }

    public Action getAzioneAggiungiDipendente() {
        return azioneAggiungiDipendente;
    }
    

    private class AzioneAggiungiDipendente extends AbstractAction {

        public AzioneAggiungiDipendente() {
            this.putValue(NAME, "Aggiungi");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String codiceFiscale = Applicazione.getInstance().getFinestraDettagli().getValoreCodiceFiscale();
            String nome = Applicazione.getInstance().getFinestraDettagli().getValoreNome();
            String cognome = Applicazione.getInstance().getFinestraDettagli().getValoreCognome();
            String annoAssunzione = Applicazione.getInstance().getFinestraDettagli().getValoreAnnoAssunzione();
            String errori = convalidaValori(codiceFiscale, nome, cognome, annoAssunzione);
            if (!errori.isEmpty()) {                
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Dipendente dipendente = new Dipendente(codiceFiscale, nome, cognome, Integer.parseInt(annoAssunzione));
            try {
                Azienda aziendaSelezionata = (Azienda) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
                Applicazione.getInstance().getDaoDipendente().salvaDipendente(aziendaSelezionata, dipendente);
                Applicazione.getInstance().getDaoAzienda().caricaDipendenti(aziendaSelezionata);
                Applicazione.getInstance().getFinestraDettagli().aggiornaTabella();
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nell'accesso al DB");
                logger.error(ex.getMessage());
            }
                 
        }

        private String convalidaValori(String codiceFiscale, String nome, String cognome, String annoAssunzione) {
            StringBuilder errori = new StringBuilder();
            if (codiceFiscale.isEmpty()) {
                errori.append("Il codice Fiscale non può essere vuoto\n");
            }
            if (!codiceFiscale.isEmpty()) {
                try {
                    Dipendente dipendente = Applicazione.getInstance().getDaoDipendente().findByCodiceFiscale(codiceFiscale);
                    if (dipendente != null) errori.append("Dipendete con questo codice fiscale già presente\n");
                } catch (DAOException ex) {
                    errori.append("Errore nell'accesso al DB\n");
                }
            }
            if (nome.isEmpty()) {
                errori.append("Il nome non può essere vuoto\n");
            }
            if (cognome.isEmpty()) {
                errori.append("Il cognome non può essere vuoto\n");
            }
            try {
                Integer.parseInt(annoAssunzione);
            } catch (NumberFormatException ex) {
                errori.append("L'anno deve essere un valore intero\n");
            }
            return errori.toString();
        }

    }

    private class AzioneEliminaDipendente extends AbstractAction {

        public AzioneEliminaDipendente() {
            this.putValue(NAME, "Elimina");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Azienda aziendaSelezionata = (Azienda) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
            int indiceDipendenteSelezionato = Applicazione.getInstance().getFinestraDettagli().getDipendenteSelezionato();
            if (indiceDipendenteSelezionato == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Nessun dipendente selezionato");
                return;
            }
            Dipendente dipendenteDaEliminare = aziendaSelezionata.getDipendenti().get(indiceDipendenteSelezionato);
            try {
                Applicazione.getInstance().getDaoDipendente().cancellaDipendente(dipendenteDaEliminare);
                Applicazione.getInstance().getDaoAzienda().caricaDipendenti(aziendaSelezionata);
                Applicazione.getInstance().getFinestraDettagli().aggiornaTabella();
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Problemi con il DB");
                logger.error(ex.getMessage());
            }
        }

    }
}
