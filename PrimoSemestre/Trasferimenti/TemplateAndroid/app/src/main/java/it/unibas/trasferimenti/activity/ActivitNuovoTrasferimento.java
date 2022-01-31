package it.unibas.trasferimenti.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.Costanti;
import it.unibas.trasferimenti.R;
import it.unibas.trasferimenti.modello.Calciatore;
import it.unibas.trasferimenti.vista.VistaNuovoTrasferimento;
import it.unibas.trasferimenti.vista.VistaPrincipale;

public class ActivitNuovoTrasferimento extends AppCompatActivity {

    public static final String TAG = ActivitNuovoTrasferimento.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Applicazione.getInstance().getModello().putBean(Costanti.DATA_SELEZIONATA_NUOVO_TRASFERIMENTO, null);
        setContentView(R.layout.activity_nuovo_trasferimento);
    }

    public VistaNuovoTrasferimento getVistaNuovoTrasferimento() {
        return (VistaNuovoTrasferimento) this.getSupportFragmentManager().findFragmentById(R.id.vistaNuovoTrasferimento);
    }

    public void mostraMessaggio(String messaggio) {
        Toast.makeText(this, messaggio, Toast.LENGTH_SHORT).show();
    }
}
