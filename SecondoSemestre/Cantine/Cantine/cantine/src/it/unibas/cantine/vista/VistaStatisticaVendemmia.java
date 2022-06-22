package it.unibas.cantine.vista;

import it.unibas.cantine.Applicazione;
import it.unibas.cantine.Costanti;
import it.unibas.cantine.controllo.ControlloDettagli;
import it.unibas.cantine.controllo.ControlloPrincipale;
import it.unibas.cantine.modello.Annata;
import it.unibas.cantine.modello.StatisticaVendemmia;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import javax.swing.table.TableModel;

public class VistaStatisticaVendemmia extends javax.swing.JDialog {

    public VistaStatisticaVendemmia(java.awt.Frame parent) {
        super(parent, false);
    }

    public void inizializza() {
        initComponents();
        this.tabella.setModel(new ModelloTabellaVendemmie(new ArrayList<>()));
    }

    public void visualizza() {
        this.visualizzaTabella();
        this.pack();
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
    }

    public void visualizzaTabella() {
        List<StatisticaVendemmia> statistiche = (List<StatisticaVendemmia>) Applicazione.getInstance().getModello().getBean(Costanti.STATISTICA);
        ModelloTabellaVendemmie modelloTabellaVendemmie = (ModelloTabellaVendemmie) tabella.getModel();
        modelloTabellaVendemmie.setStatistica(statistiche);
        modelloTabellaVendemmie.aggiornaTabella();

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabella = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabella.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabella);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabella;
    // End of variables declaration//GEN-END:variables
}
