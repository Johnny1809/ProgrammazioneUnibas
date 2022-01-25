package it.unibas.palestra.test;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.palestra.modello.Attrezzo;
import it.unibas.palestra.modello.Esercizio;
import it.unibas.palestra.modello.OperatoreScheda;
import it.unibas.palestra.modello.Scheda;

public class TestOperatoreScheda extends TestCase {

    private OperatoreScheda operatoreScheda = new OperatoreScheda();
    private List<Scheda> listaSchede = new ArrayList<>();
    private Attrezzo a1 = new Attrezzo("a1", "Attrezzo 1", "gambe");
    private Attrezzo a2 = new Attrezzo("a2", "Attrezzo 2", "gambe");
    private Attrezzo a3 = new Attrezzo("a3", "Attrezzo 3", "gambe");
    private Attrezzo a4 = new Attrezzo("a4", "Attrezzo 4", "gambe");

    public void setUp(){
        listaSchede = new ArrayList<>();
        Scheda s1 = new Scheda("cf1", "Nome 1", 1,
                new GregorianCalendar(2022, Calendar.JANUARY, 1),
                new GregorianCalendar(2022, Calendar.JANUARY, 11));
        s1.aggiungiEsercizio(new Esercizio(a1, 10, 10));
        s1.aggiungiEsercizio(new Esercizio(a2, 10, 10));
        s1.aggiungiEsercizio(new Esercizio(a2, 10, 20));
        listaSchede.add(s1);
        Scheda s2 = new Scheda("cf2", "Nome 2", 1,
                new GregorianCalendar(2022, Calendar.JANUARY, 1),
                new GregorianCalendar(2022, Calendar.JANUARY, 21));
        s2.aggiungiEsercizio(new Esercizio(a1, 10, 10));
        s2.aggiungiEsercizio(new Esercizio(a3, 10, 10));
        listaSchede.add(s2);
    }

    public void testScheda1(){
        Scheda schedaTipo = operatoreScheda.generaScheda("CF3", "Nome 3", 1, listaSchede);
        assertTrue(new GregorianCalendar().before(schedaTipo.getDataFine()));
        long durata = 15 * 24 * 60 * 60 * 1000; //15 giorni in millisecondi
        Calendar dataFineAttesa = new GregorianCalendar();
        dataFineAttesa.setTimeInMillis(schedaTipo.getDataInizio().getTime().getTime() + durata);
        assertEquals(dataFineAttesa, schedaTipo.getDataFine());
        assertEquals(2, schedaTipo.getEsercizi().size());
        assertEquals("a1", schedaTipo.getEsercizi().get(0).getAttrezzo().getCodice());
        assertEquals("a2", schedaTipo.getEsercizi().get(1).getAttrezzo().getCodice());
    }

}
