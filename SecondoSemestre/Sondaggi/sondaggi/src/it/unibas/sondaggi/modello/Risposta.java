package it.unibas.sondaggi.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Risposta {

    private long id;
    private Azienda azienda;
    private Sondaggio sondaggio;
    private Calendar data;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    
    @ManyToOne
    public Azienda getAzienda() {
        return azienda;
    }

    public void setAzienda(Azienda azienda) {
        this.azienda = azienda;
    }

    @ManyToOne
    public Sondaggio getSondaggio() {
        return sondaggio;
    }

    public void setSondaggio(Sondaggio sondaggio) {
        this.sondaggio = sondaggio;
    }

    @Temporal(TemporalType.DATE)
    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }
    
    
}
