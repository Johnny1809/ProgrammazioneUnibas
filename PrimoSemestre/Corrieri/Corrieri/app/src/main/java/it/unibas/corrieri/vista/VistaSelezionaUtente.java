package it.unibas.corrieri.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.List;
import java.util.zip.Inflater;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Utente;

public class VistaSelezionaUtente extends Fragment {

    ListView listaUtenti;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_seleziona_utente, container, false);
        listaUtenti = vista.findViewById(R.id.listaUtenti);
        List<Utente> tuttiGliUtenti = (List<Utente>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_UTENTI);
        listaUtenti.setAdapter(new AdapterUtenti(tuttiGliUtenti));
        listaUtenti.setOnItemClickListener(Applicazione.getInstance().getControlloSelezionaUtente().getAzioneUtenteSelezionato());
        return vista;
    }
}
