package it.unibas.corrieri.controllo;

import android.content.Intent;
import android.view.View;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityNuovoPacco;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.Pacco;

public class ControlloNuovoPacco {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();
    private View.OnClickListener azioneAggiungiMittente = new AzioneAggiungiMittente();

    public View.OnClickListener getAzioneAggiungiMittente() {
        return azioneAggiungiMittente;
    }

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    private class AzioneAggiungiMittente implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Applicazione.getInstance().getModello().putBean(Costanti.MODALITA_SELEZIONE, Costanti.MITTENTE);
            ActivityNuovoPacco activityNuovoPacco = (ActivityNuovoPacco) Applicazione.getInstance().getCurrentActivity();
            activityNuovoPacco.avviaActivitySelezionaUtente();
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
