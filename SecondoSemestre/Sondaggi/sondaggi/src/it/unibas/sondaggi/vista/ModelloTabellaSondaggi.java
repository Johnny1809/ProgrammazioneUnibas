package it.unibas.sondaggi.vista;

import it.unibas.sondaggi.modello.Sondaggio;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaSondaggi extends AbstractTableModel{

    private List<Sondaggio> sondaggi;
    
    public ModelloTabellaSondaggi (List<Sondaggio> sondaggi){
        this.sondaggi = sondaggi;
    }
    
    public void aggiornaDati(){
        this.fireTableDataChanged();
    }

    public void setSondaggi(List<Sondaggio> sondaggi) {
        this.sondaggi = sondaggi;
    }
    
    @Override
    public int getRowCount() {
        if (sondaggi == null){
            return 0;
        }
        return this.sondaggi.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sondaggio sondaggio = this.sondaggi.get(rowIndex);
        if (columnIndex == 0){
            return sondaggio.getCodice();
        }
        if (columnIndex == 1){
            return sondaggio.getDescrizione();
        }
        if (columnIndex == 2){
           return sondaggio.getTematica();
        }
        if (columnIndex == 3){
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return format.format(sondaggio.getDataScadenza().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0){
            return "Codice";
        }
        if (columnIndex == 1){
            return "Descrizione";
        }
        if (columnIndex == 2){
            return "Tematica";
        }
        if (columnIndex == 3){
            return "Data Scadenza";
        }
        return "";
    }

    
    
}
