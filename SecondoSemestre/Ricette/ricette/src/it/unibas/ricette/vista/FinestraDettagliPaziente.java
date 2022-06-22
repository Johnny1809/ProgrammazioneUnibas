package it.unibas.ricette.vista;

import it.unibas.ricette.Applicazione;
import it.unibas.ricette.Costanti;
import it.unibas.ricette.controllo.ControlloDettagliPaziente;
import it.unibas.ricette.modello.Paziente;
import it.unibas.ricette.modello.Prestazione;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.table.TableModel;

public class FinestraDettagliPaziente extends javax.swing.JDialog {

    public FinestraDettagliPaziente(Frame owner) {
        super(owner, false);
    }

    public void inizializza() {
        this.initComponents();
        this.tableRicette.setModel(new ModelloTabellaRicette(new ArrayList<>()));
        this.initAzioni();
    }

    public void visualizza() {
        this.initComponenti();
        this.visualizzaTabella();
        this.setLocationRelativeTo(this.getParent());
        this.pack();
        this.setVisible(true);
    }

    private void initComponenti() {
        Paziente pazienteSelezionato = (Paziente) Applicazione.getInstance().getModello().getBean(Costanti.PAZIENTE_SELEZIONATO);
        this.labelCF.setText(pazienteSelezionato.getCodiceFiscale());
        this.labelNome.setText(pazienteSelezionato.getNome());
        this.labelCognome.setText(pazienteSelezionato.getCognome());
        this.labelResidenza.setText(pazienteSelezionato.getResidenza());
        Calendar dataNascita = pazienteSelezionato.getDataDiNascita();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        this.labelDataDiNascita.setText(df.format(dataNascita.getTime()));
        this.comboPrestazione.removeAllItems();
        List<Prestazione> prestazioni = (List<Prestazione>) Applicazione.getInstance().getModello().getBean(Costanti.TUTTE_LE_PRESTAZIONI);
        for (Prestazione prestazione : prestazioni) {
            this.comboPrestazione.addItem(prestazione);
        }
        this.comboPrestazione.setSelectedItem(null);
    }

    private void visualizzaTabella() {
        ModelloTabellaRicette modelloTabellaRicette = (ModelloTabellaRicette) this.tableRicette.getModel();
        Paziente pazienteSelezionato = (Paziente) Applicazione.getInstance().getModello().getBean(Costanti.PAZIENTE_SELEZIONATO);
        modelloTabellaRicette.setRicette(pazienteSelezionato.getRicette());
        modelloTabellaRicette.aggiornaDati();
    }

    public void aggiornaTabella() {
        ModelloTabellaRicette modello = (ModelloTabellaRicette) this.tableRicette.getModel();
        modello.aggiornaDati();
    }

    private void initAzioni() {
        ControlloDettagliPaziente controlloDettagliPaziente = Applicazione.getInstance().getControlloDettagliPaziente();
        this.bottoneAggiungi.setAction(controlloDettagliPaziente.getAzioneAggiungiPrestazione());
        this.menuSuggerisciRicetta.setAction(controlloDettagliPaziente.getAzioneSuggerisciRicetta());
    }

    public Prestazione getPrestazioneSelezionata() {
        return (Prestazione) this.comboPrestazione.getSelectedItem();
    }

    public int getIndiceRicettaSelezionata() {
        return this.tableRicette.getSelectedRow();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        javax.swing.JPanel tabellaRicette = new javax.swing.JPanel();
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel3 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel4 = new javax.swing.JLabel();
        javax.swing.JLabel jLabel5 = new javax.swing.JLabel();
        labelCF = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelCognome = new javax.swing.JLabel();
        labelDataDiNascita = new javax.swing.JLabel();
        labelResidenza = new javax.swing.JLabel();
        javax.swing.JLabel jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableRicette = new javax.swing.JTable();
        javax.swing.JPanel jPanel1 = new javax.swing.JPanel();
        comboPrestazione = new javax.swing.JComboBox<>();
        bottoneAggiungi = new javax.swing.JButton();
        javax.swing.JMenuBar jMenuBar1 = new javax.swing.JMenuBar();
        javax.swing.JMenu jMenu1 = new javax.swing.JMenu();
        menuSuggerisciRicetta = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tabellaRicette.setBorder(javax.swing.BorderFactory.createTitledBorder("Dettagli Paziente"));

        jLabel1.setText("Codice Fiscale:");

        jLabel2.setText("Residenza:");

        jLabel3.setText("Data di Nascita:");

        jLabel4.setText("Cognome:");

        jLabel5.setText("Nome:");

        labelCF.setText("jLabel6");

        labelNome.setText("jLabel7");

        labelCognome.setText("jLabel8");

        labelDataDiNascita.setText("jLabel9");

        labelResidenza.setText("jLabel10");

        jLabel6.setText("Ricette:");

        tableRicette.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tableRicette);

        javax.swing.GroupLayout tabellaRicetteLayout = new javax.swing.GroupLayout(tabellaRicette);
        tabellaRicette.setLayout(tabellaRicetteLayout);
        tabellaRicetteLayout.setHorizontalGroup(
            tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabellaRicetteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabellaRicetteLayout.createSequentialGroup()
                        .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabellaRicetteLayout.createSequentialGroup()
                                .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelCF, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNome))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                                .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelDataDiNascita)
                                    .addComponent(labelResidenza))
                                .addGap(162, 162, 162))
                            .addGroup(tabellaRicetteLayout.createSequentialGroup()
                                .addComponent(labelCognome)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(tabellaRicetteLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(tabellaRicetteLayout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        tabellaRicetteLayout.setVerticalGroup(
            tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabellaRicetteLayout.createSequentialGroup()
                .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(labelCF)
                    .addComponent(labelDataDiNascita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(labelNome)
                    .addComponent(labelResidenza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabellaRicetteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelCognome))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuova Prestazione"));

        bottoneAggiungi.setText("jButton1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboPrestazione, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bottoneAggiungi)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboPrestazione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bottoneAggiungi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jMenu1.setText("Opzioni");

        menuSuggerisciRicetta.setText("jMenuItem1");
        jMenu1.add(menuSuggerisciRicetta);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabellaRicette, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabellaRicette, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bottoneAggiungi;
    private javax.swing.JComboBox<Prestazione> comboPrestazione;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelCF;
    private javax.swing.JLabel labelCognome;
    private javax.swing.JLabel labelDataDiNascita;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelResidenza;
    private javax.swing.JMenuItem menuSuggerisciRicetta;
    private javax.swing.JTable tableRicette;
    // End of variables declaration//GEN-END:variables

}
