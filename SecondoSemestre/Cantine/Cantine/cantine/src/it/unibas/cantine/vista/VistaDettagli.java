package it.unibas.cantine.vista;

import it.unibas.cantine.Applicazione;
import it.unibas.cantine.Costanti;
import it.unibas.cantine.controllo.ControlloDettagli;
import it.unibas.cantine.modello.Annata;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.table.TableModel;

public class VistaDettagli extends javax.swing.JDialog {

    public VistaDettagli(java.awt.Frame parent) {
        super(parent, true);
    }

    public void inizializza() {
        initComponents();
        this.tabellaVitigni.setModel(new ModelloTabellaVitigni(new ArrayList<>()));
        ControlloDettagli controlloDettagli = Applicazione.getInstance().getControlloDettagli();
        this.bottoneAggiungi.setAction(controlloDettagli.getAzioneAggiungiVitigno());
    }

    public void visualizza() {
        this.inizializzaComponenti();
        this.visualizzaTabella();
        this.pack();
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
    }

    private void inizializzaComponenti() {
        Annata annataSelezionata = (Annata) Applicazione.getInstance().getModello().getBean(Costanti.ANNATA_SELEZIONATA);
        DateFormat df = new SimpleDateFormat("MMMM", Locale.getDefault());
        Calendar mese = new GregorianCalendar();
        mese.set(Calendar.MONTH, annataSelezionata.getMese());
        this.labelMese.setText(df.format(mese.getTime()));
        this.labelAnno.setText("" + annataSelezionata.getAnno());
        this.labelVino.setText(annataSelezionata.getVino().getNome());
        this.labelTipo.setText(annataSelezionata.getVino().getTipo());
    }

    public void visualizzaTabella() {
        Annata annataSelezionata = (Annata) Applicazione.getInstance().getModello().getBean(Costanti.ANNATA_SELEZIONATA);
        ModelloTabellaVitigni modelloTabella = (ModelloTabellaVitigni) this.tabellaVitigni.getModel();
        modelloTabella.setVitigni(annataSelezionata.getVitigni());
    }

    public void aggiornaTabella() {
        ModelloTabellaVitigni modelloTabella = (ModelloTabellaVitigni) this.tabellaVitigni.getModel();
        modelloTabella.aggiornaTabella();
    }
    
    public String getNomeUva(){
        return this.campoNomeUva.getText();
    }
    
    public String getPercentualeUtilizzata(){
        return this.campoPercentuale.getText();
    }
    
    public boolean isAromatico(){
        return checkAromatico.isSelected();
    } 
    
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        labelMese = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelAnno = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        labelVino = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        labelTipo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaVitigni = new javax.swing.JTable();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        campoNomeUva = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        campoPercentuale = new javax.swing.JTextField();
        checkAromatico = new javax.swing.JCheckBox();
        bottoneAggiungi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Mese:");

        labelMese.setText("jLabel2");

        jLabel3.setText("Anno:");

        labelAnno.setText("jLabel4");

        jLabel5.setText("Vino:");

        labelVino.setText("jLabel6");

        jLabel7.setText("Tipo:");

        labelTipo.setText("jLabel8");

        tabellaVitigni.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaVitigni);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuovo Vitigno"));

        jLabel2.setText("Nome dell'uva:");

        campoNomeUva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoNomeUvaActionPerformed(evt);
            }
        });

        jLabel4.setText("Percentuale Utilizzata:");

        checkAromatico.setText("Aromatico");
        checkAromatico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkAromaticoActionPerformed(evt);
            }
        });

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(checkAromatico, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNomeUva)
                            .addComponent(campoPercentuale, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
                .addContainerGap(383, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bottoneAggiungi)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNomeUva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoPercentuale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(checkAromatico)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneAggiungi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 698, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelMese, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelAnno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelVino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(labelTipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelMese))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelAnno))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelVino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(labelTipo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void campoNomeUvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoNomeUvaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoNomeUvaActionPerformed

    private void checkAromaticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkAromaticoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkAromaticoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JTextField campoNomeUva;
    private javax.swing.JTextField campoPercentuale;
    private javax.swing.JCheckBox checkAromatico;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelAnno;
    private javax.swing.JLabel labelMese;
    private javax.swing.JLabel labelTipo;
    private javax.swing.JLabel labelVino;
    private javax.swing.JTable tabellaVitigni;
    // End of variables declaration//GEN-END:variables
}
