package it.unibas.cantine.vista;

import it.unibas.cantine.modello.Vitigno;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaVitigni extends AbstractTableModel {

    private List<Vitigno> vitigni;

    public ModelloTabellaVitigni(List<Vitigno> vitigni) {
        this.vitigni = vitigni;
    }

    public void setVitigni(List<Vitigno> vitigni) {
        this.vitigni = vitigni;
    }

    @Override
    public int getRowCount() {
        return vitigni.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vitigno vitigno = vitigni.get(rowIndex);
        if (columnIndex == 0) {
            return vitigno.getNomeUva();
        }
        if (columnIndex == 1) {
            return vitigno.getPercentualeUtilizzata();
        }
        if (columnIndex == 2) {
            return vitigno.isAromatico();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome Uva";
        }
        if (columnIndex == 1) {
            return "Percentuale Utilizzata";
        }
        if (columnIndex == 2) {
            return "Aromatico";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2){
            return Boolean.class;
        } else {
            return String.class;
        }
    }

    public void aggiornaTabella() {
        fireTableDataChanged();
    }

}
