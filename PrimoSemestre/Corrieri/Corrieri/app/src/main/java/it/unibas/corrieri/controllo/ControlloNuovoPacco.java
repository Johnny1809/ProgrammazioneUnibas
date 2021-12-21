package it.unibas.corrieri.controllo;

import android.view.View;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityNuovoPacco;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.Utente;
import it.unibas.corrieri.vista.VistaNuovoPacco;

public class ControlloNuovoPacco {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();
    private View.OnClickListener azioneAggiungiMittente = new AzioneAggiungiMittente();
    private OperatoreSelezioneUtente operatoreSelezioneUtente = new OperatoreSelezioneUtente();

    public View.OnClickListener getAzioneAggiungiMittente() {
        return azioneAggiungiMittente;
    }

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    private class OperatoreSelezioneUtente {

        public void selezionaUtente() {
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            activityNuovoPacco.avviaActivitySelezionaUtente();
        }

    }

    private class AzioneAggiungiMittente implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Applicazione.getInstance().getModello().putBean(Costanti.MODALITA_SELEZIONE, Costanti.MODALITA_SELEZIONE_MITTENTE);
            operatoreSelezioneUtente.selezionaUtente();
            //TODO: far si che il blocco di codice successivo venga eseguito solo quando l'activity di selezione utente è stata terminata
            Utente mittenteSelezionato = (Utente) Applicazione.getInstance().getModello().getBean(Costanti.MITTENTE_SELEZIONATO);
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            VistaNuovoPacco vistaNuovoPacco = activityNuovoPacco.getVistaNuovoPacco();
            vistaNuovoPacco.getTextViewMittenteSelezionato().setText(mittenteSelezionato.getNome());
        }
    }

    private class AzioneNuovoPacco implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Corriere corriereSelezionato = (Corriere) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERE_SELEZIONATO);
            //preleva dataInvio, peso, urgente, mittente, destinatario dalla vistaNuovoPacco
            //effettua la convalida dei dati
            //crea pacco
            //aggiungi il pacco al corriere
            //aggiorna la vista
            //torna all'acitvity precedente
        }
    }
}
