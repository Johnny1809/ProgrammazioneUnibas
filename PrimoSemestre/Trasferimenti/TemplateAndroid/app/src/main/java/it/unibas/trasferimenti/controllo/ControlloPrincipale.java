package it.unibas.trasferimenti.controllo;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.Costanti;
import it.unibas.trasferimenti.activity.ActivityPrincipale;
import it.unibas.trasferimenti.modello.Calciatore;
import it.unibas.trasferimenti.vista.VistaPrincipale;

public class ControlloPrincipale {

    private AdapterView.OnItemClickListener azioneSelezionaCalciatore = new AzioneSelezionaCalciatore();

    public AdapterView.OnItemClickListener getAzioneSelezionaCalciatore() {
        return azioneSelezionaCalciatore;
    }

    private class AzioneSelezionaCalciatore implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            List<Calciatore> listaMostrata = (List<Calciatore>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_CALCIATORI);
            Calciatore calciatore = listaMostrata.get(position);
            Applicazione.getInstance().getModello().putBean(Costanti.CALCIATORE_SELEZIONATO, calciatore);
            activityPrincipale.avviaActivityDettagliCalciatore();
        }
    }

}
