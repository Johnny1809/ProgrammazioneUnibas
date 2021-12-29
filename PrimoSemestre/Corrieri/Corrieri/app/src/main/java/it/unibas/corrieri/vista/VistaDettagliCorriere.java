package it.unibas.corrieri.vista;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Corriere;

public class VistaDettagliCorriere extends Fragment {

    private TextView labelNome;
    private ListView listaPacchi;
    private Button bottoneNuovoPacco;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_dettaglio_corriere, container, false);
        this.labelNome = vista.findViewById(R.id.labelNome);
        this.listaPacchi = vista.findViewById(R.id.listaPacchi);
        this.bottoneNuovoPacco = vista.findViewById(R.id.bottoneNuovoPacco);
        this.bottoneNuovoPacco.setOnClickListener(Applicazione.getInstance().getControlloDettagliCorriere().getAzioneNuovoPacco());
        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();
        aggiornaDati();
    }

    private void aggiornaDati() {
        Corriere corriere = (Corriere) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERE_SELEZIONATO);
        this.labelNome.setText(corriere.getNome());
        this.listaPacchi.setAdapter(new AdapterPacchi(corriere.getListaPacchi()));
    }

}
