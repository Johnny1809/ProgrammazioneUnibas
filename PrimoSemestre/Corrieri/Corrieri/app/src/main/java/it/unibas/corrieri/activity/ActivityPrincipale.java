package it.unibas.corrieri.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.corrieri.R;
import it.unibas.corrieri.vista.VistaPrincipale;

public class ActivityPrincipale extends AppCompatActivity {

    public static final String TAG = ActivityPrincipale.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);
    }

    public VistaPrincipale getVistaPrincipale() {
        return (VistaPrincipale) getSupportFragmentManager().findFragmentById(R.id.vistaPrincipale);
    }

    public void mostraActivityDettagliCorriere() {
        Intent intent = new Intent(this, ActivityDettagliCorriere.class);
        startActivity(intent);
    }

}
