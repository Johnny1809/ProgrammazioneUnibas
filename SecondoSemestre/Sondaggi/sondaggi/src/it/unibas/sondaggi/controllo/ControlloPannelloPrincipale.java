package it.unibas.sondaggi.controllo;

import it.unibas.sondaggi.Applicazione;
import it.unibas.sondaggi.Costanti;
import it.unibas.sondaggi.modello.Azienda;
import it.unibas.sondaggi.modello.Sondaggio;
import it.unibas.sondaggi.persistenza.hibernate.DAOException;
import it.unibas.sondaggi.persistenza.hibernate.DAOUtilHibernate;
import it.unibas.sondaggi.vista.PannelloPrincipale;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.KeyStroke;

public class ControlloPannelloPrincipale {
    
    private Action azioneRicerca = new AzioneRicerca();
    private Action azioneApriFinestraDettagli = new AzioneApriFinestraDettagli();

    public Action getAzioneRicerca() {
        return azioneRicerca;
    }

    public Action getAzioneApriFinestraDettagli() {
        return azioneApriFinestraDettagli;
    }
    
    private class AzioneApriFinestraDettagli extends AbstractAction{
        
        public AzioneApriFinestraDettagli() {
            this.putValue(NAME, "Dettagli");
            this.putValue(SHORT_DESCRIPTION, "Mostra i dettagli del sondaggio selezionato");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl D"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_D);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione = Applicazione.getInstance();
            PannelloPrincipale pannelloPrincipale = applicazione.getPannelloPrincipale();
            int indiceSelezionato = pannelloPrincipale.getIndiceSelezionato();
            if (indiceSelezionato == -1) {
                applicazione.getVistaFrame().mostraMessaggioErrore("Prima devi selezionare un sondaggio");
                return;
            }
            List<Sondaggio> sondaggi = (List<Sondaggio>) applicazione.getModello().getBean(Costanti.SONDAGGI_TROVATI);
            Sondaggio sondaggio = sondaggi.get(indiceSelezionato);
            applicazione.getModello().putBean(Costanti.SONDAGGIO_SELEZIONATO, sondaggio);
            try {
                DAOUtilHibernate.beginTransaction();
                applicazione.getDaoSondaggio().makePersistent(sondaggio);
                List<Azienda> aziende = applicazione.getDaoAzienda().findAll();
                applicazione.getModello().putBean(Costanti.AZIENDE, aziende);
                applicazione.getFinestraDettagli().visualizza();
                DAOUtilHibernate.commit();
            } catch (DAOException daoe) {
                DAOUtilHibernate.rollback();
            }
        }
        
    }

    private class AzioneRicerca extends AbstractAction{

        public AzioneRicerca() {
            this.putValue(NAME, "Cerca");
            this.putValue(SHORT_DESCRIPTION, "Effettua la ricerca per tematica");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl R"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_R);
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione = Applicazione.getInstance();
            PannelloPrincipale pannelloPrincipale = applicazione.getPannelloPrincipale();
            String tematica = pannelloPrincipale.getValoreTematica();
            if (tematica == null || tematica.isBlank()){
                applicazione.getVistaFrame().mostraMessaggioErrore("Prima devi inserire una tematica");
                return;
            }
            try {
                DAOUtilHibernate.beginTransaction();
                List<Sondaggio> sondaggi = applicazione.getDaoSondaggio().findByTematica(tematica);
                applicazione.getModello().putBean(Costanti.SONDAGGI_TROVATI, sondaggi);
                pannelloPrincipale.aggiornaTabella();
                DAOUtilHibernate.commit();
            } catch (DAOException daoEx) {
                DAOUtilHibernate.rollback();
                applicazione.getVistaFrame().mostraMessaggioErrore("Non è stato possibile accedere al database");
            }
            
        }
        
    }
    
}
