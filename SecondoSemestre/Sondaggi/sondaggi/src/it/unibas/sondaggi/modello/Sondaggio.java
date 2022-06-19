package it.unibas.sondaggi.modello;

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

@Entity
public class Sondaggio {

    private long id;
    private String codice;
    private String descrizione;
    private String tematica;
    private Calendar dataScadenza;
    private List<Risposta> risposte;

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

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public String getTematica() {
        return tematica;
    }

    public void setTematica(String tematica) {
        this.tematica = tematica;
    }

    @Temporal(TemporalType.DATE)
    public Calendar getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Calendar dataScadenza) {
        this.dataScadenza = dataScadenza;
    }

    @OneToMany(mappedBy = "sondaggio", cascade = CascadeType.ALL)
    public List<Risposta> getRisposte() {
        return risposte;
    }

    public void setRisposte(List<Risposta> risposte) {
        this.risposte = risposte;
    }
    
    public void addRisposta(Risposta risposta){
        this.risposte.add(risposta);
    }
    
}
