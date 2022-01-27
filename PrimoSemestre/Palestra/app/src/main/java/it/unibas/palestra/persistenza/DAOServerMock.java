package it.unibas.palestra.persistenza;

import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;

import it.unibas.palestra.modello.Attrezzo;
import it.unibas.palestra.modello.Esercizio;
import it.unibas.palestra.modello.Scheda;

public class DAOServerMock implements IDAOServer {

    private List<Scheda> listaSchede;

    public DAOServerMock() {
        listaSchede = new ArrayList<>();

        Scheda scheda1 = new Scheda("AAAA", "Alessandro", 1, new GregorianCalendar(2022, 0,26),
                new GregorianCalendar(2022, 1,26));
        Scheda scheda2 = new Scheda("BBBB", "Bartolomeo", 2, new GregorianCalendar(2022, 0, 19),
                new GregorianCalendar(2022, 3, 19));
        Scheda scheda3 = new Scheda("CCCC", "Carlo", 2, new GregorianCalendar(2022, 1, 19),
                new GregorianCalendar(2022, 2, 19));

        Attrezzo a1 = new Attrezzo("CP1", "Chest Press", "Petto");
        Attrezzo a2 = new Attrezzo("LP1", "Leg Press", "Gambe");
        Attrezzo a3 = new Attrezzo("LM", "Lat Machine", "Dorso");

        Esercizio ecp1 = new Esercizio(a1, 30,20);
        Esercizio ecp2 = new Esercizio(a1, 50,50);
        Esercizio ecp3 = new Esercizio(a1, 60,10);
        a1.addEsercizioACuiAppartiene(ecp1);
        a1.addEsercizioACuiAppartiene(ecp2);
        a1.addEsercizioACuiAppartiene(ecp3);

        Esercizio elp1 = new Esercizio(a2, 50, 10);
        Esercizio elp2 = new Esercizio(a2, 100, 5);
        Esercizio elp3 = new Esercizio(a2, 150, 1);
        a2.addEsercizioACuiAppartiene(elp1);
        a2.addEsercizioACuiAppartiene(elp2);
        a2.addEsercizioACuiAppartiene(elp3);

        Esercizio elm1 = new Esercizio(a3, 50, 10);
        Esercizio elm2 = new Esercizio(a3, 100, 5);
        Esercizio elm3 = new Esercizio(a3, 150, 1);
        a3.addEsercizioACuiAppartiene(elm1);
        a3.addEsercizioACuiAppartiene(elm2);
        a3.addEsercizioACuiAppartiene(elm3);

        scheda1.aggiungiEsercizio(ecp1);
        scheda1.aggiungiEsercizio(elp1);
        scheda1.aggiungiEsercizio(elm1);

        scheda2.aggiungiEsercizio(ecp2);
        scheda2.aggiungiEsercizio(elp2);
        scheda2.aggiungiEsercizio(elm2);

        scheda3.aggiungiEsercizio(ecp3);
        scheda3.aggiungiEsercizio(elp3);
        scheda3.aggiungiEsercizio(elm3);

        listaSchede.add(scheda1);
        listaSchede.add(scheda2);
        listaSchede.add(scheda3);

    }

    @Override
    public List<Scheda> findSchedaByDifficolta(int difficolta) {
        List<Scheda> risultato = new ArrayList<>();
        for (Scheda scheda : listaSchede) {
            if (scheda.getDifficolta() == difficolta) {
                risultato.add(scheda);
            }
        }
        if (!risultato.isEmpty()) {
            Collections.sort(risultato);
        }
        return risultato;
    }

    @Override
    public void updateListaSchede(List<Scheda> listaSchede) {
        //Essendo una versione mock, non ha senso sviluppare il seguente caso d'uso
    }


}
