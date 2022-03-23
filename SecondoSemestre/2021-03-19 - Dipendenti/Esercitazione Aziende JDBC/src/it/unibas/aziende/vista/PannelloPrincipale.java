package it.unibas.aziende.vista;

import it.unibas.aziende.Applicazione;
import it.unibas.aziende.Costanti;
import it.unibas.aziende.controllo.ControlloPrincipale;
import it.unibas.aziende.modello.Azienda;
import java.util.List;

public class PannelloPrincipale extends javax.swing.JPanel {

    public void inizializza(){
        initComponents();
        inizializzaTabella();
        inizializzaAzioni();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoSede = new javax.swing.JTextField();
        bottoneRicerca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaAziende = new javax.swing.JTable();
        bottoneSelezionaAzienda = new javax.swing.JButton();

        jLabel1.setText("Sede Amministrativa");

        campoSede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSedeActionPerformed(evt);
            }
        });

        bottoneRicerca.setText("Cerca");

        tabellaAziende.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaAziende);

        bottoneSelezionaAzienda.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 522, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(campoSede)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bottoneRicerca))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bottoneSelezionaAzienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoSede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneRicerca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 525, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneSelezionaAzienda)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void campoSedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSedeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSedeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneRicerca;
    private javax.swing.JButton bottoneSelezionaAzienda;
    private javax.swing.JTextField campoSede;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaAziende;
    // End of variables declaration//GEN-END:variables

    public String getValoreCampoSede(){
        return this.campoSede.getText();
    }
    
    private void inizializzaTabella(){
        List<Azienda> aziende = (List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_AZIENDE);
        ModelloTabellaAziende modelloTabellaAziende = new ModelloTabellaAziende(aziende);
        tabellaAziende.setModel(modelloTabellaAziende);
    }

    public void aggiornaTabella() {
        List<Azienda> aziende = (List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.LISTA_AZIENDE);
        ModelloTabellaAziende modelloTabellaAziende = (ModelloTabellaAziende) tabellaAziende.getModel();
        modelloTabellaAziende.setAziende(aziende);
        modelloTabellaAziende.aggiorna();
    }
    
    public int getPosizioneElementoSelezionato(){
        return tabellaAziende.getSelectedRow();
    }

    private void inizializzaAzioni() {
        ControlloPrincipale controlloPrincipale = Applicazione.getInstance().getControlloPrincipale();
        bottoneRicerca.setAction(controlloPrincipale.getAzioneRicerca());
        campoSede.setAction(controlloPrincipale.getAzioneRicerca());
        bottoneSelezionaAzienda.setAction(controlloPrincipale.getAzioneSeleziona());
    }

}

