package it.unibas.ricette.vista;

import it.unibas.ricette.Applicazione;
import it.unibas.ricette.Costanti;
import it.unibas.ricette.controllo.ControlloPrincipale;
import it.unibas.ricette.modello.Paziente;
import java.util.ArrayList;
import java.util.List;

public class PannelloPrincipale extends javax.swing.JPanel {

    public void inizializza() {
        this.initComponents();
        this.initTabella();
        this.inizializzaAzioni();
    }

    public void initTabella() {
        this.tabellaPazienti.setModel(new ModelloTabellaPazienti(new ArrayList<>()));
    }

    public void aggiornaTabella() {
        List<Paziente> pazienti = (List<Paziente>) Applicazione.getInstance().getModello().getBean(Costanti.PAZIENTI_VISUALIZZATI);
        ModelloTabellaPazienti modelloTabella = (ModelloTabellaPazienti) this.tabellaPazienti.getModel();
        modelloTabella.setPazienti(pazienti);
        modelloTabella.aggiornaDati();
    }

    private void inizializzaAzioni() {
        ControlloPrincipale controlloPrincipale = Applicazione.getInstance().getControlloPrincipale();
        this.bottoneCerca.setAction(controlloPrincipale.getAzioneCerca());
        this.campoNome.setAction(controlloPrincipale.getAzioneCerca());
        this.bottoneDettagli.setAction(controlloPrincipale.getAzioneDettagliPaziente());
        this.bottoneVerificaPeriodi.setAction(controlloPrincipale.getAzioneApriFinestraPeriodi());
    }

    public String getNomeInserito() {
        return this.campoNome.getText();
    }
    
    public int getIndiceSelezionato(){
        return this.tabellaPazienti.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        bottoneCerca = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaPazienti = new javax.swing.JTable();
        bottoneDettagli = new javax.swing.JButton();
        bottoneVerificaPeriodi = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Ricette Mediche"));

        jLabel1.setText("Nome Paziente:");

        campoNome.setText("Alfredo");

        bottoneCerca.setText("jButton1");

        tabellaPazienti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaPazienti);

        bottoneDettagli.setText("jButton1");

        bottoneVerificaPeriodi.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bottoneCerca))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(bottoneVerificaPeriodi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bottoneDettagli)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneCerca))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bottoneDettagli)
                    .addComponent(bottoneVerificaPeriodi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneCerca;
    private javax.swing.JButton bottoneDettagli;
    private javax.swing.JButton bottoneVerificaPeriodi;
    private javax.swing.JTextField campoNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabellaPazienti;
    // End of variables declaration//GEN-END:variables

}
