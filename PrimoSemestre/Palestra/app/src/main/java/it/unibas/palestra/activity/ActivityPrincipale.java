package it.unibas.palestra.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import it.unibas.palestra.R;
import it.unibas.palestra.vista.VistaPrincipale;

public class ActivityPrincipale extends AppCompatActivity {

    public static final String TAG = ActivityPrincipale.class.getSimpleName();
    //TODO iniziare da qui a scrivere il menu?
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
    }

    public VistaPrincipale getVistaPrincipale() {
        return (VistaPrincipale) this.getSupportFragmentManager().findFragmentById(R.id.vistaPrincipale);
    }

    public void avviaActivityAggiungiEsercizio() {
        Intent intent = new Intent(this, ActivityNuovoEsercizio.class);
        startActivity(intent);
    }

}
