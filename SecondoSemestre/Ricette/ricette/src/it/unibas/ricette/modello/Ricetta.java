package it.unibas.ricette.modello;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Entity
public class Ricetta {

    private static Logger logger = LoggerFactory.getLogger(Ricetta.class);
    private long id;
    private String codice;
    private Calendar dataCreazione;
    private String motivazione;
    private boolean mutuabile;
    private Paziente paziente;
    private List<Prestazione> prestazioni = new ArrayList<>();

    public Ricetta() {
    }

    public Ricetta(String codice, Calendar dataCreazione, String motivazione, boolean mutuabile, Paziente paziente) {
        this.codice = codice;
        this.dataCreazione = dataCreazione;
        this.motivazione = motivazione;
        this.mutuabile = mutuabile;
        this.paziente = paziente;
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

    @Temporal(TemporalType.DATE)
    public Calendar getDataCreazione() {
        return dataCreazione;
    }

    public void setDataCreazione(Calendar dataCreazione) {
        this.dataCreazione = dataCreazione;
    }

    public String getMotivazione() {
        return motivazione;
    }

    public void setMotivazione(String motivazione) {
        this.motivazione = motivazione;
    }

    public boolean isMutuabile() {
        return mutuabile;
    }

    public void setMutuabile(boolean mutuabile) {
        this.mutuabile = mutuabile;
    }

    @ManyToOne  
    public Paziente getPaziente() {
        return paziente;
    }

    public void setPaziente(Paziente paziente) {
        this.paziente = paziente;
    }

    @ManyToMany(mappedBy = "ricette")
    public List<Prestazione> getPrestazioni() {
        return prestazioni;
    }

    public void setPrestazioni(List<Prestazione> prestazioni) {
        this.prestazioni = prestazioni;
    }
    
    @Transient
    public boolean isPrestazioneConsentita(Prestazione prestazione){
        logger.debug("In questo momento la ricetta ha " + prestazioni.size() +" prestazioni");
        for (Prestazione prestazionePresente : prestazioni) {
            if (!prestazionePresente.getTipologia().trim().equalsIgnoreCase(prestazione.getTipologia().trim())) {
                return false;
            }
        }
        return true;
    }
    
    @Transient
    public String getTipologia(){
        logger.debug("Ricetta: " + this.getCodice() + "\nPrestazioni:" + prestazioni);
        if (this.prestazioni.isEmpty()) {
            return "";
        }
        return prestazioni.get(0).getTipologia();
    }
    
    public void addPrestazione(Prestazione prestazione){
        this.prestazioni.add(prestazione);
    }

}
