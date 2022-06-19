package it.unibas.cantine.modello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Vitigno {

    private long id;
    private String nomeUva;
    private float percentualeUtilizzata;
    private boolean aromatico;
    private Annata annata;

    public Vitigno() {
    }

   @Id
   @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeUva() {
        return nomeUva;
    }

    public void setNomeUva(String nomeUva) {
        this.nomeUva = nomeUva;
    }

    public float getPercentualeUtilizzata() {
        return percentualeUtilizzata;
    }

    public void setPercentualeUtilizzata(float percentualeUtilizzata) {
        this.percentualeUtilizzata = percentualeUtilizzata;
    }

    public boolean isAromatico() {
        return aromatico;
    }

    public void setAromatico(boolean aromatico) {
        this.aromatico = aromatico;
    }

    @ManyToOne
    public Annata getAnnata() {
        return annata;
    }

    public void setAnnata(Annata annata) {
        this.annata = annata;
    }
    
    
    
}
