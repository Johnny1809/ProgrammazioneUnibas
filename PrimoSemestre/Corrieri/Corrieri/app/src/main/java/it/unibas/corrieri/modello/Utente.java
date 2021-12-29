package it.unibas.corrieri.modello;

import java.util.ArrayList;
import java.util.Calendar;
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

    public void aggiungiPaccoInviato (Pacco pacco) {
        this.pacchiInviati.add(pacco);
    }

    public Pacco cercaPaccoInviatoEntro15ggPrima(Utente mittente, Calendar dataInvio) {
        Calendar data15gPrima = (Calendar) dataInvio.clone();
        data15gPrima.add(Calendar.DAY_OF_MONTH, -15);
        for (Pacco pacco : pacchiInviati) {
            if (pacco.getDestinatario().getCodice().trim().equalsIgnoreCase(mittente.getCodice()) && pacco.getDataInvio().after(data15gPrima)) {
                return pacco;
            }
        }
        return null;
    }
}
