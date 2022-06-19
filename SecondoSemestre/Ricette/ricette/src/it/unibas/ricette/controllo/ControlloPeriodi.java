package it.unibas.ricette.controllo;

import it.unibas.ricette.Applicazione;
import it.unibas.ricette.Costanti;
import it.unibas.ricette.modello.Ricetta;
import it.unibas.ricette.persistenza.DAOException;
import it.unibas.ricette.persistenza.hibernate.DAOUtilHibernate;
import it.unibas.ricette.vista.FinestraPeriodi;
import it.unibas.ricette.vista.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import static javax.swing.Action.ACCELERATOR_KEY;
import static javax.swing.Action.MNEMONIC_KEY;
import static javax.swing.Action.NAME;
import static javax.swing.Action.SHORT_DESCRIPTION;
import javax.swing.KeyStroke;
import org.hibernate.Hibernate;
import org.slf4j.LoggerFactory;

public class ControlloPeriodi {
    
    public static org.slf4j.Logger logger = LoggerFactory.getLogger(ControlloPeriodi.class);
    
    private Action azioneVerificaPeriodi = new AzioneVerificaPeriodi();

    public Action getAzioneVerificaPeriodi() {
        return azioneVerificaPeriodi;
    }

    private class AzioneVerificaPeriodi extends AbstractAction {

        public AzioneVerificaPeriodi() {
            this.putValue(NAME, "Cerca Ricette tra Periodi");
            this.putValue(SHORT_DESCRIPTION, "Cerca tutte le ricerche comprese tra le date indicate");
            this.putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl alt P"));
            this.putValue(MNEMONIC_KEY, KeyEvent.VK_P);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Applicazione applicazione = Applicazione.getInstance();
            Frame frame = applicazione.getFrame();
            FinestraPeriodi finestraPeriodi = applicazione.getFinestraPeriodi();
            Calendar inizio = new GregorianCalendar();
            inizio.setTime(finestraPeriodi.getInizioPeriodo());
            Calendar fine = new GregorianCalendar();
            fine.setTime(finestraPeriodi.getFinePeriodo());
            
            if (inizio.after(fine)) {
                frame.mostraMessaggioErrore("Attenzione, l'inzio selezionato è successivo alla fine");
                return;
            }
            try {
                DAOUtilHibernate.beginTransaction();
                List<Ricetta> ricetteTrovate = applicazione.getDaoRicetta().findByPeriodo(inizio, fine);
                for (Ricetta ricetta : ricetteTrovate) {
                    Hibernate.initialize(ricetta.getPrestazioni());
                }
                Applicazione.getInstance().getModello().putBean(Costanti.RICETTE_TROVATE, ricetteTrovate);
                finestraPeriodi.aggiornaTabella();
                DAOUtilHibernate.commit();
            } catch (DAOException ex) {
                DAOUtilHibernate.rollback();
                frame.mostraMessaggioErrore("Errore nell'accesso al DB");
            }
        }

    }

}
