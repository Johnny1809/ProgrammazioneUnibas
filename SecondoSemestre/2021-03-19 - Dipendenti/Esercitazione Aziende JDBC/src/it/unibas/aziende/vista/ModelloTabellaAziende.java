package it.unibas.aziende.vista;

import it.unibas.aziende.modello.Azienda;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaAziende extends AbstractTableModel{

    private List<Azienda> aziende;

    public ModelloTabellaAziende(List<Azienda> aziende) {
        this.aziende = aziende;
    }

    public void setAziende(List<Azienda> aziende) {
        this.aziende = aziende;
    }    

    @Override
    public int getRowCount() {
        if (aziende == null) {
            return  0;
        } else {
            return aziende.size();
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Azienda azienda = aziende.get(rowIndex);
        if (columnIndex == 0) {
            return azienda.getPartitaIVA();
        }
        if (columnIndex == 1) {
            return azienda.getDenominazione();
        }
        if (columnIndex == 2) {
            return azienda.getSede();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Partita IVA";
        }
        if (columnIndex == 1) {
            return "Denominazione";
        }
        if (columnIndex == 2) {
            return "Sede";
        }
        return "";
    }
    
    public void aggiorna(){
        fireTableDataChanged();
    }
    
}
