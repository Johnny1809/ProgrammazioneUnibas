package it.unibas.sondaggi;

import it.unibas.sondaggi.controllo.ControlloFinestraDettaglio;
import it.unibas.sondaggi.controllo.ControlloPannelloPrincipale;
import it.unibas.sondaggi.modello.Modello;
import it.unibas.sondaggi.persistenza.DAOAziendaHibernate;
import it.unibas.sondaggi.persistenza.DAOSondaggioHibernate;
import it.unibas.sondaggi.persistenza.IDAOAzienda;
import it.unibas.sondaggi.persistenza.IDAOSondaggio;
import it.unibas.sondaggi.vista.FinestraDettagli;
import it.unibas.sondaggi.vista.PannelloPrincipale;
import it.unibas.sondaggi.vista.VistaFrame;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione singleton = new Applicazione();
    private IDAOAzienda daoAzienda;
    private IDAOSondaggio daoSondaggio;
    private Modello modello;
    private VistaFrame vistaFrame;
    private PannelloPrincipale pannelloPrincipale;
    private ControlloPannelloPrincipale controlloPannelloPrincipale;
    private FinestraDettagli finestraDettagli;
    private ControlloFinestraDettaglio controlloFinestraDettaglio;

    public ControlloFinestraDettaglio getControlloFinestraDettaglio() {
        return controlloFinestraDettaglio;
    }

    public FinestraDettagli getFinestraDettagli() {
        return finestraDettagli;
    }

    public ControlloPannelloPrincipale getControlloPannelloPrincipale() {
        return controlloPannelloPrincipale;
    }

    public PannelloPrincipale getPannelloPrincipale() {
        return pannelloPrincipale;
    }

    public VistaFrame getVistaFrame() {
        return vistaFrame;
    }

    public IDAOAzienda getDaoAzienda() {
        return daoAzienda;
    }

    public IDAOSondaggio getDaoSondaggio() {
        return daoSondaggio;
    }

    public Modello getModello() {
        return modello;
    }
    
    private Applicazione(){
        
    }
    
    public static Applicazione getInstance(){
        return singleton;
    }
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                singleton.inizializza();
            }
        });
    }
    
    private void inizializza(){
        this.daoAzienda = new DAOAziendaHibernate();
        this.daoSondaggio = new DAOSondaggioHibernate();
        this.modello = new Modello();
        this.vistaFrame = new VistaFrame();
        this.pannelloPrincipale = new PannelloPrincipale();
        this.controlloPannelloPrincipale = new ControlloPannelloPrincipale();
        this.finestraDettagli = new FinestraDettagli(vistaFrame);
        this.controlloFinestraDettaglio = new ControlloFinestraDettaglio();
        this.finestraDettagli.inizializza();
        
        pannelloPrincipale.inizializza();
        vistaFrame.inizializza();
    }
    
}
