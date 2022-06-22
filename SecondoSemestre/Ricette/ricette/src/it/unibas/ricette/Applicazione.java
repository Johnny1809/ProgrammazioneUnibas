package it.unibas.ricette;

import it.unibas.ricette.controllo.ControlloDettagliPaziente;
import it.unibas.ricette.controllo.ControlloPeriodi;
import it.unibas.ricette.controllo.ControlloPrincipale;
import it.unibas.ricette.modello.Modello;
import it.unibas.ricette.persistenza.IDAOPaziente;
import it.unibas.ricette.persistenza.IDAOPrestazione;
import it.unibas.ricette.persistenza.IDAORicetta;
import it.unibas.ricette.persistenza.hibernate.DAOPazienteHibernate;
import it.unibas.ricette.persistenza.hibernate.DAOPrestazioneHibernate;
import it.unibas.ricette.persistenza.hibernate.DAORicettaHibernate;
import it.unibas.ricette.vista.FinestraDettagliPaziente;
import it.unibas.ricette.vista.FinestraPeriodi;
import it.unibas.ricette.vista.Frame;
import it.unibas.ricette.vista.PannelloPrincipale;
import javax.swing.SwingUtilities;

public class Applicazione {

    private static final Applicazione singleton = new Applicazione();

    private Applicazione() {
    }

    private Modello modello;
    private IDAOPaziente daoPaziente;
    private IDAOPrestazione daoPrestazione;
    private IDAORicetta daoRicetta;
    private Frame frame;
    private PannelloPrincipale pannelloPrincipale;
    private ControlloPrincipale controlloPrincipale;
    private ControlloDettagliPaziente controlloDettagliPaziente;
    private ControlloPeriodi controlloPeriodi;
    private FinestraDettagliPaziente finestraDettagliPaziente;
    private FinestraPeriodi finestraPeriodi;

    public Modello getModello() {
        return modello;
    }

    public IDAOPaziente getDaoPaziente() {
        return daoPaziente;
    }

    public IDAOPrestazione getDaoPrestazione() {
        return daoPrestazione;
    }

    public IDAORicetta getDaoRicetta() {
        return daoRicetta;
    }

    public Frame getFrame() {
        return frame;
    }

    public PannelloPrincipale getPannelloPrincipale() {
        return pannelloPrincipale;
    }

    public ControlloPrincipale getControlloPrincipale() {
        return controlloPrincipale;
    }

    public FinestraDettagliPaziente getFinestraDettagliPaziente() {
        return finestraDettagliPaziente;
    }

    public ControlloDettagliPaziente getControlloDettagliPaziente() {
        return controlloDettagliPaziente;
    }

    public FinestraPeriodi getFinestraPeriodi() {
        return finestraPeriodi;
    }

    public ControlloPeriodi getControlloPeriodi() {
        return controlloPeriodi;
    }

    public void inizializza() {
        this.modello = new Modello();
        this.daoPaziente = new DAOPazienteHibernate();
        this.daoPrestazione = new DAOPrestazioneHibernate();
        this.daoRicetta = new DAORicettaHibernate();
        this.pannelloPrincipale = new PannelloPrincipale();
        this.frame = new Frame();
        this.controlloPrincipale = new ControlloPrincipale();
        this.controlloDettagliPaziente = new ControlloDettagliPaziente();
        this.controlloPeriodi = new ControlloPeriodi();
        this.finestraDettagliPaziente = new FinestraDettagliPaziente(frame);
        this.finestraPeriodi = new FinestraPeriodi(frame);

        this.finestraPeriodi.inizializza();
        this.finestraDettagliPaziente.inizializza();
        this.pannelloPrincipale.inizializza();
        this.frame.inizializza();
    }

    public static Applicazione getInstance() {
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
}
