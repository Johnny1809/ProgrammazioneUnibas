package it.unibas.aziende.controllo;

import it.unibas.aziende.Applicazione;
import it.unibas.aziende.Costanti;
import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.persistenza.DAOException;
import java.awt.event.ActionEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.NAME;
import org.slf4j.LoggerFactory;

public class ControlloPrincipale {
    
    private Action azioneRicerca = new AzioneRicerca();
    private Action azioneSeleziona = new AzioneSelezionaAzienda();

    public Action getAzioneSeleziona() {
        return azioneSeleziona;
    }
    private static org.slf4j.Logger logger = LoggerFactory.getLogger(ControlloPrincipale.class);

    public Action getAzioneRicerca() {
        return azioneRicerca;
    }
    

    private class AzioneSelezionaAzienda extends AbstractAction {

        public AzioneSelezionaAzienda() {
            this.putValue(NAME, "Seleziona");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int indiceAziendaSelezionata = Applicazione.getInstance().getPannelloPrincipale().getPosizioneElementoSelezionato();
            if (indiceAziendaSelezionata == -1) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Nessuna azienda selezionata");
                return;
            }
            List<Azienda> aziende = (List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_AZIENDE);
            Azienda aziendaSelezionata = aziende.get(indiceAziendaSelezionata);
            try {
                Applicazione.getInstance().getDaoAzienda().caricaDipendenti(aziendaSelezionata);
                Applicazione.getInstance().getModello().putBean(Costanti.AZIENDA_SELEZIONATA, aziendaSelezionata);
                Applicazione.getInstance().getFinestraDettagli().mostra();
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Problema con il DB");
                logger.error(ex.getMessage());
            }
        }

    }
    
    private class AzioneRicerca extends AbstractAction{

        public AzioneRicerca() {
            this.putValue(NAME, "Ricerca");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String valoreCampoSede = Applicazione.getInstance().getPannelloPrincipale().getValoreCampoSede();
            String errori = convalida(valoreCampoSede);
            if (!errori.isBlank()){
                Applicazione.getInstance().getFrame().mostraMessaggioErrore(errori);
                return;
            }
            try {
                List<Azienda> aziende = Applicazione.getInstance().getDaoAzienda().findBySede(valoreCampoSede);
                Applicazione.getInstance().getModello().putBean(Costanti.LISTA_AZIENDE, aziende);
                Applicazione.getInstance().getPannelloPrincipale().aggiornaTabella();
            } catch (DAOException ex) {
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nel caricamento delle aziende");
                logger.error("Errore con il DB: " + ex.getMessage() );
            }
            
        }

        private String convalida(String valoreCampoSede) {
            StringBuilder errori = new StringBuilder();
            if (valoreCampoSede.isBlank() || valoreCampoSede == null){
                errori.append("Prima devi inserire una sede");
            }
            return errori.toString().trim();
        }
        
        
    }
    
}
