package it.unibas.cantine.controllo;

import it.unibas.cantine.Applicazione;
import it.unibas.cantine.Costanti;
import it.unibas.cantine.modello.Annata;
import it.unibas.cantine.modello.Modello;
import it.unibas.cantine.modello.Vitigno;
import it.unibas.cantine.vista.VistaDettagli;
import it.unibas.persistenza.DAOException;
import it.unibas.persistenza.hibernate.DAOUtilHibernate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloDettagli {
    
    private Action azioneAggiungiVitigno = new AzioneAggiungiVitigno();

    public Action getAzioneAggiungiVitigno() {
        return azioneAggiungiVitigno;
    }
    
    
    private class AzioneAggiungiVitigno extends AbstractAction {

        public AzioneAggiungiVitigno() {
            putValue(NAME, "Aggiungi");
            putValue(SHORT_DESCRIPTION, "Aggiunge un nuovo vitigno");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl A"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione = Applicazione.getInstance();
            VistaDettagli vistaDettagli = applicazione.getVistaDettagli();
            Modello modello = applicazione.getModello();
            String nomeUva = vistaDettagli.getNomeUva();
            String percentualeString = vistaDettagli.getPercentualeUtilizzata();
            Float percentuale = null;
            try {
                percentuale = Float.parseFloat(percentualeString);
            } catch (NumberFormatException nfe) {
                applicazione.getFrame().mostraMessaggioErrore("Inserisci una percentuale valida");
                return;
            }
            boolean aromatico = vistaDettagli.isAromatico();
            if (nomeUva.isBlank() || percentualeString.isBlank()) {
                applicazione.getFrame().mostraMessaggioErrore("Prima inserisci nome e percentuale");
                return;
            }
            Annata annataSelezionata = (Annata) modello.getBean(Costanti.ANNATA_SELEZIONATA);
            Vitigno nuovoVitigno = new Vitigno();
            nuovoVitigno.setNomeUva(nomeUva);
            nuovoVitigno.setPercentualeUtilizzata(percentuale);
            nuovoVitigno.setAromatico(aromatico);
            nuovoVitigno.setAnnata(annataSelezionata);
            if (!annataSelezionata.isVitignoInseribile(nuovoVitigno)){
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Inserisci un vitigno valido");
                return;
            }
            try {
                DAOUtilHibernate.beginTransaction();
                applicazione.getDaoAnnata().makePersistent(annataSelezionata);
                applicazione.getDaoVitigno().makePersistent(nuovoVitigno);
                annataSelezionata.getVitigni().add(nuovoVitigno);
                DAOUtilHibernate.commit();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
                applicazione.getFrame().mostraMessaggioErrore("Problemi nell'accesso al db");
            }
            vistaDettagli.aggiornaTabella();
        }
    }

}
