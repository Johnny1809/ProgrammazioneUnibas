package it.unibas.corrieri.vista;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import it.unibas.corrieri.Applicazione;
import it.unibas.corrieri.R;
import it.unibas.corrieri.modello.Pacco;

public class AdapterPacchi extends BaseAdapter {

    private List<Pacco> listaPacchi;

    public AdapterPacchi(List<Pacco> listaPacchi) {
        this.listaPacchi = listaPacchi;
    }

    @Override
    public int getCount() {
        return listaPacchi.size();
    }

    @Override
    public Object getItem(int position) {
        return listaPacchi.get(position);
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
            riga = inflater.inflate(R.layout.riga_pacco, parent, false);
        } else {
            riga = convertView;
        }
        TextView campoData = riga.findViewById(R.id.campoData);
        TextView campoPeso = riga.findViewById(R.id.campoPeso);
        TextView campoUrgenza = riga.findViewById(R.id.campoUrgenza);
        TextView campoMittente = riga.findViewById(R.id.campoMittente);
        TextView campoDestinatario = riga.findViewById(R.id.campoDestinatario);
        Pacco pacco = listaPacchi.get(position);
        Calendar data = pacco.getDataInvio();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG);
        campoData.setText(df.format(data.getTime()));
        campoPeso.setText(pacco.getPeso() + "");
        if (pacco.isUrgente()) {
            campoUrgenza.setText("Urgente");
        } else {
            campoUrgenza.setText("Non Urgente");
        }
        campoMittente.setText(pacco.getMittente().getNome());
        campoDestinatario.setText(pacco.getDestinatario().getNome());
        return riga;
    }

    public void aggiornaLista() {
        notifyDataSetChanged();
    }
}
