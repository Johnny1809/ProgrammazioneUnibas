package it.unibas.cantine.vista;

import it.unibas.cantine.Applicazione;
import it.unibas.cantine.Costanti;
import it.unibas.cantine.modello.Annata;
import java.util.ArrayList;
import java.util.List;

public class PannelloPrincipale extends javax.swing.JPanel {

    public void inizializza(){
        initComponents();
        this.tabellaAnnate.setModel(new ModelloTabellaAnnate(new ArrayList<>()));
        initAzioni();
    }
    
    public void aggiornaTabella(){
        List<Annata> annate = (List<Annata>) Applicazione.getInstance().getModello().getBean(Costanti.ANNATE_TROVATE);
        this.tabellaAnnate.setModel(new ModelloTabellaAnnate(annate));
        ModelloTabellaAnnate modelloTabellaAnnate = (ModelloTabellaAnnate) this.tabellaAnnate.getModel();
        modelloTabellaAnnate.aggiornaTabella();
    }
    
    public void initAzioni(){
        this.bottoneCerca.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneCerca());
        this.bottoneDettagli.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneDettagli());
        this.bottoneMesiVendemmia.setAction(Applicazione.getInstance().getControlloPrincipale().getAzioneStatistica());
    }
    
    public Integer getAnnata(){
        return (Integer) spinnerAnnata.getValue();
    }
    
    public int getIndiceAnnataSelezionata(){
        return this.tabellaAnnate.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        spinnerAnnata = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAnnate = new javax.swing.JTable();
        bottoneMesiVendemmia = new javax.swing.JButton();
        bottoneCerca = new javax.swing.JButton();
        bottoneDettagli = new javax.swing.JButton();

        jLabel1.setText("Annata:");

        spinnerAnnata.setModel(new javax.swing.SpinnerNumberModel(2000, null, null, 1));

        tabellaAnnate.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAnnate);

        bottoneMesiVendemmia.setText("jButton1");

        bottoneCerca.setText("jButton1");

        bottoneDettagli.setText("jButton1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spinnerAnnata, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottoneCerca))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bottoneMesiVendemmia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottoneDettagli)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spinnerAnnata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottoneMesiVendemmia)
                    .addComponent(bottoneDettagli))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneDettagli;
    private javax.swing.JButton bottoneMesiVendemmia;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spinnerAnnata;
    private javax.swing.JTable tabellaAnnate;
    // End of variables declaration//GEN-END:variables
}
