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

public class VistaNuovoEsercizio extends Fragment {

    TextView labelNome;
    TextView labelCodiceFiscale;
    TextView labelDifficolta;
    TextView labelDataInizio;
    TextView labelDataFine;
    ListView listaEsercizi;
    Button bottoneNuovoEsercizio;

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
        listaEsercizi = vista.findViewById(R.id.listaEsercizi);
        bottoneNuovoEsercizio = vista.findViewById(R.id.bottoneNuovoEsercizio);
        Log.d(TAG,"---------------findViewById vari terminati-----------------------");


        Scheda schedaSelezionata = (Scheda) Applicazione.getInstance().getModello().getBean(Costanti.SCHEDA_SELEZIONATA);
        labelNome.setText(schedaSelezionata.getNome());
        labelCodiceFiscale.setText(schedaSelezionata.getCodiceFiscale());
        labelDifficolta.setText(schedaSelezionata.getDifficolta() + "");
        Log.d(TAG,"--------------- BREAKPOINT VELOCE -----------------------");
        labelDataInizio.setText(schedaSelezionata.getStringaDataInizio());
        labelDataFine.setText(schedaSelezionata.getStringaDataFine());
        Log.d(TAG,"---------------onCreateView di VNEsercizio terminato-----------------------");

        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();
        Scheda schedaSelezionata = (Scheda) Applicazione.getInstance().getModello().getBean(Costanti.SCHEDA_SELEZIONATA);
        List<Esercizio> listaEsercizi = schedaSelezionata.getEsercizi();
        AdapterListaEsercizi adapterListaEsercizi = new AdapterListaEsercizi(listaEsercizi);
        this.listaEsercizi.setAdapter(adapterListaEsercizi);
        adapterListaEsercizi.aggiornaDati();
    }
}
