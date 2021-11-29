package it.unibas.corrieri.persistenza;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;

public class DAOServerMock implements IDAOServer{

    private List<Corriere> listaCorrieri = new ArrayList<>();
    private List<Utente> listaUtenti = new ArrayList<>();

    public DAOServerMock() {
        Utente u1 = new Utente("U01", "Giuseppe Verdi", "Via Unità D'Italia", 1);
        Utente u2 = new Utente("U02", "Rocco Banfi", "Via Unità D'Italia", 3);
        listaUtenti.add(u1);
        listaUtenti.add(u2);
        Corriere c1 = new Corriere(1, "Mario Rossi", "Provincia Di Potenza");
        listaCorrieri.add(c1);
        Pacco p1 = new Pacco(new GregorianCalendar(2021, 10, 29), 1.0, false, u1, u2);
        u1.getPacchiInviati().add(p1);
        c1.getListaPacchi().add(p1);
        for (int i = 2; i < 10; i++) {
            listaCorrieri.add(new Corriere(i, "Corriere Test" + i, "Provincia Di Potenza"));
        }
    }

    @Override
    public List<Corriere> findCorriereByZona(String zona) throws DAOException {
        List<Corriere> listaFiltrata = new ArrayList<>();
        for (Corriere corriere : listaCorrieri) {
            if (corriere.getZona().equalsIgnoreCase(zona)) {
                listaFiltrata.add(corriere);
            }
        }
        return listaFiltrata;
    }

    @Override
    public List<Utente> findAllUtenti() throws DAOException {
        return listaUtenti;
    }

    @Override
    public void salvaPacco(Pacco pacco) throws DAOException {
    //si ipotizza che, al momento del salvataggio, il pacco è già stato assegnato al corriere,
        // di conseguenza il metodo salvaPacco Mock è inutile poiché in questa versione i pacchi sono mantenuti come riferimenti
        // all'interno dei corrieri... in una versione con caricamento pigro, sarebbe stato diverso
    }
}
