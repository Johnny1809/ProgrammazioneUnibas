package it.unibas.cantine.modello;

public class MeseOccorrenze {

    private int mese;
    private int occorrenze;

    public MeseOccorrenze(int mese, int occorrenze) {
        this.mese = mese;
        this.occorrenze = occorrenze;
    }

    public int getMese() {
        return mese;
    }

    public void setMese(int mese) {
        this.mese = mese;
    }

    public int getOccorrenze() {
        return occorrenze;
    }

    public void setOccorrenze(int occorrenze) {
        this.occorrenze = occorrenze;
    }
    
    
    
}
