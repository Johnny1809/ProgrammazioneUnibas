package it.unibas.ricette.vista;

import it.unibas.ricette.modello.Ricetta;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaRicette extends AbstractTableModel {

    private List<Ricetta> ricette;

    public ModelloTabellaRicette(List<Ricetta> ricette) {
        this.ricette = ricette;
    }

    public void setRicette(List<Ricetta> ricette) {
        this.ricette = ricette;
    }

    @Override
    public int getRowCount() {
        return this.ricette.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Ricetta ricetta = ricette.get(rowIndex);
        if (columnIndex == 0) {
            return ricetta.getCodice();
        }
        if (columnIndex == 1) {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.format(ricetta.getDataCreazione().getTime());
        }
        if (columnIndex == 2) {
            return ricetta.getMotivazione();
        }
        if (columnIndex == 3) {
            return ricetta.isMutuabile();
        }
        if (columnIndex == 4) {
            return ricetta.getPrestazioni().size();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Codice";
        }
        if (columnIndex == 1) {
            return "Data Creazione";
        }
        if (columnIndex == 2) {
            return "Motivazione";
        }
        if (columnIndex == 3) {
            return "Mutuabile";
        }
        if (columnIndex == 4) {
            return "Prestazioni associate";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 3) {
            return Boolean.class;
        }
        if (columnIndex == 4) {
            return Integer.class;
        } else {
            return String.class;
        }
    }

    public void aggiornaDati() {
        this.fireTableDataChanged();
    }

}
