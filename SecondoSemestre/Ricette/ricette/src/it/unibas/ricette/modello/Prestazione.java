package it.unibas.ricette.modello;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Prestazione {

    private long id;
    private String codice;
    private String tipologia;
    private String nome;
    private List<Ricetta> ricette = new ArrayList<>();

    public Prestazione() {
    }

    public Prestazione(String codice, String tipologia, String nome) {
        this.codice = codice;
        this.tipologia = tipologia;
        this.nome = nome;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getCodice() {
        return codice;
    }

    public void setCodice(String codice) {
        this.codice = codice;
    }

    public String getTipologia() {
        return tipologia;
    }

    public void setTipologia(String tipologia) {
        this.tipologia = tipologia;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @ManyToMany
    public List<Ricetta> getRicette() {
        return ricette;
    }

    public void setRicette(List<Ricetta> ricette) {
        this.ricette = ricette;
    }
    
    public void addRicetta(Ricetta ricetta){
        this.ricette.add(ricetta);
    }

    @Override
    public String toString() {
        return nome+ "(" + this.tipologia + ")";
    }
    
    public String toStringConTipologia(){
        return nome + "(" + this.tipologia + ")";
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.codice);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Prestazione other = (Prestazione) obj;
        if (!Objects.equals(this.codice, other.codice)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
