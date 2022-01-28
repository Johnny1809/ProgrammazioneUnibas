package it.unibas.trasferimenti.vista;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.Costanti;
import it.unibas.trasferimenti.R;
import it.unibas.trasferimenti.modello.Calciatore;

public class VistaPrincipale extends Fragment {

    TextView textViewNumeroCalciatori;
    TextView textViewCriterioOrdinamento;
    ListView listViewCalciatori;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.vista_principale, container, false);
        textViewNumeroCalciatori =vista.findViewById(R.id.textViewNumeroCalciatori);
        textViewCriterioOrdinamento =vista.findViewById(R.id.textViewCriterioOrdinamento);
        listViewCalciatori = vista.findViewById(R.id.listViewCalciatori);
        listViewCalciatori.setOnItemClickListener(Applicazione.getInstance().getControlloPrincipale().getAzioneSelezionaCalciatore());
        return vista;
    }

    @Override
    public void onResume() {
        super.onResume();
        this.aggiornaDati();
    }

    public void aggiornaDati() {
        List<Calciatore> listaCalciatori = (List<Calciatore>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_CALCIATORI);
        this.textViewNumeroCalciatori.setText("Sono Presenti " + listaCalciatori.size() + " Calciatori");
        this.textViewCriterioOrdinamento.setText(Costanti.CRITERIO_ORDINAMENTO_NOME);
        AdapterListaCalciatori adapterListaCalciatori = new AdapterListaCalciatori(listaCalciatori);
        listViewCalciatori.setAdapter(adapterListaCalciatori);
        adapterListaCalciatori.aggiornaDati();
    }

}
