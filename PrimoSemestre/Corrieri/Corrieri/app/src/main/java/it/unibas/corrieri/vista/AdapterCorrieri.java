package it.unibas.corrieri.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Corriere;

public class AdapterCorrieri extends BaseAdapter {

    List<Corriere> listaCorrieri;

    public AdapterCorrieri(List<Corriere> listaCorrieri) {
        this.listaCorrieri = listaCorrieri;
    }

    public void setListaCorrieri(List<Corriere> listaCorrieri) {
        this.listaCorrieri = listaCorrieri;
    }

    @Override
    public int getCount() {
        return listaCorrieri.size();
    }

    @Override
    public Object getItem(int position) {
        return listaCorrieri.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View riga;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) Applicazione.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            riga = inflater.inflate(R.layout.riga_corriere, parent, false);
        } else {
            riga = convertView;
        }
        Corriere corriere = listaCorrieri.get(position);
        TextView labelNumero = riga.findViewById(R.id.labelNumero);
        labelNumero.setText(corriere.getNumero() + "");
        TextView labelNome = riga.findViewById(R.id.labelNome);
        labelNome.setText(corriere.getNome());
        return riga;
    }

    public void aggiornaDati() {
        this.notifyDataSetChanged();
    }

}
