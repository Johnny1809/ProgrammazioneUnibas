package it.unibas.aziende;

import it.unibas.aziende.controllo.ControlloPrincipale;
import it.unibas.aziende.modello.Modello;
import it.unibas.aziende.persistenza.DAOAziendaJDBC;
import it.unibas.aziende.persistenza.DAODipendenteJDBC;
import it.unibas.aziende.persistenza.IDAOAzienda;
import it.unibas.aziende.persistenza.IDAODipendente;
import it.unibas.aziende.vista.FinestraDettagli;
import it.unibas.aziende.vista.Frame;
import it.unibas.aziende.vista.PannelloPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public FinestraDettagli getFinestraDettagli() {
        return finestraDettagli;
    }

    private static Applicazione singleton = new Applicazione();
    
    private Modello modello;
    private IDAOAzienda daoAzienda;
    private IDAODipendente daoDipendente;
    private Frame frame;
    private PannelloPrincipale pannelloPrincipale;
    private ControlloPrincipale controlloPrincipale;
    private FinestraDettagli finestraDettagli;

    public Modello getModello() {
        return modello;
    }

    public IDAOAzienda getDaoAzienda() {
        return daoAzienda;
    }

    public IDAODipendente getDaoDipendente() {
        return daoDipendente;
    }

    public Frame getFrame() {
        return frame;
    }

    public PannelloPrincipale getPannelloPrincipale() {
        return pannelloPrincipale;
    }

    private Applicazione(){
        
    }
    
    public static Applicazione getInstance() {
        return singleton;
    }
    
    private void inizializza() {
        modello = new Modello();
        daoAzienda = new DAOAziendaJDBC();
        daoDipendente = new DAODipendenteJDBC();
        frame = new Frame();
        pannelloPrincipale = new PannelloPrincipale();
        controlloPrincipale = new ControlloPrincipale();
        finestraDettagli = new FinestraDettagli(frame);
        
        finestraDettagli.inizializza();
        pannelloPrincipale.inizializza();
        frame.inizializza();
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Applicazione.getInstance().inizializza();
            }
        });
    }

    
    
    
    
}
