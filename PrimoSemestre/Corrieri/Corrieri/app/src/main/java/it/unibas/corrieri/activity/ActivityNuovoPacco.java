package it.unibas.corrieri.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.vista.VistaNuovoPacco;

public class ActivityNuovoPacco extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuovo_pacco);
    }

    public VistaNuovoPacco getVistaNuovoPacco() {
        return (VistaNuovoPacco) getSupportFragmentManager().findFragmentById(R.id.vistaNuovoPacco);
    }

    public void avviaActivitySelezionaUtente() {
        Intent intent = new Intent(this, ActivitySelezionaUtente.class);
        startActivity(intent);
    }

    public void mostraMessaggioErrore(String errori) {
        Toast.makeText(this, errori, Toast.LENGTH_SHORT).show();
    }
}
