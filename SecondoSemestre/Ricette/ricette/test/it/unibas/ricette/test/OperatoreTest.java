package it.unibas.ricette.test;

import it.unibas.ricette.modello.OperatoreRicette;
import it.unibas.ricette.modello.Paziente;
import it.unibas.ricette.modello.Prestazione;
import it.unibas.ricette.modello.Ricetta;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import junit.framework.TestCase;

public class OperatoreTest extends TestCase{

    public void testGeneraRicette(){
        Paziente pazienteTest = new Paziente();
        Ricetta ricetta1 = new Ricetta("111", new GregorianCalendar(), "Dissenteria", false, pazienteTest);
        ricetta1.addPrestazione(new Prestazione("p1", "tipologiaDaSelezionare", "nomeprestazione"));
        ricetta1.addPrestazione(new Prestazione("p1", "tipologiaDaSelezionare", "nomeprestazione"));
        ricetta1.addPrestazione(new Prestazione("p1", "tipologiaDaSelezionare", "nomeprestazione"));
        for (Prestazione prestazione : ricetta1.getPrestazioni()) {
            prestazione.addRicetta(ricetta1);
        }
        Ricetta ricetta2 = new Ricetta("222", new GregorianCalendar(), "Ricetta da ignorare", false, pazienteTest);
        ricetta2.addPrestazione(new Prestazione("p1", "tipologiadaignorare", "nomeprestazione"));
        ricetta2.getDataCreazione().add(Calendar.MONTH, -1);
        for (Prestazione prestazione : ricetta2.getPrestazioni()) {
            prestazione.addRicetta(ricetta2);
        }
        
        Paziente pazienteTest2 = new Paziente();
        Ricetta ricetta3 = new Ricetta("111", new GregorianCalendar(), "Dissenteria", false, pazienteTest2);
        ricetta3.addPrestazione(new Prestazione("p1", "secondaTipologia", "nomeprestazionesecondaselezionata"));
        ricetta3.addPrestazione(new Prestazione("p1", "secondaTipologia", "nomeprestazionesecondaselezionata"));
        for (Prestazione prestazione : ricetta3.getPrestazioni()) {
            prestazione.addRicetta(ricetta3);
        }
        Ricetta ricetta4 = new Ricetta("222", new GregorianCalendar(), "Ricetta da ignorare", false, pazienteTest2);
        ricetta4.addPrestazione(new Prestazione("p3", "terzaTipologia", "terza ma non deve essere selezionata"));
        for (Prestazione prestazione : ricetta4.getPrestazioni()) {
            prestazione.addRicetta(ricetta4);
        }
        
        Ricetta ricetta5 = new Ricetta("222", new GregorianCalendar(), "Ricetta da ignorare", false, pazienteTest2);
        ricetta5.addPrestazione(new Prestazione("p5", "quartatipologia", "da ignorare perché supera in numero la tipologia di partenza"));
        ricetta5.addPrestazione(new Prestazione("p5", "tipologiaTroppoNumerosa", "da ignorare perché supera in numero la tipologia di partenza"));
        ricetta5.addPrestazione(new Prestazione("p5", "tipologiaTroppoNumerosa", "da ignorare perché supera in numero la tipologia di partenza"));
        ricetta5.addPrestazione(new Prestazione("p5", "tipologiaTroppoNumerosa", "da ignorare perché supera in numero la tipologia di partenza"));
        ricetta5.addPrestazione(new Prestazione("p5", "tipologiaTroppoNumerosa", "da ignorare perché supera in numero la tipologia di partenza"));
        ricetta5.addPrestazione(new Prestazione("p5", "tipologiaTroppoNumerosa", "da ignorare perché supera in numero la tipologia di partenza"));
        for (Prestazione prestazione : ricetta5.getPrestazioni()) {
            prestazione.addRicetta(ricetta5);
        }
        
        List<Ricetta> tutteLeRicette = new ArrayList<>();
        tutteLeRicette.add(ricetta1);
        tutteLeRicette.add(ricetta2);
        tutteLeRicette.add(ricetta3);
        tutteLeRicette.add(ricetta4);
        tutteLeRicette.add(ricetta5);
        
        System.out.println("*********************************************");
        OperatoreRicette operatoreRicette = new OperatoreRicette();
        List<Prestazione> getPrescrizioniSuggerite = operatoreRicette.getPrescrizioniSuggerite(tutteLeRicette, "tipologiaDaSelezionare");
        for (Prestazione prestazione : getPrescrizioniSuggerite) {
            System.out.println(prestazione.getTipologia());
            if (!(prestazione.getTipologia().equals("secondaTipologia"))){
                fail();
            }
        }
        
    }
    
}
