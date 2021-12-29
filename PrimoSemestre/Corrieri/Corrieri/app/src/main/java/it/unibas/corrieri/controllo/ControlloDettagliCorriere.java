package it.unibas.corrieri.controllo;

import android.app.Activity;
import android.view.View;

import java.util.GregorianCalendar;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityDettagliCorriere;
import it.unibas.corrieri.vista.VistaDettagliCorriere;

public class ControlloDettagliCorriere {

    private View.OnClickListener azioneNuovoPacco = new AzioneNuovoPacco();

    public View.OnClickListener getAzioneNuovoPacco() {
        return azioneNuovoPacco;
    }

    private class AzioneNuovoPacco implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            Applicazione.getInstance().getModello().putBean(Costanti.MITTENTE_SELEZIONATO, null);
            Applicazione.getInstance().getModello().putBean(Costanti.DESTINATARIO_SELEZIONATO, null);
            Applicazione.getInstance().getModello().putBean(Costanti.DATA_SELEZIONATA, new GregorianCalendar());
            ActivityDettagliCorriere activityDettagliCorrierre = (ActivityDettagliCorriere) Applicazione.getInstance().getCurrentActivity();
            activityDettagliCorrierre.mostraActivityNuovoPacco();
        }
    }
}
