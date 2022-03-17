package it.unibas.aziende.vista;

import it.unibas.aziende.Applicazione;
import it.unibas.aziende.Costanti;
import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Dipendente;
import java.util.List;

public class FinestraDettagli extends javax.swing.JDialog {

    public FinestraDettagli(Frame parent) {
        super(parent, true);
    }

    public void inizializza() {
        initComponents();
        inizializzaAzioni();
    }

    public void mostra() {
        inizializzaDatiAzienda();
        inizializzaTabella();
        this.pack();
        this.setLocationRelativeTo(getParent());
        this.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        labelIVA = new javax.swing.JLabel();
        labelDenominazione = new javax.swing.JLabel();
        labelSede = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabellaDipendenti = new javax.swing.JTable();
        bottoneEliminaDipendente = new javax.swing.JButton();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        campoCodiceFiscale = new javax.swing.JTextField();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoCognome = new javax.swing.JTextField();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel7 = new javax.swing.JLabel();
        campoAnno = new javax.swing.JTextField();
        bottoneAggiungiDipendente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("P. IVA: ");

        jLabel2.setText("Denominazione: ");

        jLabel3.setText("Sede: ");

        labelIVA.setText("jLabel4");

        labelDenominazione.setText("jLabel5");

        labelSede.setText("jLabel6");

        tabellaDipendenti.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabellaDipendenti);

        bottoneEliminaDipendente.setText("jButton1");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inserimento Dipendente"));

        jLabel4.setText("Codice Fiscale");

        jLabel5.setText("Nome");

        jLabel6.setText("Cognome");

        jLabel7.setText("Anno Assunzione");

        bottoneAggiungiDipendente.setText("jButton2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCodiceFiscale)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoCognome)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(132, 132, 132))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bottoneAggiungiDipendente, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)))
                        .addGap(6, 6, 6))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoCodiceFiscale, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoCognome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoAnno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneAggiungiDipendente))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(bottoneEliminaDipendente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(labelIVA))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelSede)
                                    .addComponent(labelDenominazione))))
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
                    .addComponent(labelIVA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(labelDenominazione))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(labelSede))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bottoneEliminaDipendente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungiDipendente;
    private javax.swing.JButton bottoneEliminaDipendente;
    private javax.swing.JTextField campoAnno;
    private javax.swing.JTextField campoCodiceFiscale;
    private javax.swing.JTextField campoCognome;
    private javax.swing.JTextField campoNome;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDenominazione;
    private javax.swing.JLabel labelIVA;
    private javax.swing.JLabel labelSede;
    private javax.swing.JTable tabellaDipendenti;
    // End of variables declaration//GEN-END:variables

    private void inizializzaDatiAzienda() {
        Azienda azienda = (Azienda) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
        this.labelIVA.setText(azienda.getPartitaIVA());
        this.labelDenominazione.setText(azienda.getDenominazione());
        this.labelSede.setText(azienda.getSede());
    }

    private void inizializzaTabella() {
        Azienda azienda = (Azienda) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
        List<Dipendente> dipendenti = azienda.getDipendenti();
        ModelloTabellaDipendenti modelloTabellaDipendenti = new ModelloTabellaDipendenti(dipendenti);
        this.tabellaDipendenti.setModel(modelloTabellaDipendenti);
    }

    public void aggiornaTabella() {
        Azienda azienda = (Azienda) Applicazione.getInstance().getModello().getBean(Costanti.AZIENDA_SELEZIONATA);
        List<Dipendente> dipendenti = azienda.getDipendenti();
        ModelloTabellaDipendenti modelloTabellaDipendenti = (ModelloTabellaDipendenti) this.tabellaDipendenti.getModel();
        modelloTabellaDipendenti.setDipendenti(dipendenti);
        modelloTabellaDipendenti.aggiorna();
    }

    public int getDipendenteSelezionato() {
        return this.tabellaDipendenti.getSelectedRow();
    }

    private void inizializzaAzioni() {
        //TODO this.bottoneEliminaDipendente.setAction(Applicazione.getInstance().getControlloFinestraDettagli().getAzioneEliminaDipendente());
        //TODO this.bottoneAggiungiDipendente.setAction(Applicazione.getInstance().getControlloFinestraDettagli().getAzioneAggiungiDipendente());
    }
    
    public String getValoreCodiceFiscale () {
        return this.campoCodiceFiscale.getText();
    }
    public String getValoreNome () {
        return this.campoNome.getText();
    }
    public String getValoreCognome () {
        return this.campoCognome.getText();
    }
    public String getValoreAnnoAssunzione () {
        return this.campoAnno.getText();
    }

}
