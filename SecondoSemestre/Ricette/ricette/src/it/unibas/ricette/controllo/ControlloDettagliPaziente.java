package it.unibas.ricette.controllo;

import it.unibas.ricette.Applicazione;
import it.unibas.ricette.Costanti;
import it.unibas.ricette.modello.Modello;
import it.unibas.ricette.modello.OperatoreRicette;
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
import java.util.logging.Level;
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

public class ControlloDettagliPaziente {

    private static final Logger logger = LoggerFactory.getLogger(ControlloDettagliPaziente.class);
    private Action azioneAggiungiPrestazione = new AzioneAggiungiPrestazione();
    private Action azioneSuggerisciRicetta = new AzioneSuggerisciRicetta();

    public Action getAzioneAggiungiPrestazione() {
        return azioneAggiungiPrestazione;
    }

    public Action getAzioneSuggerisciRicetta() {
        return azioneSuggerisciRicetta;
    }

    private class AzioneSuggerisciRicetta extends AbstractAction {

        public AzioneSuggerisciRicetta() {
            this.putValue(NAME, "Suggerisci Ricetta");
            this.putValue(SHORT_DESCRIPTION, "Suggerisce una ricetta");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt R"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione = Applicazione.getInstance();
            Modello modello = applicazione.getModello();
            FinestraDettagliPaziente finestraDettagliPaziente = applicazione.getFinestraDettagliPaziente();
            Paziente pazienteSelezionato = (Paziente) modello.getBean(Costanti.PAZIENTE_SELEZIONATO);
            Ricetta ricettaPiuRecente = pazienteSelezionato.getRicettaPiuRecente();
            if (ricettaPiuRecente == null || ricettaPiuRecente.getPrestazioni().size() == 0) {
                applicazione.getFrame().mostraMessaggioErrore("Non è stato possibile trovare la tipologia della ricetta più recente.");
                return; 
            }
            String tipologia = ricettaPiuRecente.getPrestazioni().get(0).getTipologia();
            List<Ricetta> tutteLeRicette = null;
            try {
                DAOUtilHibernate.beginTransaction();
                tutteLeRicette = applicazione.getDaoRicetta().findAll();
                for (Ricetta ricetta : tutteLeRicette) {
                    Hibernate.initialize(ricetta.getPrestazioni());
                    logger.debug("Inizializzata la ricetta " + ricetta.getCodice() + ", prestazioni della ricetta: " + ricetta.getPrestazioni());
                }
                DAOUtilHibernate.commit();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
                applicazione.getFrame().mostraMessaggioErrore("Problemi con l'accesso al DB");
                return;
            }
            List<Prestazione> prescrizioniSuggerite = new OperatoreRicette().getPrescrizioniSuggerite(tutteLeRicette, tipologia);
            Ricetta ricettaDaAggiungere = new Ricetta();
            ricettaDaAggiungere.setCodice("RCTGNR_" + new Date().getTime());
            ricettaDaAggiungere.setDataCreazione(new GregorianCalendar());
            ricettaDaAggiungere.setMotivazione("Nessuna motivazione inserita");
            ricettaDaAggiungere.setMutuabile(false);
            ricettaDaAggiungere.setPaziente(pazienteSelezionato);
            for (Prestazione prestazione : prescrizioniSuggerite) {
                ricettaDaAggiungere.addPrestazione(prestazione);
            }
            try {
                DAOUtilHibernate.beginTransaction();
                applicazione.getDaoRicetta().makePersistent(ricettaDaAggiungere);
                for (Prestazione prestazione : prescrizioniSuggerite) {
                    applicazione.getDaoPrestazione().makePersistent(prestazione);
                }
                pazienteSelezionato.addRicetta(ricettaDaAggiungere);
                DAOUtilHibernate.commit();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
                applicazione.getFrame().mostraMessaggioErrore("Problemi con l'accesso al DB");
                return;
            }
            finestraDettagliPaziente.aggiornaTabella();
        }

    }

