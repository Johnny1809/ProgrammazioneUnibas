package it.unibas.corrieri.vista;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Utente;

public class AdapterUtenti extends BaseAdapter {

    private static final String TAG = AdapterUtenti.class.getSimpleName();
    private List<Utente> listaUtenti;

    public AdapterUtenti(List<Utente> listaUtenti) {
        this.listaUtenti = listaUtenti;
    }

    @Override
    public int getCount() {
        Log.d(TAG, "getCount: La size della lista è " + listaUtenti.size());
        return listaUtenti.size();
    }

    @Override
    public Object getItem(int position) {
        return listaUtenti.get(position);
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
            riga = inflater.inflate(R.layout.riga_utente, parent , false);
        } else {
            riga = convertView;
        }
        TextView via = riga.findViewById(R.id.textViewVia);
        TextView nome = riga.findViewById(R.id.textViewNome);
        nome.setText(listaUtenti.get(position).getNome());
        via.setText(listaUtenti.get(position).getVia());
        return riga;
    }

}
