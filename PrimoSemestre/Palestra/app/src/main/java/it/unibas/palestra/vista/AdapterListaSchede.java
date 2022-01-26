package it.unibas.palestra.vista;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.List;
import java.util.zip.Inflater;

import it.unibas.palestra.Applicazione;
import it.unibas.palestra.R;
import it.unibas.palestra.modello.Scheda;

public class AdapterListaSchede extends BaseAdapter {

    private List<Scheda> listaSchede;

    public AdapterListaSchede(List<Scheda> listaSchede) {
        this.listaSchede = listaSchede;
    }

    @Override
    public int getCount() {
        return listaSchede.size();
    }

    @Override
    public Object getItem(int position) {
        return listaSchede.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Scheda scheda = listaSchede.get(position);
        View vista;
        if (convertView != null) {
            vista = convertView;
        } else {
            LayoutInflater inflater = (LayoutInflater) Applicazione.getInstance().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vista = inflater.inflate(R.layout.riga_tabella_schede, parent, false);
        }
        TextView labelNome = vista.findViewById(R.id.labelNome);
        TextView labelCodiceFiscale = vista.findViewById(R.id.labelCodiceFiscale);
        TextView labelDataInizio = vista.findViewById(R.id.labelDataInizio);
        TextView labelDataFine = vista.findViewById(R.id.labelDataFine);
        labelNome.setText(scheda.getNome());
        labelCodiceFiscale.setText(scheda.getCodiceFiscale());
        String stringaDataInizio = DateFormat.getDateInstance(DateFormat.MEDIUM).format(scheda.getDataInizio().getTime());
        labelDataInizio.setText(stringaDataInizio);
        String stringaDataFine = DateFormat.getDateInstance(DateFormat.MEDIUM).format(scheda.getDataFine().getTime());
        labelDataFine.setText(stringaDataFine);
        return vista;
    }

    public void aggiornaDati() {
        super.notifyDataSetChanged();
    }
}
