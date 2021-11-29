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
}
