package it.unibas.sondaggi.controllo;

import it.unibas.sondaggi.Applicazione;
import it.unibas.sondaggi.Costanti;
import it.unibas.sondaggi.modello.Azienda;
import it.unibas.sondaggi.modello.Risposta;
import it.unibas.sondaggi.modello.Sondaggio;
import it.unibas.sondaggi.persistenza.hibernate.DAOException;
import it.unibas.sondaggi.persistenza.hibernate.DAOUtilHibernate;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;

public class ControlloFinestraDettaglio {
    
    private Action azioneAggiungi = new AzioneAggiungi();

    public Action getAzioneAggiungi() {
        return azioneAggiungi;
    }

    private class AzioneAggiungi extends AbstractAction{

        public AzioneAggiungi() {
            this.putValue(NAME, "Aggiungi");
            this.putValue(SHORT_DESCRIPTION, "Permette di aggiungere una risposta");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt A"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_A);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Azienda azienda = Applicazione.getInstance().getFinestraDettagli().getAziendaSelezionata();
            Date dataSelezionataDate = Applicazione.getInstance().getFinestraDettagli().getDataSelezionata();
            Calendar dataSelezionata = new GregorianCalendar();
            dataSelezionata.setTime(dataSelezionataDate);
            Sondaggio sondaggio = (Sondaggio) Applicazione.getInstance().getModello().getBean(Costanti.SONDAGGIO_SELEZIONATO);
            if (dataSelezionata.after(sondaggio.getDataScadenza())){
                    Applicazione.getInstance().getVistaFrame().mostraMessaggioErrore("Inserisci una data valida");
                    return;
            }
            try {
                DAOUtilHibernate.beginTransaction();
                Applicazione.getInstance().getDaoAzienda().makePersistent(azienda);
                Risposta risposta = new Risposta();
                Applicazione.getInstance().getDaoSondaggio().makePersistent(sondaggio);
                risposta.setSondaggio(sondaggio);
                risposta.setAzienda(azienda);
                risposta.setData(dataSelezionata);
                sondaggio.addRisposta(risposta);
                Applicazione.getInstance().getFinestraDettagli().aggiornaTabellaRisposte();
                DAOUtilHibernate.commit();
            } catch (DAOException daoe) {
                Applicazione.getInstance().getVistaFrame().mostraMessaggio("Non è stato possibile accedere al DB");
                DAOUtilHibernate.rollback();
            }
            
        }
        
    }
    
}
