package it.unibas.corrieri.modello;

import java.util.ArrayList;
import java.util.List;

public class Corriere {

    private int numero;
    private String nome;
    private String zona;
    private List<Pacco> listaPacchi = new ArrayList<>();

    public Corriere(int numero, String nome, String zona) {
        this.nome = nome;
        this.numero = numero;
        this.zona = zona;
    }

    public String getNome() {
        return nome;
    }

    public int getNumero() {
        return numero;
    }

    public String getZona() {
        return zona;
    }

    public List<Pacco> getListaPacchi() {
        return listaPacchi;
    }

    public void setListaPacchi(List<Pacco> listaPacchi) {
        this.listaPacchi = listaPacchi;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Corriere{");
        sb.append("nome='").append(nome).append('\'');
        sb.append(", numeroCorriere=").append(numero);
        sb.append(", zona='").append(zona).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