    private class AzioneAggiungiPrestazione extends AbstractAction {

        public AzioneAggiungiPrestazione() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Aggiunge una prestazione a una ricetta selezionata");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione = Applicazione.getInstance();
            Modello modello = applicazione.getModello();
            FinestraDettagliPaziente finestraDettagliPaziente = applicazione.getFinestraDettagliPaziente();
            Paziente pazienteSelezionato = (Paziente) modello.getBean(Costanti.PAZIENTE_SELEZIONATO);
            List<Ricetta> ricetteVisualizzate = pazienteSelezionato.getRicette();
            int indiceRicette = finestraDettagliPaziente.getIndiceRicettaSelezionata();
            Prestazione prestazioneSelezionata = finestraDettagliPaziente.getPrestazioneSelezionata();
            logger.debug("Il paziente selezionato ha " + pazienteSelezionato.getRicette().size() + " ricette");
            logger.debug("La prima ricetta ha " + pazienteSelezionato.getRicette().get(0).getPrestazioni().size() + " prestazioni");
            String errori = convalida(prestazioneSelezionata, indiceRicette);
            if (!errori.isBlank()) {
                applicazione.getFrame().mostraMessaggioErrore(errori);
                return;
            }
            Ricetta ricettaSelezionata = ricetteVisualizzate.get(indiceRicette);
            if (!ricettaSelezionata.isPrestazioneConsentita(prestazioneSelezionata)) {
                applicazione.getFrame().mostraMessaggioErrore("Impossibile inserire una prestazione della seguente tipologia");
                return;
            }
            Calendar dataLimite = new GregorianCalendar();
            dataLimite.add(Calendar.DAY_OF_YEAR, -40);
            Calendar dataRicettaSelezionata = ricettaSelezionata.getDataCreazione();
            if (dataRicettaSelezionata.before(dataLimite)) {
                applicazione.getFrame().mostraMessaggioErrore("La ricetta è troppo vecchia affinché le si aggiungano prestazioni");
                return;
            }
            Ricetta ricettaDaAggiungere = ricettaSelezionata;
            if (ricettaSelezionata.getPrestazioni().size() >= 5) {
                ricettaDaAggiungere = new Ricetta();
                ricettaDaAggiungere.setCodice(ricettaSelezionata.getCodice() + '_' + new Date().getTime());
                ricettaDaAggiungere.setDataCreazione(new GregorianCalendar());
                ricettaDaAggiungere.setMotivazione(ricettaSelezionata.getMotivazione());
                ricettaDaAggiungere.setMutuabile(ricettaSelezionata.isMutuabile());
                ricettaDaAggiungere.setPaziente(ricettaSelezionata.getPaziente());
                ricettaDaAggiungere.addPrestazione(prestazioneSelezionata);
            }
            try {
                DAOUtilHibernate.beginTransaction();
                Applicazione.getInstance().getDaoRicetta().makePersistent(ricettaDaAggiungere);
                Applicazione.getInstance().getDaoPrestazione().makePersistent(prestazioneSelezionata);
                ricettaDaAggiungere.addPrestazione(prestazioneSelezionata);
                prestazioneSelezionata.addRicetta(ricettaDaAggiungere);
                DAOUtilHibernate.commit();
                finestraDettagliPaziente.aggiornaTabella();
            } catch (DAOException daoe) {
                applicazione.getFrame().mostraMessaggioErrore("Problemi con l'accesso al DB");
                DAOUtilHibernate.rollback();
            }
        }

        private String convalida(Prestazione prestazione, int indice) {
            StringBuilder errori = new StringBuilder();
            if (prestazione == null) {
                errori.append("Prima devi selezionare una prestazione\n");
            }
            if (indice == -1) {
                errori.append("Prima devi selezionare una ricetta\n");
            }
            return errori.toString().trim();
        }
    }

}
