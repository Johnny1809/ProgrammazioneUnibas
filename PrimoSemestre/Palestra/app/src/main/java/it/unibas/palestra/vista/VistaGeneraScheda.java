package it.unibas.palestra.vista;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.Costanti;
import it.unibas.palestra.R;
import it.unibas.palestra.modello.Scheda;

public class VistaGeneraScheda extends Fragment {

    private static final String TAG = VistaGeneraScheda.class.getSimpleName();

    EditText campoCodice;
    EditText campoNome;
    EditText campoDifficolta;
    Button bottoneGeneraScheda;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_genera_scheda, container, false);
        campoCodice = vista.findViewById(R.id.campoCodiceFiscale);
        campoNome = vista.findViewById(R.id.campoNome);
        campoDifficolta = vista.findViewById(R.id.campoDifficolta);
        bottoneGeneraScheda = vista.findViewById(R.id.bottoneGeneraScheda);
        bottoneGeneraScheda.setOnClickListener(Applicazione.getInstance().getControlloGeneraScheda().getAzioneGeneraScheda());
        return vista;
    }

    public String getCodiceFiscale () {
        return this.campoCodice.getText().toString();
    }

    public String getCampoNome() {
        return this.campoNome.getText().toString();
    }

    public String getCampoDifficolta(){
        return this.campoDifficolta.getText().toString();
    }

    public void setErroreCampoDifficolta(String messaggioErrore) {
        this.campoDifficolta.setError(messaggioErrore);
    }

}
