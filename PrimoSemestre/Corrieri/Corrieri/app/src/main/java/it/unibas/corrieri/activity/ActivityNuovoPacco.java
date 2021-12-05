package it.unibas.corrieri.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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
}
