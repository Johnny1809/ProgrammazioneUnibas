package it.unibas.corrieri.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.corrieri.R;
import it.unibas.corrieri.vista.VistaDettagliCorriere;
import it.unibas.corrieri.vista.VistaPrincipale;

public class ActivityDettagliCorriere extends AppCompatActivity {

    public static final String TAG = ActivityDettagliCorriere.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettagli_corriere);
    }

    public VistaDettagliCorriere getVistaDettagliCorriere() {
        return (VistaDettagliCorriere) getSupportFragmentManager().findFragmentById(R.id.vistaDettagliCorriere);
    }

}
