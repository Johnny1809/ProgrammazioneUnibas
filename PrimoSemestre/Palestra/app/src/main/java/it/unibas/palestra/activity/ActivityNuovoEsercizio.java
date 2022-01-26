package it.unibas.palestra.activity;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.palestra.R;

public class ActivityNuovoEsercizio extends AppCompatActivity {

    public static final String TAG = ActivityNuovoEsercizio.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"---------------Raggiunto l'onCreate di ActivityNuovoEsercizio-----------------------");
        super.onCreate(savedInstanceState);
        Log.d(TAG,"---------------Superato l'onCreate di ActivityNuovoEsercizio-----------------------");
        setContentView(R.layout.activity_nuovo_esercizio);
        Log.d(TAG,"---------------Superato il setContentView di ActivityNuovoEsercizio-----------------------");
    }
}