package it.unibas.aziende.vista;

import it.unibas.aziende.modello.Dipendente;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaDipendenti extends AbstractTableModel {

    private List<Dipendente> dipendenti;

    public ModelloTabellaDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }

    @Override
    public int getRowCount() {
        if (dipendenti == null) return 0;
        return dipendenti.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Dipendente dipendente = this.dipendenti.get(rowIndex);
        if (columnIndex == 0) {
            return dipendente.getCodiceFiscale();
        }
        if (columnIndex == 1) {
            return dipendente.getNome();
        }
        if (columnIndex == 2) {
            return dipendente.getCognome();
        }
        if (columnIndex == 3) {
            return dipendente.getAnnoAssunzione();
        }
        return "";
    }

    @Override
    public String getColumnName(int column) {
        if (column == 0) {
            return "Codice Fiscale";
        }
        if (column == 1) {
            return "Nome";
        }
        if (column == 2) {
            return "Cognome";
        }
        if (column == 3) {
            return "Anno Assunzione";
        }
        return "";
    }
    
    public void aggiorna() {
        this.fireTableDataChanged();
    }

}
