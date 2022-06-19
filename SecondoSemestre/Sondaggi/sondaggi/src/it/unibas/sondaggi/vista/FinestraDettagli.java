package it.unibas.sondaggi.vista;

import it.unibas.sondaggi.Applicazione;
import it.unibas.sondaggi.Costanti;
import it.unibas.sondaggi.modello.Azienda;
import it.unibas.sondaggi.modello.Risposta;
import it.unibas.sondaggi.modello.Sondaggio;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FinestraDettagli extends javax.swing.JDialog {

    public FinestraDettagli(VistaFrame parent) {
        super(parent, false);
    }
    
    public void inizializza(){
        initComponents();
        this.bottoneAggiungi.setAction(Applicazione.getInstance().getControlloFinestraDettaglio().getAzioneAggiungi());
    }
    
    public void visualizza(){
        initLabels();
        initComboBox();
        initTabella();
        setLocationRelativeTo(this.getParent());
        setVisible(true);
    }
    
    public void initTabella(){
        Sondaggio sondaggio_selezionato = (Sondaggio) Applicazione.getInstance().getModello().getBean(Costanti.SONDAGGIO_SELEZIONATO);
        List<Risposta> risposte = sondaggio_selezionato.getRisposte();
        this.tabellaRisposte.setModel(new ModelloTabellaRisposte(risposte));
    }
    
    public void initComboBox(){
        List<Azienda> aziende = (List<Azienda>) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDE);
        this.comboAzienda.removeAllItems();
        for (Azienda azienda : aziende) {
            this.comboAzienda.addItem(azienda);
        }
    }
    
    public void initLabels(){
        Sondaggio sondaggio_selezionato = (Sondaggio) Applicazione.getInstance().getModello().getBean(Costanti.SONDAGGIO_SELEZIONATO);
        this.labelDescrizione.setText(sondaggio_selezionato.getDescrizione());
        this.labelTematica.setText(sondaggio_selezionato.getTematica());
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        this.labelScadenza.setText(format.format(sondaggio_selezionato.getDataScadenza().getTime()));
    }
    
    public void aggiornaTabellaRisposte(){
        //Sondaggio sondaggio_selezionato = (Sondaggio) Applicazione.getInstance().getModello().getBean(Costanti.SONDAGGIO_SELEZIONATO);
        //List<Risposta> risposte = sondaggio_selezionato.getRisposte();
        ModelloTabellaRisposte modelloTabellaRisposte = (ModelloTabellaRisposte) this.tabellaRisposte.getModel();
        //modelloTabellaRisposte.setRisposte(risposte);
        modelloTabellaRisposte.aggiornaTabella();
    }
    
    public Azienda getAziendaSelezionata(){
        return (Azienda) this.comboAzienda.getSelectedItem();
    }
    
    public Date getDataSelezionata(){
        return (Date) this.spinnerData.getValue();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelDescrizione = new javax.swing.JLabel();
        labelTematica = new javax.swing.JLabel();
        labelScadenza = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaRisposte = new javax.swing.JTable();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        comboAzienda = new javax.swing.JComboBox<>();
        spinnerData = new javax.swing.JSpinner();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Descrizione:");

        jLabel2.setText("Tematica:");

        jLabel3.setText("Data di Scadenza:");

        labelDescrizione.setText("jLabel4");

        labelTematica.setText("jLabel5");

        labelScadenza.setText("jLabel6");

        tabellaRisposte.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaRisposte);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuova Risposta"));

        jLabel4.setText("jLabel4");

        spinnerData.setModel(new javax.swing.SpinnerDateModel());

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(comboAzienda, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(spinnerData))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(bottoneAggiungi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboAzienda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spinnerData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneAggiungi)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelDescrizione)
                            .addComponent(labelTematica)
                            .addComponent(labelScadenza))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelDescrizione))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelTematica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelScadenza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JComboBox<Azienda> comboAzienda;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescrizione;
    private javax.swing.JLabel labelScadenza;
    private javax.swing.JLabel labelTematica;
    private javax.swing.JSpinner spinnerData;
    private javax.swing.JTable tabellaRisposte;
    // End of variables declaration//GEN-END:variables
}
