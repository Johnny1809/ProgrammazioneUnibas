package it.unibas.palestra.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.R;
import it.unibas.palestra.modello.Esercizio;
import it.unibas.palestra.modello.Scheda;

public class AdapterListaEsercizi extends BaseAdapter {

    private List<Esercizio> listaEsercizi;

    public AdapterListaEsercizi(List<Esercizio> listaEsercizi) {
        this.listaEsercizi = listaEsercizi;
    }

    @Override
    public int getCount() {
        return listaEsercizi.size();
    }

    @Override
    public Object getItem(int position) {
        return listaEsercizi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Esercizio esercizio = listaEsercizi.get(position);
        View vista;
        if (convertView != null) {
            vista = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) Applicazione.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.riga_tabella_esercizi, parent, false);
        }
        TextView labelAttrezzo = vista.findViewById(R.id.labelAttrezzo);
        TextView labelPeso = vista.findViewById(R.id.labelPeso);
        TextView labelRipetizioni = vista.findViewById(R.id.labelRipetizioni);
        labelAttrezzo.setText(esercizio.getAttrezzo().getDescrizione());
        labelPeso.setText(esercizio.getPeso() + "");
        labelRipetizioni.setText(esercizio.getRipetizioni() + "");
        return vista;
    }

    public void aggiornaDati() {
        super.notifyDataSetChanged();
    }
}
