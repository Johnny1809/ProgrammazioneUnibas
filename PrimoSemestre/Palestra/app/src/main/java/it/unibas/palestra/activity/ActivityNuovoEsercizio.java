package it.unibas.palestra.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.palestra.R;
import it.unibas.palestra.vista.VistaNuovoEsercizio;
import it.unibas.palestra.vista.VistaSelezionaAttrezzo;

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

    public void avviaActivitySelezionaAttrezzo() {
        Intent intent = new Intent(this, ActivitySelezionaAttrezzo.class);
        this.startActivity(intent);
    }

    public VistaNuovoEsercizio getVistaNuovoEsercizio() {
        return (VistaNuovoEsercizio) this.getSupportFragmentManager().findFragmentById(R.id.vistaNuovoEsercizio);
    }

    public void mostraMessaggio(String messaggio) {
        Toast.makeText(this, messaggio, Toast.LENGTH_SHORT).show();
    }

}