package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.zip.Inflater;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;

public class VistaSelezionaUtente extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_seleziona_utente, container, false);
        ListView listaUtenti = vista.findViewById(R.id.listaUtenti);
        listaUtenti.setAdapter(new AdapterUtenti(Applicazione.getInstance().getDaoServer().findAllUtenti()));
        return vista;
    }
}
