package it.unibas.aziende.modello;


public class Dipendente {
    
    private String codiceFiscale;
    private String nome;
    private String cognome;
    private int annoAssunzione;

    public Dipendente() {
    }

    
    public Dipendente(String codiceFiscale, String nome, String cognome, int annoAssunzione) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.annoAssunzione = annoAssunzione;
    }
    
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

    public int getAnnoAssunzione() {
        return annoAssunzione;
    }

    public void setAnnoAssunzione(int annoAssunzione) {
        this.annoAssunzione = annoAssunzione;
    }
    
    

}
