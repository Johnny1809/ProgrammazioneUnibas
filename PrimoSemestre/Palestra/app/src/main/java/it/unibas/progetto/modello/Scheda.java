package it.unibas.progetto.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Scheda {

    private String codiceFiscale;
    private String nome;
    private int difficolta;
    private Calendar dataInizio;
    private Calendar dataFine;
    private List<Esercizio> esercizi = new ArrayList<>();

    public Scheda(String codiceFiscale, String nome, int difficolta, Calendar dataInizio, Calendar dataFine) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.difficolta = difficolta;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
    }

    public Scheda(String codiceFiscale, String nome, int difficolta, Calendar dataInizio, Calendar dataFine, List<Esercizio> esercizi) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.difficolta = difficolta;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.esercizi = esercizi;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public int getDifficolta() {
        return difficolta;
    }

    public Calendar getDataInizio() {
        return dataInizio;
    }

    public Calendar getDataFine() {
        return dataFine;
    }

    public List<Esercizio> getEsercizi() {
        return esercizi;
    }

    public long getDurata () {
        long inizioMillis = dataInizio.getTimeInMillis();
        long fineMillis = dataFine.getTimeInMillis();
        return fineMillis - inizioMillis;
    }
}
