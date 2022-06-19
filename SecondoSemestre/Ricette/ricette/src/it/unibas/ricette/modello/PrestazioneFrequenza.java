package it.unibas.ricette.modello;

public class PrestazioneFrequenza implements Comparable<PrestazioneFrequenza>{

    private int frequenza;
    private Prestazione prestazione;

    public PrestazioneFrequenza() {
    }

    public PrestazioneFrequenza(int frequenza, Prestazione prestazione) {
        this.frequenza = frequenza;
        this.prestazione = prestazione;
    }

    public int getFrequenza() {
        return frequenza;
    }

    public void setFrequenza(int frequenza) {
        this.frequenza = frequenza;
    }

    public Prestazione getPrestazione() {
        return prestazione;
    }

    public void setPrestazione(Prestazione prestazione) {
        this.prestazione = prestazione;
    }

    @Override
    public int compareTo(PrestazioneFrequenza altraPF) {
        Integer boxedFrequenza = (Integer) frequenza;
        return boxedFrequenza.compareTo(altraPF.getFrequenza());
    }
    
    
    
}
