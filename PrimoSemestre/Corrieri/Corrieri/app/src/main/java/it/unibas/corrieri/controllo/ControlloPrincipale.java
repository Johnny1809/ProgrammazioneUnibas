package it.unibas.corrieri.controllo;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.activity.ActivityPrincipale;
import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.vista.VistaPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneCerca = new AzioneCerca();
    private AdapterView.OnItemClickListener azioneSelezionaCorriere = new AzioneSelezionaCorriere();

    public View.OnClickListener getAzioneCerca() {
        return azioneCerca;
    }

    public AdapterView.OnItemClickListener getAzioneSelezionaCorriere() {
        return azioneSelezionaCorriere;
    }

    private class AzioneSelezionaCorriere implements  ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            List<Corriere> corrieri = (List<Corriere>) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERI);
            Corriere corriereSelezionato = corrieri.get(position);
            Applicazione.getInstance().getModello().putBean(Costanti.CORRIERE_SELEZIONATO, corriereSelezionato);
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            activityPrincipale.mostraActivityDettagliCorriere();
        }
    }

    private class AzioneCerca implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityPrincipale.getVistaPrincipale();
            String zona = vistaPrincipale.getCampoZona();
            //TODO: convalida
            List<Corriere> corrieri = Applicazione.getInstance().getDaoServer().findCorriereByZona(zona);
            Applicazione.getInstance().getModello().putBean(Costanti.CORRIERI, corrieri);
            vistaPrincipale.aggiornaDati();
        }
    }
}
