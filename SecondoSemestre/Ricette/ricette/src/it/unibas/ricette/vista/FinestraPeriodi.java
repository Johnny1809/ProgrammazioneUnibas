package it.unibas.ricette.vista;

import it.unibas.ricette.Applicazione;
import it.unibas.ricette.Costanti;
import it.unibas.ricette.modello.Ricetta;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.table.TableModel;

public class FinestraPeriodi extends javax.swing.JDialog {
    
    public FinestraPeriodi(java.awt.Frame owner) {
        super(owner, false);
    }

    public void inizializza() {
        this.initComponents();
        this.bottoneVerificaPeriodi.setAction(Applicazione.getInstance().getControlloPeriodi().getAzioneVerificaPeriodi());
    }

    public void visualizza() {
        this.visualizzaTabella();
        this.setLocationRelativeTo(this.getParent());
        this.pack();
        this.setVisible(true);
    }

    private void visualizzaTabella() {
        this.tabellaRicette.setModel(new ModelloTabellaRicette(new ArrayList<>()));
    }
    
    public Date getInizioPeriodo(){
        Date inizio =  (Date) this.spinnerInizio.getValue();
        return inizio;
    }
    
    public Date getFinePeriodo(){
        Date fine = (Date) this.spinnerFine.getValue();
        return fine;
    }
    
    public void aggiornaTabella(){
        List<Ricetta> ricetteTrovate = (List<Ricetta>) Applicazione.getInstance().getModello().getBean(Costanti.RICETTE_TROVATE);
        ModelloTabellaRicette modelloTab = (ModelloTabellaRicette) this.tabellaRicette.getModel();
        modelloTab.setRicette(ricetteTrovate);
        modelloTab.aggiornaDati();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        bottoneVerificaPeriodi = new javax.swing.JButton();
        spinnerInizio = new javax.swing.JSpinner();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        spinnerFine = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaRicette = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Data di inizio");

        bottoneVerificaPeriodi.setText("jButton1");

        spinnerInizio.setModel(new javax.swing.SpinnerDateModel());

        jLabel2.setText("Data di fine");

        spinnerFine.setModel(new javax.swing.SpinnerDateModel());

        tabellaRicette.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaRicette);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bottoneVerificaPeriodi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spinnerInizio, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spinnerFine, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 296, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(spinnerInizio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(spinnerFine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneVerificaPeriodi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneVerificaPeriodi;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerFine;
    private javax.swing.JSpinner spinnerInizio;
    private javax.swing.JTable tabellaRicette;
    // End of variables declaration//GEN-END:variables
}
