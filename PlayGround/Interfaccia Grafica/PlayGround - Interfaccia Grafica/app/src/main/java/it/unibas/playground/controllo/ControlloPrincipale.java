package it.unibas.playground.controllo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

import it.unibas.playground.Applicazione;
import it.unibas.playground.activity.ActivityPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneStartActivityForResult = new AzioneStartActivityForResult();
    private View.OnClickListener azioneApriGoogle = new AzioneApriGoogle();

    public View.OnClickListener getAzioneApriGoogle() {
        return azioneApriGoogle;
    }

    public View.OnClickListener getAzioneStartActivityForResult() {
        return azioneStartActivityForResult;
    }

    private class AzioneApriGoogle implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            //Intent intent =  new Intent(Intent.ACTION_VIEW);
            Intent intent = new Intent();
            intent.setAction(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("https://www.google.it/"));
            Applicazione.getInstance().getCurrentActivity().startActivity(intent);
        }
    }

    private class AzioneStartActivityForResult implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            activityPrincipale.lanciaActivitySelezioneFile();
        }
    }

}
