package it.unibas.cantine.modello;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Vino {

    private long id;
    private String nome;
    private String tipo;
    private String classificazione;
    private List<Annata> annate;

    public Vino() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getClassificazione() {
        return classificazione;
    }

    public void setClassificazione(String classificazione) {
        this.classificazione = classificazione;
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "vino")
    public List<Annata> getAnnate() {
        return annate;
    }

    public void setAnnate(List<Annata> annate) {
        this.annate = annate;
    }

    
    
}
