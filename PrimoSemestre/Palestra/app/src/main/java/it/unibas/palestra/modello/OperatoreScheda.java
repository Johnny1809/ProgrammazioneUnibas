package it.unibas.palestra.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OperatoreScheda {

    public Scheda generaScheda (String codiceFiscale, String nome,  int difficolta, List<Scheda> listaSchede) {
        if (listaSchede.size() == 0) {
            throw new IllegalArgumentException("La lista schede è vuota");
        }
        Calendar dataInizio = new GregorianCalendar();
        Calendar dataFine = generaDataFine(listaSchede, difficolta);
        Map<Attrezzo, Integer> mappaOccorrenzeAttrezzo = calcolaMappaOccorrenzeAttrezzo(listaSchede);
        List<FrequenzaAttrezzo> listaFrequenzaAttrezzo = new ArrayList<>();
        for (Attrezzo attrezzo : mappaOccorrenzeAttrezzo.keySet()) {
            Integer occorrenza = mappaOccorrenzeAttrezzo.get(attrezzo);
            listaFrequenzaAttrezzo.add(new FrequenzaAttrezzo(attrezzo, occorrenza));
        }
        Collections.sort(listaFrequenzaAttrezzo);
        if (listaFrequenzaAttrezzo.size() > 2) {
             listaFrequenzaAttrezzo = listaFrequenzaAttrezzo.subList(0,2);
        }
        List<Esercizio> esercizi = new ArrayList<>();
        for (FrequenzaAttrezzo fa : listaFrequenzaAttrezzo) {
            esercizi.add(new Esercizio(fa.getAttrezzo(), 0, 0));
        }
        Scheda scheda = new Scheda(codiceFiscale, nome, difficolta, dataInizio, dataFine, esercizi);
        return scheda;
        }

    private Map<Attrezzo, Integer> calcolaMappaOccorrenzeAttrezzo(List<Scheda> listaSchede) {
        Map<Attrezzo, Integer> mappaOccorrenze = new HashMap<>();
        for (Scheda scheda : listaSchede) {
            for (Esercizio esercizio : scheda.getEsercizi()) {
                Attrezzo attrezzo = esercizio.getAttrezzo();
                Integer vecchieOccorrenze = mappaOccorrenze.get(attrezzo.getCodice());
                if (vecchieOccorrenze == null) {
                    mappaOccorrenze.put(attrezzo, 1);
                } else {
                    mappaOccorrenze.put(attrezzo, vecchieOccorrenze +1 );
                }
            }
        }
        return mappaOccorrenze;
    }

    private Calendar generaDataFine(List<Scheda> listaSchede, int difficolta) {
        Calendar oggi = new GregorianCalendar();
        long millisecondiMedi = 0;
        for (Scheda scheda : listaSchede) {
            if (scheda.getDifficolta() == difficolta) {
                millisecondiMedi += scheda.getDurata();
            }
        }
        millisecondiMedi = (long)(millisecondiMedi/listaSchede.size());
        long dataFineInMillis = oggi.getTime().getTime() + millisecondiMedi;
        Calendar dataFine = new GregorianCalendar();
        dataFine.setTimeInMillis(dataFineInMillis);
        return dataFine;
    }

}
