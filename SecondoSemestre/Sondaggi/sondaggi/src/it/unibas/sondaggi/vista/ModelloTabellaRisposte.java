package it.unibas.sondaggi.vista;

import it.unibas.sondaggi.modello.Risposta;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelloTabellaRisposte extends AbstractTableModel{
    
    private List<Risposta> risposte;

    public ModelloTabellaRisposte(List<Risposta> risposte) {
        this.risposte = risposte;
    }

    public void setRisposte(List<Risposta> risposte) {
        this.risposte = risposte;
    }

    @Override
    public int getRowCount() {
        if (this.risposte == null) {
            return 0;
        }
        return risposte.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Risposta risposta = this.risposte.get(rowIndex);
        if (columnIndex == 0){
            return risposta.getAzienda().getPartitaIva();
        }
        if (columnIndex == 1){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.format(risposta.getData().getTime());
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0){
            return "Azienda";
        }
        if (columnIndex == 1){
            return "Data Sottomissione";
        }
        return "";
    }
    
    public void aggiornaTabella(){
        this.fireTableDataChanged();
    }
}
