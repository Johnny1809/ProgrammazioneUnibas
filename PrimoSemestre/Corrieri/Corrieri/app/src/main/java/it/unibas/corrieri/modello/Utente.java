package it.unibas.corrieri.modello;

import java.util.ArrayList;
import java.util.List;

public class Utente {

    private String codice;
    private String nome;
    private String via;
    private int numeroCivico;
    private List<Pacco> pacchiInviati = new ArrayList<>();

    public Utente(String codice, String nome, String via, int numeroCivico) {
        this.codice = codice;
        this.nome = nome;
        this.via = via;
        this.numeroCivico = numeroCivico;
    }

    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public List<Pacco> getPacchiInviati() {
        return pacchiInviati;
    }

    public void setPacchiInviati(List<Pacco> pacchiInviati) {
        this.pacchiInviati = pacchiInviati;
    }
}
