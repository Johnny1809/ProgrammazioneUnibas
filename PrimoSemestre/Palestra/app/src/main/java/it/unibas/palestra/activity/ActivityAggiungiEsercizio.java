package it.unibas.palestra.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.palestra.R;

public class ActivityAggiungiEsercizio extends AppCompatActivity {

    public static final String TAG = ActivityAggiungiEsercizio.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aggiungi_esercizio);
    }
}