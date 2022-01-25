package it.unibas.palestra.modello;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Attrezzo {

    private String codice;
    private String descrizione;
    private String parte;
    private List<Esercizio> esercizi = new ArrayList<>();

    public Attrezzo(String codice, String descrizione, String parte) {
        this.codice = codice;
        this.descrizione = descrizione;
        this.parte = parte;
    }

    public String getCodice() {
        return codice;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getParte() {
        return parte;
    }

    public List<Esercizio> getEsercizi() {
        return esercizi;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attrezzo attrezzo = (Attrezzo) o;
        return Objects.equals(codice, attrezzo.codice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codice);
    }
}
