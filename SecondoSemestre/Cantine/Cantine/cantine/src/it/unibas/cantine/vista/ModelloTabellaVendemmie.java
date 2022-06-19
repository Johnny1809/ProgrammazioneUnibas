package it.unibas.cantine.vista;

import it.unibas.cantine.modello.StatisticaVendemmia;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaVendemmie extends AbstractTableModel {

    private List<StatisticaVendemmia> statistica;

    public ModelloTabellaVendemmie(List<StatisticaVendemmia> annate) {
        this.statistica = annate;
    }

    public void setStatistica(List<StatisticaVendemmia> statistica) {
        this.statistica = statistica;
    }

    @Override
    public int getRowCount() {
        return statistica.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StatisticaVendemmia statisticaVendemmia = statistica.get(rowIndex);
        if (columnIndex == 0) {
            return statisticaVendemmia.getVitigno().getNomeUva();
        }
        if (columnIndex == 1) {
            return statisticaVendemmia.getMesePreferito();
        }
        if (columnIndex == 2) {
            return statisticaVendemmia.getOccorrenze();
        }
        if (columnIndex == 3) {
            return statisticaVendemmia.getQualita();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Nome";
        }
        if (columnIndex == 1) {
            return "Mese";
        }
        if (columnIndex == 2) {
            return "Occorrenze";
        }
        if (columnIndex == 3) {
            return  "Qualita";
        }
        return "";
    }
    
    public void aggiornaTabella(){
        fireTableDataChanged();
    }

}
