package it.unibas.ricette.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Paziente {

    private long id;
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private Calendar dataDiNascita;
    private String residenza;
    private List<Ricetta> ricette = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(unique = true)
    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    @Temporal(TemporalType.DATE)
    public Calendar getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Calendar dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    @OneToMany(mappedBy = "paziente", cascade = CascadeType.ALL)
    public List<Ricetta> getRicette() {
        return ricette; 
    }

    public void setRicette(List<Ricetta> ricette) {
        this.ricette = ricette;
    }
    
    public void addRicetta(Ricetta ricetta){
        this.ricette.add(ricetta);
    }

    @Transient
    public Ricetta getRicettaPiuRecente() {
        Ricetta piuRecente = null;
        for (Ricetta ricetta : ricette) {
            if (piuRecente == null){
                piuRecente = ricetta;
                continue;
            }
            if (ricetta.getDataCreazione().after(piuRecente)){
                piuRecente = ricetta;
            }
        }
        return piuRecente;
    }
    
    
    
}
