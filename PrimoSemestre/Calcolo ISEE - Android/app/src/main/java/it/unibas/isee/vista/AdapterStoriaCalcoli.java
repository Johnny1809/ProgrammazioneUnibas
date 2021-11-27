package it.unibas.isee.vista;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

import it.unibas.isee.modello.ModuloIsee;

public class AdapterStoriaCalcoli extends BaseAdapter {

    private List<ModuloIsee> listaModuli = new ArrayList<>();

    public AdapterStoriaCalcoli(List<ModuloIsee> listaModuli) {
        this.listaModuli = listaModuli;
    }

    @Override
    public int getCount() {
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

        }
        return null;
    }
}
