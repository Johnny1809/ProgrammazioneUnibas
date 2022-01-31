package it.unibas.trasferimenti.modello;

import java.util.Comparator;

import it.unibas.trasferimenti.Costanti;

public class ComparatoreCalciatore implements Comparator<Calciatore> {

    private String criterioOrdinamento;

    public ComparatoreCalciatore(String criterioOrdinamento) {
        this.criterioOrdinamento = criterioOrdinamento;
    }

    @Override
    public int compare(Calciatore o1, Calciatore o2) {
        if (criterioOrdinamento.equals(Costanti.CRITERIO_ORDINAMENTO_NOME)) {
            return o1.getNome().compareTo(o2.getNome());
        }
        if (criterioOrdinamento.equals(Costanti.CRITERIO_ORDINAMENTO_VALORE_CRESC)) {
            return o1.getValore() - o2.getValore();
        }
        if (criterioOrdinamento.equals(Costanti.CRITERIO_ORDINAMENTO_VALORE_DEC)) {
            return o2.getValore() - o1.getValore();
        }
        return 0;
    }
}
