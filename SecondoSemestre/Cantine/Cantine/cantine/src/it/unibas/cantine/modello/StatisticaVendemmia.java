package it.unibas.cantine.modello;

public class StatisticaVendemmia implements Comparable<StatisticaVendemmia> {

    private Vitigno vitigno;
    private int mesePreferito;
    private int occorrenze;
    private int qualita;

    public StatisticaVendemmia() {
    }

    public StatisticaVendemmia(Vitigno vitigno, int mesePreferito, int occorrenze, int qualita) {
        this.vitigno = vitigno;
        this.mesePreferito = mesePreferito;
        this.occorrenze = occorrenze;
        this.qualita = qualita;
    }

    public Vitigno getVitigno() {
        return vitigno;
    }

    public void setVitigno(Vitigno vitigno) {
        this.vitigno = vitigno;
    }

    public int getMesePreferito() {
        return mesePreferito;
    }

    public void setMesePreferito(int mesePreferito) {
        this.mesePreferito = mesePreferito;
    }

    public int getOccorrenze() {
        return occorrenze;
    }

    public void setOccorrenze(int occorrenze) {
        this.occorrenze = occorrenze;
    }

    public int getQualita() {
        return qualita;
    }

    public void setQualita(int qualita) {
        this.qualita = qualita;
    }

    @Override
    public int compareTo(StatisticaVendemmia o) {
        Integer occorrenze = this.occorrenze;
        return occorrenze.compareTo(o.getOccorrenze());
    }

}
