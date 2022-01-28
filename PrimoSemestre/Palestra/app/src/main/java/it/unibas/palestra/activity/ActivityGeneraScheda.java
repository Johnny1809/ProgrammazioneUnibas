package it.unibas.palestra.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import it.unibas.palestra.R;
import it.unibas.palestra.vista.VistaGeneraScheda;

public class ActivityGeneraScheda extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genera_scheda);
    }

    public VistaGeneraScheda getVistaGeneraScheda() {
        return (VistaGeneraScheda) this.getSupportFragmentManager().findFragmentById(R.id.vistaGeneraScheda);
    }
}
