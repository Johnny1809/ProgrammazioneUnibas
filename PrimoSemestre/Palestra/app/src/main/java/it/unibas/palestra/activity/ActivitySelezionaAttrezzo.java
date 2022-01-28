package it.unibas.palestra.activity;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.R;
import it.unibas.palestra.vista.VistaSelezionaAttrezzo;

public class ActivitySelezionaAttrezzo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleziona_attrezzo);
    }

    public VistaSelezionaAttrezzo getVistaSelezionaAttrezzo() {
        return (VistaSelezionaAttrezzo) getSupportFragmentManager().findFragmentById(R.id.vistaSelezionaAttrezzo);
    }

    public void mostraMessaggio(String messaggio) {
        Toast.makeText(this, messaggio, Toast.LENGTH_SHORT).show();
    }

    public void finisciActivity() {
        this.finish();
    }
}
