package it.unibas.palestra.vista;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.Costanti;
import it.unibas.palestra.R;
import it.unibas.palestra.modello.Esercizio;
import it.unibas.palestra.modello.Scheda;

public class VistaSelezionaAttrezzo extends Fragment {

    private final String TAG = VistaSelezionaAttrezzo.class.getSimpleName();

    ListView listViewAttrezzi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_seleziona_attrezzo, container, false);
        listViewAttrezzi = vista.findViewById(R.id.listViewAttrezzi);
        listViewAttrezzi.setOnItemClickListener(Applicazione.getInstance().getControlloSelezionaAttrezzo().getAzioneAttrezzoSelezionato());
        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();
        AdapterListaAttrezzi adapterListaAttrezzi = new AdapterListaAttrezzi(Applicazione.getInstance().getDaoServer().findAllAttrezzi());
        this.listViewAttrezzi.setAdapter(adapterListaAttrezzi);
        adapterListaAttrezzi.aggiornaDati();
    }

    public ListView getListViewAttrezzi() {
        return listViewAttrezzi;
    }
}
