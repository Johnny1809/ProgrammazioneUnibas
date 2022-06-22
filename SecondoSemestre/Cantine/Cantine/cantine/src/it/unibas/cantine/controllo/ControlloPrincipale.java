package it.unibas.cantine.controllo;

import it.unibas.cantine.Applicazione;
import it.unibas.cantine.Costanti;
import it.unibas.cantine.modello.Annata;
import it.unibas.cantine.modello.OperatoreStatisticaVendemmia;
import it.unibas.cantine.modello.StatisticaVendemmia;
import it.unibas.cantine.modello.Vitigno;
import it.unibas.cantine.vista.PannelloPrincipale;
import it.unibas.persistenza.DAOException;
import it.unibas.persistenza.hibernate.DAOUtilHibernate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;
import org.hibernate.Hibernate;

public class ControlloPrincipale {

    private Action azioneCerca = new AzioneCerca();
    private Action azioneDettagli = new AzioneDettagli();
    private Action azioneStatistica = new AzioneCercaMesiVendemmia();

    public Action getAzioneCerca() {
        return azioneCerca;
    }

    public Action getAzioneDettagli() {
        return azioneDettagli;
    }

    public Action getAzioneStatistica() {
        return azioneStatistica;
    }
    
    private class AzioneCercaMesiVendemmia extends AbstractAction{

        public AzioneCercaMesiVendemmia() {
            putValue(NAME, "Dettagli");
            putValue(SHORT_DESCRIPTION, "Mostra Dettagli Annata");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_D);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            List<Vitigno> tuttiIVitigni = null;
            try {
                DAOUtilHibernate.beginTransaction();
                tuttiIVitigni = Applicazione.getInstance().getDaoVitigno().findAll();
                DAOUtilHibernate.rollback();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nell'accesso al db");
                return;
            }
            if (tuttiIVitigni == null){
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Errore nell'accesso al db");
                return; 
            }
            List<StatisticaVendemmia> stat = new OperatoreStatisticaVendemmia().calcolaStatistica(tuttiIVitigni);
            Applicazione.getInstance().getModello().putBean(Costanti.STATISTICA, stat);
            Applicazione.getInstance().getVistaStatisticaVendemmia().visualizza();
        }

        
    }
    
    private class AzioneDettagli extends AbstractAction {
         
        public AzioneDettagli(){
            putValue(NAME, "Dettagli");
            putValue(SHORT_DESCRIPTION, "Mostra Dettagli Annata");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt D"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_D);
        }
         
        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione= Applicazione.getInstance();
            PannelloPrincipale pannelloPrincipale = applicazione.getPannelloPrincipale();
            int indice = pannelloPrincipale.getIndiceAnnataSelezionata();
            if (indice == -1){
                applicazione.getFrame().mostraMessaggioErrore("Prima devi selezionare una annata");
                return;
            }
            List<Annata> annate = (List<Annata>) applicazione.getModello().getBean(Costanti.ANNATE_TROVATE);
            Annata annata = annate.get(indice);
            try {
                DAOUtilHibernate.beginTransaction();
                applicazione.getDaoAnnata().makePersistent(annata);
                Hibernate.initialize(annata.getVitigni());
                DAOUtilHibernate.commit();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
                applicazione.getFrame().mostraMessaggioErrore("Problemi nell'accesso al db");
            }
            applicazione.getModello().putBean(Costanti.ANNATA_SELEZIONATA, annata);
            applicazione.getVistaDettagli().visualizza();
        }
        
    }
    
    private class AzioneCerca extends AbstractAction{
        
        public AzioneCerca(){
            putValue(NAME, "Cerca");
            putValue(SHORT_DESCRIPTION, "Cerca per annata");
            putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt C"));
            putValue(MNEMONIC_KEY, KeyEvent.VK_C);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int anno = Applicazione.getInstance().getPannelloPrincipale().getAnnata();
            try {
                DAOUtilHibernate.beginTransaction();
                List<Annata> annate = Applicazione.getInstance().getDaoAnnata().findByAnno(anno);
                Applicazione.getInstance().getModello().putBean(Costanti.ANNATE_TROVATE, annate);
                for (Annata annata : annate) {
                    Hibernate.initialize(annata.getVitigni());
                }
                Applicazione.getInstance().getPannelloPrincipale().aggiornaTabella();
                DAOUtilHibernate.commit();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
                Applicazione.getInstance().getFrame().mostraMessaggioErrore("Problemi nell'accesso al db");
            }
        }
        
    }
    
}
