package it.unibas.trasferimenti.modello;

import java.util.Calendar;

public class Trasferimento {

    private Calendar data;
    private String squadraCheVende;
    private String squadraCheAcquista;
    private int costo;

    public Trasferimento(Calendar data, String squadraCheVende, String squadraCheAcquista, int costo) {
        this.data = data;
        this.squadraCheVende = squadraCheVende;
        this.squadraCheAcquista = squadraCheAcquista;
        this.costo = costo;
    }

    public Calendar getData() {
        return data;
    }

    public String getSquadraCheVende() {
        return squadraCheVende;
    }

    public String getSquadraCheAcquista() {
        return squadraCheAcquista;
    }

    public int getCosto() {
        return costo;
    }
}
