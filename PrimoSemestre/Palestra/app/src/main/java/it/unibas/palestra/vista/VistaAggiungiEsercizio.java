package it.unibas.palestra.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.R;

public class VistaAggiungiEsercizio extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_aggiungi_esercizio, container, false);

        return vista;
    }
}
