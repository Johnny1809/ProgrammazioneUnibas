package it.unibas.trasferimenti.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import it.unibas.trasferimenti.Applicazione;
import it.unibas.trasferimenti.R;
import it.unibas.trasferimenti.modello.Calciatore;

public class AdapterListaCalciatori extends BaseAdapter {

    private List<Calciatore> calciatori;

    public AdapterListaCalciatori(List<Calciatore> calciatori) {
        this.calciatori = calciatori;
    }

    public List<Calciatore> getCalciatori() {
        return calciatori;
    }

    @Override
    public int getCount() {
        return calciatori.size();
    }

    @Override
    public Object getItem(int position) {
        return calciatori.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista;
        if (convertView != null) {
            vista = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) Applicazione.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.riga_tabella_calciatori, parent, false);
        }
        TextView textViewNome = vista.findViewById(R.id.textViewSquadraA);
        TextView textViewRuolo = vista.findViewById(R.id.textViewData);
        TextView textViewValore = vista.findViewById(R.id.textViewValore);
        Calciatore calciatore = calciatori.get(position);
        textViewNome.setText(calciatore.getNome());
        textViewRuolo.setText(calciatore.getRuolo());
        textViewValore.setText(calciatore.getValore() + "");
        return vista;
    }

    public void aggiornaDati() {
        notifyDataSetChanged();
    }
}
