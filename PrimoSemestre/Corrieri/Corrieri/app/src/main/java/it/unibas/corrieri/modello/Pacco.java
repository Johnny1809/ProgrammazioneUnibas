package it.unibas.corrieri.modello;

import java.util.Calendar;

public class Pacco {

    private Calendar dataInvio;
    private double peso;
    private boolean urgente;
    private Utente mittente;
    private Utente destinatario;

    public Pacco(Calendar dataInvio, double peso, boolean urgente, Utente mittente, Utente destinatario) {
        this.dataInvio = dataInvio;
        this.peso = peso;
        this.urgente = urgente;
        this.mittente = mittente;
        this.destinatario = destinatario;
    }

    public Calendar getDataInvio() {
        return dataInvio;
    }

    public void setDataInvio(Calendar dataInvio) {
        this.dataInvio = dataInvio;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public boolean isUrgente() {
        return urgente;
    }

    public void setUrgente(boolean urgente) {
        this.urgente = urgente;
    }

    public Utente getMittente() {
        return mittente;
    }

    public void setMittente(Utente mittente) {
        this.mittente = mittente;
    }

    public Utente getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(Utente destinatario) {
        this.destinatario = destinatario;
    }
}
