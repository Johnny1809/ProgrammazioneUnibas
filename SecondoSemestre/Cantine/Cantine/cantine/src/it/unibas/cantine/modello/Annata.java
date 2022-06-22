package it.unibas.cantine.modello;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Annata {

    private long id;
    private int mese;
    private int anno;
    private int qualita;
    private List<Vitigno> vitigni;
    private Vino vino;

    public Annata() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int Mese) {
        this.mese = Mese;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getQualita() {
        return qualita;
    }

    public void setQualita(int qualita) {
        this.qualita = qualita;
    }

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL, mappedBy = "annata")
    public List<Vitigno> getVitigni() {
        return vitigni;
    }

    public void setVitigni(List<Vitigno> vitigni) {
        this.vitigni = vitigni;
    }

    @ManyToOne
    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
    }

    @Transient
    public boolean isVitignoInseribile(Vitigno vitigno) {
        if (vitigno.getPercentualeUtilizzata() + percentualeTotale() > 100) {
            return false;
        }
        for (Vitigno vitignoPresente : vitigni) {
            if (vitignoPresente.getNomeUva().equalsIgnoreCase(vitigno.getNomeUva())) {
                return false;
            }
        }
        return true;
    }

    private float percentualeTotale() {
        float ris = 0;
        for (Vitigno vitigno : vitigni) {
            ris += vitigno.getPercentualeUtilizzata();
        }
        return ris;
    }

    @Transient
    public boolean isVinoAromatico() {
        for (Vitigno vitigno : vitigni) {
            if (vitigno.isAromatico()){
                return true;
            }
        }
        return false;
    }
}
