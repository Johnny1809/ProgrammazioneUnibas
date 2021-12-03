package it.unibas.corrieri.vista;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.Costanti;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Corriere;

public class VistaPrincipale extends Fragment {

    private EditText campoZona;
    private Button bottoneRicerca;
    private ListView listaCorrieri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false);
        this.campoZona = vista.findViewById(R.id.campoZona);
        this.bottoneRicerca = vista.findViewById(R.id.bottoneRicerca);
        this.listaCorrieri = vista.findViewById(R.id.listaCorrieri);
        this.bottoneRicerca.setOnClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.listaCorrieri.setOnItemClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneSelezionaCorriere());
        return vista;
    }

    public String getCampoZona(){
        return this.campoZona.getText().toString();
    }

    public void aggiornaDati() {
        List<Corriere> corrieri = (List<Corriere>) Applicazione.getInstance().getModello().getBean(Costanti.CORRIERI);
        AdapterCorrieri adapterCorrieri = new AdapterCorrieri(corrieri);
        this.listaCorrieri.setAdapter(adapterCorrieri);
    }

    public void setErroreCampoZona(String messaggio) {
        this.campoZona.setError(messaggio);
    }
}
