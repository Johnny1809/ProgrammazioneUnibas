package it.unibas.isee.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.unibas.isee.Applicazione;
import it.unibas.isee.R;
import it.unibas.isee.modello.ModuloIsee;

public class AdapterStoriaCalcoli extends BaseAdapter {

    private List<ModuloIsee> listaModuli;

    public static final String TAG = AdapterStoriaCalcoli.class.getSimpleName();

    public AdapterStoriaCalcoli(List<ModuloIsee> listaModuli) {
        this.listaModuli = listaModuli;
    }

    @Override
    public int getCount() {
        if (listaModuli == null) {
            return 0;
        }
        return listaModuli.size();
    }

    @Override
    public Object getItem(int position) {
        return listaModuli.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View riga;
        if (convertView == null) {
            Applicazione applicazione = Applicazione.getInstance();
            LayoutInflater layoutInflater = (LayoutInflater) applicazione.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            riga = layoutInflater.inflate(R.layout.riga_storia, parent,false);
        } else {
            riga = convertView;
        }
        //recupero il modulo con cui compilare la riga
        ModuloIsee moduloIsee = listaModuli.get(position);
        //salvo i riferimenti ai componenti della riga
        TextView campoReddito = riga.findViewById(R.id.campoReddito);
        TextView campoPatrimonio = riga.findViewById(R.id.campoPatrimonio);
        TextView campoMinori = riga.findViewById(R.id.campoMinori);
        TextView campoIsee = riga.findViewById(R.id.campoIsee);
        //compilo la riga
        campoReddito.setText("Reddito: " + moduloIsee.getReddito());
        campoPatrimonio.setText("Patrimonio: " + moduloIsee.getPatrimonio());
        if (moduloIsee.isPresenzaMinori()) {
            campoMinori.setText("Presenza di Minori");
        } else {
            campoMinori.setText("Assenza di Minori");
        }
        campoIsee.setText(moduloIsee.getStringaValoreISEE());
        return riga;
    }

    public void aggiornaContenuto() {
        notifyDataSetChanged();
    }

}
