package it.unibas.palestra.controllo;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.Costanti;
import it.unibas.palestra.activity.ActivityPrincipale;
import it.unibas.palestra.modello.Modello;
import it.unibas.palestra.modello.Scheda;
import it.unibas.palestra.persistenza.IDAOServer;
import it.unibas.palestra.vista.VistaPrincipale;

public class ControlloPrincipale {

    private View.OnClickListener azioneCercaSchede = new AzioneCercaSchede();

    public AdapterView.OnItemClickListener getAzioneSelezionaSchede() {
        return azioneSelezionaSchede;
    }

    private AdapterView.OnItemClickListener azioneSelezionaSchede = new AzioneSelezionaScheda();

    public View.OnClickListener getAzioneCercaSchede() {
        return azioneCercaSchede;
    }

    private class AzioneSelezionaScheda implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            List<Scheda> listaSchede = (List<Scheda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_SCHEDE);
            Scheda schedaSelezionata = listaSchede.get(position);
            Applicazione.getInstance().getModello().putBean(Costanti.SCHEDA_SELEZIONATA, schedaSelezionata);
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            activityPrincipale.avviaActivityAggiungiEsercizio();
        }
    }

    private class AzioneCercaSchede implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            IDAOServer daoServer = Applicazione.getInstance().getDaoServer();
            ActivityPrincipale activityCorrente = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            VistaPrincipale vistaPrincipale = activityCorrente.getVistaPrincipale();
            int difficolta = Integer.parseInt(vistaPrincipale.getCampoDifficolta());
            List<Scheda> listaSchede = daoServer.findSchedaByDifficolta(difficolta);
            Modello modello = Applicazione.getInstance().getModello();
            modello.putBean(Costanti.LISTA_SCHEDE, listaSchede);
            vistaPrincipale.aggiornaListaSchede();
        }
    }

}
