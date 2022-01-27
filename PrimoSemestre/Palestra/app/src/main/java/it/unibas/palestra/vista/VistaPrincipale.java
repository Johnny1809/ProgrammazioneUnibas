package it.unibas.palestra.vista;

import android.media.AsyncPlayer;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.Costanti;
import it.unibas.palestra.R;
import it.unibas.palestra.modello.Scheda;

public class VistaPrincipale extends Fragment {

    private static final String TAG = VistaPrincipale.class.getSimpleName();

    EditText campoDifficolta;
    Button bottoneCerca;
    ListView listaSchede;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false);
        campoDifficolta = vista.findViewById(R.id.campoDifficolta);
        bottoneCerca = vista.findViewById(R.id.bottoneCerca);
        listaSchede = vista.findViewById(R.id.listaSchede);

        bottoneCerca.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneCercaSchede());

        return vista;
    }

    public String getCampoDifficolta() {
        return campoDifficolta.getText().toString();
    }

    public Button getBottoneCerca() {
        return bottoneCerca;
    }

    public ListView getListaSchede() {
        return listaSchede;
    }

    public void aggiornaListaSchede() {
        List<Scheda> listaSchede = (List<Scheda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_SCHEDE);
        Log.d(TAG, "-------La lista delle schede ha dimensione pari a:" + listaSchede.size());
        AdapterListaSchede adapterListaSchede = new AdapterListaSchede(listaSchede);
        this.listaSchede.setAdapter(adapterListaSchede);
        adapterListaSchede.aggiornaDati();
    }
}
