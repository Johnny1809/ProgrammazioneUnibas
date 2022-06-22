package it.unibas.cantine;

import it.unibas.cantine.controllo.ControlloDettagli;
import it.unibas.cantine.controllo.ControlloPrincipale;
import it.unibas.cantine.modello.Modello;
import it.unibas.cantine.vista.Frame;
import it.unibas.cantine.vista.PannelloPrincipale;
import it.unibas.cantine.vista.VistaDettagli;
import it.unibas.cantine.vista.VistaStatisticaVendemmia;
import it.unibas.persistenza.IDAOAnnata;
import it.unibas.persistenza.IDAOVitigno;
import it.unibas.persistenza.hibernate.DAOAnnataHibernate;
import it.unibas.persistenza.hibernate.DAOVitignoHibernate;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static Applicazione applicazione = new Applicazione();
    private Modello modello;
    private IDAOAnnata daoAnnata;
    private IDAOVitigno daoVitigno;
    private Frame frame;
    private PannelloPrincipale pannelloPrincipale;
    private ControlloPrincipale controlloPrincipale;
    private ControlloDettagli controlloDettagli;
    private VistaDettagli vistaDettagli;
    private VistaStatisticaVendemmia vistaStatisticaVendemmia;

    private Applicazione() {
    }

    public static Applicazione getInstance() {
        return applicazione;
    }

    public Frame getFrame() {
        return frame;
    }

    public Modello getModello() {
        return modello;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public ControlloDettagli getControlloDettagli() {
        return controlloDettagli;
    }

    public IDAOAnnata getDaoAnnata() {
        return daoAnnata;
    }

    public IDAOVitigno getDaoVitigno() {
        return daoVitigno;
    }

    public PannelloPrincipale getPannelloPrincipale() {
        return pannelloPrincipale;
    }

    public VistaDettagli getVistaDettagli() {
        return vistaDettagli;
    }

    public VistaStatisticaVendemmia getVistaStatisticaVendemmia() {
        return vistaStatisticaVendemmia;
    }

    public void inizializza() {
        modello = new Modello();
        daoAnnata = new DAOAnnataHibernate();
        daoVitigno = new DAOVitignoHibernate();
        pannelloPrincipale = new PannelloPrincipale();
        frame = new Frame();
        controlloPrincipale = new ControlloPrincipale();
        controlloDettagli = new ControlloDettagli();
        vistaDettagli = new VistaDettagli(frame);
        vistaStatisticaVendemmia = new VistaStatisticaVendemmia(frame);

        vistaStatisticaVendemmia.inizializza();
        vistaDettagli.inizializza();
        pannelloPrincipale.inizializza();
        frame.inizializza();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                applicazione.inizializza();
            }
        });
    }

}
