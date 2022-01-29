package it.unibas.trasferimenti.controllo;

import android.util.Log;
import android.view.MenuItem;
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
    private MenuItem.OnMenuItemClickListener azioneOrdinaNome = new AzioneOrdina(Costanti.CRITERIO_ORDINAMENTO_NOME);
    private MenuItem.OnMenuItemClickListener azioneOrdinaValDec = new AzioneOrdina(Costanti.CRITERIO_ORDINAMENTO_VALORE_DEC);
    private MenuItem.OnMenuItemClickListener azioneOrdinaValCre = new AzioneOrdina(Costanti.CRITERIO_ORDINAMENTO_VALORE_CRESC);

    public MenuItem.OnMenuItemClickListener getAzioneOrdinaNome() {
        return azioneOrdinaNome;
    }

    public MenuItem.OnMenuItemClickListener getAzioneOrdinaValDec() {
        return azioneOrdinaValDec;
    }

    public MenuItem.OnMenuItemClickListener getAzioneOrdinaValCre() {
        return azioneOrdinaValCre;
    }

    public AdapterView.OnItemClickListener getAzioneSelezionaCalciatore() {
        return azioneSelezionaCalciatore;
    }

    private class AzioneOrdina implements MenuItem.OnMenuItemClickListener{

        private String criterio;

        public AzioneOrdina(String criterio) {
            this.criterio = criterio;
        }

        @Override
        public boolean onMenuItemClick(MenuItem item) {
            Applicazione.getInstance().getModello().putBean(Costanti.ORDINAMENTO_SELEZIONATO, criterio);
            String criterioOrdinamento = (String) Applicazione.getInstance().getModello().getBean(Costanti.ORDINAMENTO_SELEZIONATO);
            List<Calciatore> listaCalciatori = Applicazione.getInstance().getDaoServer().findAllCalciatori(criterioOrdinamento);
            Applicazione.getInstance().getModello().putBean(Costanti.LISTA_CALCIATORI, listaCalciatori);
            ActivityPrincipale activityPrincipale = (ActivityPrincipale) Applicazione.getInstance().getCurrentActivity();
            activityPrincipale.getVistaPrincipale().aggiornaDati();
            return false;
        }
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
