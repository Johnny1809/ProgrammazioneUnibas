package it.unibas.progetto.modello;

public class FrequenzaAttrezzo implements Comparable<FrequenzaAttrezzo>{

    private Attrezzo attrezzo;
    private int frequenza;

    public FrequenzaAttrezzo(Attrezzo attrezzo, int frequenza) {
        this.attrezzo = attrezzo;
        this.frequenza = frequenza;
    }

    public Attrezzo getAttrezzo() {
        return attrezzo;
    }

    public int getFrequenza() {
        return frequenza;
    }

    @Override
    public int compareTo(FrequenzaAttrezzo o) {
        if (this.frequenza == o.getFrequenza()) {
            return this.getAttrezzo().getCodice().compareTo(o.getAttrezzo().getCodice());
        }
        return o.getFrequenza() - this.frequenza;
    }
}
