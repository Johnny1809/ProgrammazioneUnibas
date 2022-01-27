package it.unibas.palestra.modello;

public class Esercizio {

    private Attrezzo attrezzo;
    private int peso;
    private int ripetizioni;

    public Esercizio(Attrezzo attrezzo, int peso, int ripetizioni) {
        this.attrezzo = attrezzo;
        this.peso = peso;
        this.ripetizioni = ripetizioni;
    }

    public Attrezzo getAttrezzo() {
        return attrezzo;
    }

    public int getPeso() {
        return peso;
    }

    public int getRipetizioni() {
        return ripetizioni;
    }

    public void setRipetizioni(int ripetizioni) {
        this.ripetizioni = ripetizioni;
    }
}
