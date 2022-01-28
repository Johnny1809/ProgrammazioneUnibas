package it.unibas.palestra.vista;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.Costanti;
import it.unibas.palestra.R;
import it.unibas.palestra.modello.Attrezzo;
import it.unibas.palestra.modello.Esercizio;
import it.unibas.palestra.modello.Scheda;

public class VistaNuovoEsercizio extends Fragment {

    TextView labelNome;
    TextView labelCodiceFiscale;
    TextView labelDifficolta;
    TextView labelDataInizio;
    TextView labelDataFine;
    TextView labelAttrezzoSelezionato;
    EditText campoPeso;
    EditText campoRipetizioni;
    ListView listaEsercizi;
    Button bottoneNuovoEsercizio;
    Button bottoneSelezionaAttrezzo;

    private final String TAG = VistaNuovoEsercizio.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG,"---------------Sto per effettuare l'inflating di vista_nuovo_esercizio-----------------------");
        View vista = inflater.inflate(R.layout.vista_nuovo_esercizio, container, false);
        Log.d(TAG,"---------------Inflating di vista_nuovo_esercizio effettuato-----------------------");
        labelNome = vista.findViewById(R.id.labelNome);
        labelCodiceFiscale = vista.findViewById(R.id.labelCodiceFiscale);
        labelDifficolta = vista.findViewById(R.id.labelDifficolta);
        labelDataInizio = vista.findViewById(R.id.labelDataInizio);
        labelDataFine = vista.findViewById(R.id.labelDataFine);
        labelAttrezzoSelezionato = vista.findViewById(R.id.labelAttrezzoSelezionato);
        listaEsercizi = vista.findViewById(R.id.listViewAttrezzi);
        campoPeso = vista.findViewById(R.id.campoPeso);
        campoRipetizioni = vista.findViewById(R.id.campoRipetizioni);
        bottoneNuovoEsercizio = vista.findViewById(R.id.bottoneNuovoEsercizio);
        bottoneSelezionaAttrezzo = vista.findViewById(R.id.bottoneSelezionaAttrezzo);
        Log.d(TAG,"---------------findViewById vari terminati-----------------------");

        bottoneSelezionaAttrezzo.setOnClickListener(Applicazione.getInstance().getControlloNuovoEsercizio().getAzioneSelezionaAttrezzo());
        bottoneNuovoEsercizio.setOnClickListener(Applicazione.getInstance().getControlloNuovoEsercizio().getAzioneNuovoEsercizio());

        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();

        Scheda schedaSelezionata = (Scheda) Applicazione.getInstance().getModello().getBean(Costanti.SCHEDA_SELEZIONATA);
        labelNome.setText(schedaSelezionata.getNome());
        labelCodiceFiscale.setText(schedaSelezionata.getCodiceFiscale());
        labelDifficolta.setText(schedaSelezionata.getDifficolta() + "");
        labelDataInizio.setText(schedaSelezionata.getStringaDataInizio());
        labelDataFine.setText(schedaSelezionata.getStringaDataFine());
        Log.d(TAG,"---------------onCreateView di VNEsercizio terminato-----------------------");

        Attrezzo attrezzoSelezionato = (Attrezzo) Applicazione.getInstance().getModello().getBean(Costanti.ATTREZZO_SELEZIONATO);
        if (attrezzoSelezionato != null) {
            labelAttrezzoSelezionato.setText(attrezzoSelezionato.getDescrizione());
        } else labelAttrezzoSelezionato.setText("Seleziona Un Attrezzo");

        this.aggiornaListaEsercizi();

    }

    public String getPeso() {
        return campoPeso.getText().toString();
    }

    public String getRipetizioni() {
        return campoRipetizioni.getText().toString();
    }

    public void setErrorePeso(String errore) {
        campoPeso.setError(errore);
    }

    public void setErroreRipetizini(String errore) {
        campoRipetizioni.setError(errore);
    }

    public void aggiornaListaEsercizi() {
        Scheda schedaSelezionata = (Scheda) Applicazione.getInstance().getModello().getBean(Costanti.SCHEDA_SELEZIONATA);
        List<Esercizio> listaEsercizi = schedaSelezionata.getEsercizi();
        AdapterListaEsercizi adapterListaEsercizi = new AdapterListaEsercizi(listaEsercizi);
        this.listaEsercizi.setAdapter(adapterListaEsercizi);
        adapterListaEsercizi.aggiornaDati();
    }
}
