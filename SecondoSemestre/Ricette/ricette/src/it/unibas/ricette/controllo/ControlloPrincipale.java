package it.unibas.ricette.controllo;

import it.unibas.ricette.Applicazione;
import it.unibas.ricette.Costanti;
import it.unibas.ricette.modello.Modello;
import it.unibas.ricette.modello.Paziente;
import it.unibas.ricette.modello.Prestazione;
import it.unibas.ricette.modello.Ricetta;
import it.unibas.ricette.persistenza.DAOException;
import it.unibas.ricette.persistenza.hibernate.DAOUtilHibernate;
import it.unibas.ricette.vista.FinestraDettagliPaziente;
import it.unibas.ricette.vista.PannelloPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControlloPrincipale {

    private Action azioneCerca = new AzioneRicerca();
    private Action azioneDettagliPaziente = new AzioneDettagliPaziente();
    private Action azioneApriFinestraPeriodi = new AzioneApriFinestraPeriodi();

    private static final Logger logger = LoggerFactory.getLogger(ControlloPrincipale.class);

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneDettagliPaziente() {
        return azioneDettagliPaziente;
    }

    public Action getAzioneApriFinestraPeriodi() {
        return azioneApriFinestraPeriodi;
    }

    public class AzioneApriFinestraPeriodi extends AbstractAction {

        public AzioneApriFinestraPeriodi() {
            this.putValue(NAME, "Verifica Periodi");
            this.putValue(SHORT_DESCRIPTION, "Permette di visuializzare tutte le ricette erogate in un determinato periodo");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt P"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione.getInstance().getFinestraPeriodi().visualizza();
        }

    }

    private class AzioneDettagliPaziente extends AbstractAction {

        public AzioneDettagliPaziente() {
            this.putValue(NAME, "Dettagli");
            this.putValue(SHORT_DESCRIPTION, "Visualizza i dettagli del paziente selezionato");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_D);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione = Applicazione.getInstance();
            Modello modello = applicazione.getModello();
            PannelloPrincipale pannelloPrincipale = applicazione.getPannelloPrincipale();
            int indiceSelezionato = pannelloPrincipale.getIndiceSelezionato();
            if (indiceSelezionato == -1) {
                applicazione.getFrame().mostraMessaggioErrore("Prima devi selezionare un paziente");
                return;
            }
            List<Paziente> pazientiVisualizzati = (List<Paziente>) modello.getBean(Costanti.PAZIENTI_VISUALIZZATI);
            Paziente pazienteSelezionato = pazientiVisualizzati.get(indiceSelezionato);
            try {
                DAOUtilHibernate.beginTransaction();
                applicazione.getDaoPaziente().makePersistent(pazienteSelezionato);
                modello.putBean(Costanti.PAZIENTE_SELEZIONATO, pazienteSelezionato);
                List<Ricetta> ricette = pazienteSelezionato.getRicette();
                for (Ricetta ricetta : ricette) {
                    Hibernate.initialize(ricetta.getPrestazioni());
                }
                List<Prestazione> tutteLePrestazioni = applicazione.getDaoPrestazione().findAll();
                modello.putBean(Costanti.TUTTE_LE_PRESTAZIONI, tutteLePrestazioni);
                DAOUtilHibernate.commit();
                applicazione.getFinestraDettagliPaziente().visualizza();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
                applicazione.getFrame().mostraMessaggioErrore("Problemi con l'accesso al DB");
            }
        }

    }

    private class AzioneRicerca extends AbstractAction {

        public AzioneRicerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Cerca i pazienti per nome");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione = Applicazione.getInstance();
            PannelloPrincipale pannelloPrincipale = applicazione.getPannelloPrincipale();
            String nome = pannelloPrincipale.getNomeInserito();
            if (nome.isBlank()) {
                applicazione.getFrame().mostraMessaggioErrore("Prima devi inserire un nome");
                return;
            }
            try {
                DAOUtilHibernate.beginTransaction();
                List<Paziente> pazienti = applicazione.getDaoPaziente().findByNome(nome);
                if (pazienti.isEmpty()) {
                    applicazione.getFrame().mostraMessaggio("Nessun paziente trovato");
                } else {
                    applicazione.getModello().putBean(Costanti.PAZIENTI_VISUALIZZATI, pazienti);
                    pannelloPrincipale.aggiornaTabella();
                }
                DAOUtilHibernate.commit();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
                applicazione.getFrame().mostraMessaggioErrore("Problemi nell'accesso al database");
            }
        }

    }

}
