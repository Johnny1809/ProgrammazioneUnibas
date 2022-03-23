package it.unibas.aziende.modello;

import java.util.ArrayList;
import java.util.List;


public class Azienda {
    
    private String partitaIVA;
    private String denominazione;
    private String sede;
    private List<Dipendente> dipendenti = new ArrayList<>();

    public String getPartitaIVA() {
        return partitaIVA;
    }

    public void setPartitaIVA(String partitaIVA) {
        this.partitaIVA = partitaIVA;
    }

    public String getDenominazione() {
        return denominazione;
    }

    public void setDenominazione(String denominazione) {
        this.denominazione = denominazione;
    }

    public String getSede() {
        return sede;
    }

    public void setSede(String sede) {
        this.sede = sede;
    }

    public List<Dipendente> getDipendenti() {
        return dipendenti;
    }

    public void setDipendenti(List<Dipendente> dipendenti) {
        this.dipendenti = dipendenti;
    }
    
    

}
