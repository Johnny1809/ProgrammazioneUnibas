package it.unibas.ricette.vista;

import it.unibas.ricette.modello.Paziente;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaPazienti extends AbstractTableModel{
    
    private List<Paziente> pazienti;

    public ModelloTabellaPazienti(List<Paziente> pazienti) {
        this.pazienti = pazienti;
    }

    public void setPazienti(List<Paziente> pazienti) {
        this.pazienti = pazienti;
    }

    @Override
    public int getRowCount() {
        return this.pazienti.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Paziente paziente = pazienti.get(rowIndex);
        if (columnIndex == 0){
            return paziente.getCodiceFiscale();
        }
        if (columnIndex == 1){
            return paziente.getNome();
        }
        if (columnIndex == 2){
            return paziente.getCognome();
        }
        if (columnIndex == 3){
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            return df.format(paziente.getDataDiNascita().getTime());
        }
        if (columnIndex == 4){
            return paziente.getResidenza();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0){
            return "Codice Fiscale";
        }
        if (columnIndex == 1){
            return "Nome";
        }
        if (columnIndex == 2){
            return "Cognome";
        }
        if (columnIndex == 3){
            return "Data di Nascita";
        }
        if (columnIndex == 4){
            return "Residenza";
        }
        return "";
    }
    
    public void aggiornaDati(){
        this.fireTableDataChanged();
    }
    
}
