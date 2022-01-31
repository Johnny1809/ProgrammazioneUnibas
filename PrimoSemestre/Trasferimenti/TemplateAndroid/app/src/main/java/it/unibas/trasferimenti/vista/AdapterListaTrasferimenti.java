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
import it.unibas.trasferimenti.modello.Trasferimento;

public class AdapterListaTrasferimenti extends BaseAdapter {

    private List<Trasferimento> trasferimenti;

    public AdapterListaTrasferimenti(List<Trasferimento> trasferimenti) {
        this.trasferimenti = trasferimenti;
    }

    public List<Trasferimento> getTrasferimenti() {
        return trasferimenti;
    }

    @Override
    public int getCount() {
        return trasferimenti.size();
    }

    @Override
    public Object getItem(int position) {
        return trasferimenti.get(position);
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
            vista = inflater.inflate(R.layout.riga_tabella_trasferimenti, parent, false);
        }
        TextView textViewData = vista.findViewById(R.id.textViewData);
        TextView textViewSquadraDA = vista.findViewById(R.id.textViewSquadraDa);
        TextView textViewSquadraA = vista.findViewById(R.id.textViewSquadraA);
        TextView textViewValore = vista.findViewById(R.id.textViewValore);

        Trasferimento trasferimento = trasferimenti.get(position);

        textViewSquadraDA.setText(trasferimento.getSquadraCheVende());
        textViewSquadraA.setText(trasferimento.getSquadraCheAcquista());
        textViewData.setText(trasferimento.getStringaData());
        textViewValore.setText(trasferimento.getCosto() + "");
        return vista;
    }

    public void aggiornaDati() {
        notifyDataSetChanged();
    }
}
