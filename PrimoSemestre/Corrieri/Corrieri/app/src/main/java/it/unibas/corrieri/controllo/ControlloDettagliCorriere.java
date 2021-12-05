package it.unibas.corrieri.controllo;

import android.app.Activity;
import android.view.View;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.activity.ActivityDettagliCorriere;

public class ControlloDettagliCorriere {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    private class AzioneNuovoPacco implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ActivityDettagliCorriere activityDettagliCorrierre = (ActivityDettagliCorriere) Applicazione.getInstance().getCurrentActivity();
            activityDettagliCorrierre.mostraActivityNuovoPacco();
        }
    }
}
