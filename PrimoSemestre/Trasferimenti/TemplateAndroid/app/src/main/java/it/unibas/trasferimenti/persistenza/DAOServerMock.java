package it.unibas.trasferimenti.persistenza;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.trasferimenti.modello.Calciatore;
import it.unibas.trasferimenti.modello.ComparatoreCalciatore;
import it.unibas.trasferimenti.modello.Trasferimento;

public class DAOServerMock implements IDAOServer {

    private List<Calciatore> listaCalciatori;

    public DAOServerMock() {

        listaCalciatori = new ArrayList<>();

        Calciatore c1 = new Calciatore("01","Alfredi", "Antonio", "Attaccante", 50);
        Calciatore c2 = new Calciatore("02","Bernardeschi", "Boris", "Boh", 100);
        Calciatore c3 = new Calciatore("03","Concini", "Carlo", "Centravanti", 150);

        c1.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.JANUARY, 28),
                "Inter", "Milan", 40));

        c1.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.FEBRUARY, 12),
                "Milan", "Real", 34));

        c1.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.MARCH, 8),
                "Real", "Roma", 80));

        c2.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.JANUARY, 28),
                "Inter", "Milan", 40));

        c2.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.FEBRUARY, 12),
                "Milan", "Real", 34));

        c2.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.MARCH, 8),
                "Real", "Roma", 80));

        c3.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.JANUARY, 28),
                "Inter", "Milan", 40));

        c3.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.FEBRUARY, 12),
                "Milan", "Real", 34));

        c3.aggiungiTrasferimento(new Trasferimento(new GregorianCalendar(2022, Calendar.MARCH, 8),
                "Real", "Roma", 80));

        listaCalciatori.add(c1);
        listaCalciatori.add(c2);
        listaCalciatori.add(c3);

    }

    @Override
    public List<Calciatore> findAllCalciatori(String criterioOrdinamento) {
        Collections.sort(listaCalciatori, new ComparatoreCalciatore(criterioOrdinamento));
        return this.listaCalciatori;
    }

    @Override
    public void salvaCalciatore(Calciatore calciatore) {
        //non necessario nel mock
    }


}
