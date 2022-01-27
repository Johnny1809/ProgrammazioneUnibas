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
import it.unibas.palestra.modello.Attrezzo;
import it.unibas.palestra.modello.Scheda;

public class AdapterListaAttrezzi extends BaseAdapter {

    private List<Attrezzo> listaAttrezzi;

    public AdapterListaAttrezzi(List<Attrezzo> listaAttrezzi) {
        this.listaAttrezzi = listaAttrezzi;
    }

    @Override
    public int getCount() {
        return listaAttrezzi.size();
    }

    @Override
    public Object getItem(int position) {
        return listaAttrezzi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Attrezzo attrezzo = listaAttrezzi.get(position);
        View vista;
        if (convertView != null) {
            vista = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) Applicazione.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.riga_tabella_attrezzi, parent, false);
        }
        TextView labelCodice = vista.findViewById(R.id.labelCodice);
        TextView labelDescrizione = vista.findViewById(R.id.labelDescrizione);
        TextView labelParteDelCorpo = vista.findViewById(R.id.labelParteDelCorpo);
        labelCodice.setText(attrezzo.getCodice());
        labelDescrizione.setText(attrezzo.getDescrizione());
        labelParteDelCorpo.setText(attrezzo.getParte());
        return vista;
    }

    public void aggiornaDati() {
        super.notifyDataSetChanged();
    }
}
