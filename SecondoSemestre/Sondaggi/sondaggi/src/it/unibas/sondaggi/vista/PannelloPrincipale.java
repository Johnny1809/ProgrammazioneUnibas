package it.unibas.sondaggi.vista;

import it.unibas.sondaggi.Applicazione;
import it.unibas.sondaggi.Costanti;
import it.unibas.sondaggi.controllo.ControlloPannelloPrincipale;
import it.unibas.sondaggi.modello.Sondaggio;
import java.util.List;

public class PannelloPrincipale extends javax.swing.JPanel {

    public void inizializza(){
        initComponents();
        this.initAzioni();
        this.initTabella();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        campoTematica = new javax.swing.JTextField();
        bottoneRicercaPerTematica = new javax.swing.JButton();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaSondaggi = new javax.swing.JTable();
        bottoneDettagli = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ricerca Per Tematica"));

        campoTematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTematicaActionPerformed(evt);
            }
        });

        bottoneRicercaPerTematica.setText("jButton1");

        jLabel1.setText("Tematica");

        tabellaSondaggi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaSondaggi);

        bottoneDettagli.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(campoTematica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bottoneRicercaPerTematica))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bottoneDettagli)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTematica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneRicercaPerTematica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneDettagli)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(220, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoTematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTematicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTematicaActionPerformed

    
    public String getValoreTematica(){
        return campoTematica.getText();
    }
    
    public int getIndiceSelezionato(){
        return this.tabellaSondaggi.getSelectedRow();
    }
    
    private void initAzioni(){
        ControlloPannelloPrincipale controlloPannelloPrincipale = Applicazione.getInstance().getControlloPannelloPrincipale();
        this.bottoneRicercaPerTematica.setAction(controlloPannelloPrincipale.getAzioneRicerca());
        this.campoTematica.setAction(controlloPannelloPrincipale.getAzioneRicerca());
        this.bottoneDettagli.setAction(controlloPannelloPrincipale.getAzioneApriFinestraDettagli());
    }
    
    private void initTabella(){
        this.tabellaSondaggi.setModel(new ModelloTabellaSondaggi(null));
    }
    
    public void aggiornaTabella(){
        List<Sondaggio> sondaggi = (List<Sondaggio>) Applicazione.getInstance().getModello().getBean(Costanti.SONDAGGI_TROVATI);
        ModelloTabellaSondaggi modelloTabellaSondaggi = (ModelloTabellaSondaggi) tabellaSondaggi.getModel();
        modelloTabellaSondaggi.setSondaggi(sondaggi);
        modelloTabellaSondaggi.aggiornaDati();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneDettagli;
    private javax.swing.JButton bottoneRicercaPerTematica;
    private javax.swing.JTextField campoTematica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaSondaggi;
    // End of variables declaration//GEN-END:variables
}
