package it.unibas.trasferimenti.modello;

import java.util.ArrayList;
import java.util.List;

public class Calciatore {

    private String id;
    private String cognome;
    private String nome;
    private String ruolo;
    private int valore;
    private List<Trasferimento> trasferimenti = new ArrayList<>();

    public Calciatore(String id, String cognome, String nome, String ruolo, int valore) {
        this.id = id;
        this.cognome = cognome;
        this.nome = nome;
        this.ruolo = ruolo;
        this.valore = valore;
    }

    public String getId() {
        return id;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getRuolo() {
        return ruolo;
    }

    public int getValore() {
        return valore;
    }

    public List<Trasferimento> getTrasferimenti() {
        return trasferimenti;
    }

    public void aggiungiTrasferimento(Trasferimento trasferimento) {
        this.trasferimenti.add(trasferimento);
    }
}
