package it.unibas.trasferimenti.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.R;
import it.unibas.trasferimenti.vista.VistaPrincipale;

public class ActivityDettagliCalciatore extends AppCompatActivity {

    public static final String TAG = ActivityDettagliCalciatore.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dettagli_calciatore);
    }
}
