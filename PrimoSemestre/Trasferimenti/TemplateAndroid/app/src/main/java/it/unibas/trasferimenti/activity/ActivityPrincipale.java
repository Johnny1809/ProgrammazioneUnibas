package it.unibas.trasferimenti.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.Costanti;
import it.unibas.trasferimenti.R;
import it.unibas.trasferimenti.modello.Calciatore;
import it.unibas.trasferimenti.vista.VistaPrincipale;

public class ActivityPrincipale extends AppCompatActivity {

    public static final String TAG = ActivityPrincipale.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.aggiornaDati();
    }

    private void aggiornaDati() {
        String criterioOrdinamento = (String) Applicazione.getInstance().getModello().getBean(Costanti.ORDINAMENTO_SELEZIONATO);
        if (criterioOrdinamento == null) {
            criterioOrdinamento = Costanti.CRITERIO_ORDINAMENTO_NOME;
            Applicazione.getInstance().getModello().putBean(Costanti.ORDINAMENTO_SELEZIONATO, criterioOrdinamento);
        }
        List<Calciatore> listaCalciatori = Applicazione.getInstance().getDaoServer().findAllCalciatori(criterioOrdinamento);
        Log.d(TAG, "**************aggiornaDati di ActivityPrincipale: riferimento alla lista: " + listaCalciatori);
        Applicazione.getInstance().getModello().putBean(Costanti.LISTA_CALCIATORI, listaCalciatori);
    }

    public VistaPrincipale getVistaPrincipale() {
        return (VistaPrincipale) this.getSupportFragmentManager().findFragmentById(R.id.vistaPrincipale);
    }

    public void avviaActivityDettagliCalciatore() {
        Log.d(TAG, "avviaActivityDettagliCalciatore: lanciata");
        Intent intent = new Intent(this, ActivityDettagliCalciatore.class);
        this.startActivity(intent);
    }
}
