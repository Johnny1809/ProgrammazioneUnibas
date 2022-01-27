package it.unibas.palestra.controllo;

import android.app.Activity;
import android.view.MenuItem;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.activity.ActivityPrincipale;

public class ControlloMenuPrincipale {

    private MenuItem.OnMenuItemClickListener azioneGeneraScheda = new AzioneGeneraScheda();

    public MenuItem.OnMenuItemClickListener getAzioneGeneraScheda() {
        return azioneGeneraScheda;
    }

    private class AzioneGeneraScheda implements MenuItem.OnMenuItemClickListener {

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            ActivityPrincipale currentActivity = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            currentActivity.avviaActivityGeneraScheda();
            return false;
        }
    }

}
