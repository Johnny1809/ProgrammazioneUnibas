package it.unibas.cantine.vista;

import it.unibas.cantine.modello.Annata;
import it.unibas.persistenza.hibernate.DAOUtilHibernate;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;
import org.hibernate.Hibernate;

public class ModelloTabellaAnnate extends AbstractTableModel {

    private List<Annata> annate;

    public ModelloTabellaAnnate(List<Annata> annate) {
        this.annate = annate;
    }

    @Override
    public int getRowCount() {
        return annate.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Annata annata = annate.get(rowIndex);
        if (columnIndex == 0) {
            DateFormat df = new SimpleDateFormat("MMMM", Locale.getDefault());
            Calendar mese = new GregorianCalendar();
            mese.set(Calendar.MONTH, annata.getMese());
            return df.format(mese.getTime());
        }
        if (columnIndex == 1) {
            return annata.getAnno();
        }
        if (columnIndex == 2) {
            return annata.getQualita();
        }
        if (columnIndex == 3) {
            return annata.getVino().getNome();
        }
        if (columnIndex == 4) {
            return annata.isVinoAromatico();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Mese";
        }
        if (columnIndex == 1) {
            return "Anno";
        }
        if (columnIndex == 2) {
            return "Qualità";
        }
        if (columnIndex == 3) {
            return  "Nome";
        }
        if (columnIndex == 4) {
            return  "Aromatico";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 4){
            return boolean.class;
        } else {
            return String.class;
        }
    }
    
    
    
    public void aggiornaTabella(){
        fireTableDataChanged();
    }

}
