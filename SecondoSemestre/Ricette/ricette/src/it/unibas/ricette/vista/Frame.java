package it.unibas.ricette.vista;

import it.unibas.ricette.Applicazione;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class Frame extends javax.swing.JFrame {

    public void inizializza(){
        this.initComponents();
        this.setContentPane(new JScrollPane(Applicazione.getInstance().getPannelloPrincipale()));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void mostraMessaggioErrore(String messaggio){
        JOptionPane.showMessageDialog(this, messaggio, "Ricette - Errore", JOptionPane.ERROR_MESSAGE);
    }
    
    public void mostraMessaggio(String messaggio){
        JOptionPane.showMessageDialog(this, messaggio, "Ricette - Messaggio", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 526, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 476, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
