package it.unibas.isee.modello;

import java.text.NumberFormat;

public class ModuloIsee {

    private double reddito;
    private double patrimonio;
    private int numeroComponenti;
    private boolean presenzaMinori;

    public ModuloIsee(double reddito, double patrimonio, int numeroComponenti, boolean presenzaMinori) {
        this.reddito = reddito;
        this.patrimonio = patrimonio;
        this.numeroComponenti = numeroComponenti;
        this.presenzaMinori = presenzaMinori;
    }

    public double getReddito() {
        return reddito;
    }

    public void setReddito(double reddito) {
        this.reddito = reddito;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public int getNumeroComponenti() {
        return numeroComponenti;
    }

    public void setNumeroComponenti(int numeroComponenti) {
        this.numeroComponenti = numeroComponenti;
    }

    public boolean isPresenzaMinori() {
        return presenzaMinori;
    }

    public void setPresenzaMinori(boolean presenzaMinori) {
        this.presenzaMinori = presenzaMinori;
    }

    public double getValoreISEE(){
        return ((this.reddito+this.patrimonio*0.2)/getParametroScalaEquivalenza());
    }

    public String getStringaValoreISEE() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance();
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        return numberFormat.format(this.getValoreISEE());
    }

    private double getParametroScalaEquivalenza() {
        double parametroScala;
        if (this.numeroComponenti == 1) {
            parametroScala = 1.0;
        } else if (this.numeroComponenti == 2){
            parametroScala = 1.5;
        } else if (this.numeroComponenti == 3){
            parametroScala = 2.0;
        } else {
            parametroScala = 2.5;
        }
        if (presenzaMinori) {
            parametroScala += 0.5;
        }
        return parametroScala;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ModuloIsee{");
        sb.append("reddito=").append(reddito);
        sb.append(", patrimonio=").append(patrimonio);
        sb.append(", numeroComponenti=").append(numeroComponenti);
        sb.append(", presenzaMinori=").append(presenzaMinori);
        sb.append('}');
        return sb.toString();
    }
}
