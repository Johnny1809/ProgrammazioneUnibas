package it.unibas.trasferimenti.controllo;

import android.util.Log;
import android.view.MenuItem;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.activity.ActivityDettagliCalciatore;

public class ControlloDettagliCalciatore {

    private MenuItem.OnMenuItemClickListener azioneNuovoTrasferimento = new AzioneNuovoTrasferimento();

    public MenuItem.OnMenuItemClickListener getAzioneNuovoTrasferimento() {
        return azioneNuovoTrasferimento;
    }

    private class AzioneNuovoTrasferimento implements MenuItem.OnMenuItemClickListener{

        private String TAG = AzioneNuovoTrasferimento.class.getSimpleName();

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Log.d(TAG, "onMenuItemClick: entrato nell'azione");
            ActivityDettagliCalciatore activityDettagliCalciatore = (ActivityDettagliCalciatore) Applicazione.getInstance().getCurrentActivity();
            activityDettagliCalciatore.avviaActivityNuovoTrasferimento();
            return false;
        }
    }
}
