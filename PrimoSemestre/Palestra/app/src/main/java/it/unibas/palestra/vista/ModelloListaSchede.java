package it.unibas.palestra.vista;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import it.unibas.palestra.modello.Scheda;

public class ModelloListaSchede extends BaseAdapter {

    private List<Scheda> listaSchede;

    public ModelloListaSchede(List<Scheda> listaSchede) {
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
        return null;
    }
}
