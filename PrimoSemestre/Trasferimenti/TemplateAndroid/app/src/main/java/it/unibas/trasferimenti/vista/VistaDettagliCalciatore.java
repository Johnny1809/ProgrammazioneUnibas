package it.unibas.trasferimenti.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.Costanti;
import it.unibas.trasferimenti.R;
import it.unibas.trasferimenti.modello.Calciatore;
import it.unibas.trasferimenti.modello.Trasferimento;

public class VistaDettagliCalciatore extends Fragment {

    TextView textViewNomeCalciatore;
    ListView listViewTrasferimenti;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_dettagli_calciatore, container, false);

        textViewNomeCalciatore = vista.findViewById(R.id.textViewNomeCalciatore);
        listViewTrasferimenti = vista.findViewById(R.id.listViewTrasferimenti);

        Calciatore calciatore = (Calciatore) Applicazione.getInstance().getModello().getBean(Costanti.CALCIATORE_SELEZIONATO);
        textViewNomeCalciatore.setText("Lista Trasferimenti di " + calciatore.getNome() + " " + calciatore.getCognome());

        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();
        Calciatore calciatore = (Calciatore) Applicazione.getInstance().getModello().getBean(Costanti.CALCIATORE_SELEZIONATO);
        List<Trasferimento> listaTrasferimenti = calciatore.getTrasferimenti();
        AdapterListaTrasferimenti adapterListaTrasferimenti = new AdapterListaTrasferimenti(listaTrasferimenti);
        listViewTrasferimenti.setAdapter(adapterListaTrasferimenti);
        adapterListaTrasferimenti.aggiornaDati();
    }
}
