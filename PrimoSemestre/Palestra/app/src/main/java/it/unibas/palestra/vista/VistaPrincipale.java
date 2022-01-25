package it.unibas.palestra.vista;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import it.unibas.palestra.R;

public class VistaPrincipale extends Fragment {

    EditText campoDifficolta;
    Button bottoneCerca;
    ListView listaSchede;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false);
        campoDifficolta = vista.findViewById(R.id.campoDifficolta);
        bottoneCerca = vista.findViewById(R.id.bottoneCerca);
        listaSchede = vista.findViewById(R.id.listaSchede);
        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();
        //TODO: aggiornaDati della lista
    }
}
