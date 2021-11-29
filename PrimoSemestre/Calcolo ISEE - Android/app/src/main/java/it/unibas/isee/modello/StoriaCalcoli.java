package it.unibas.isee.modello;

import java.util.ArrayList;
import java.util.List;

public class StoriaCalcoli {

    private List<ModuloIsee> storia = new ArrayList<>();

    public List<ModuloIsee> getStoria() {
        return storia;
    }

    public void aggiungiCalcolo(ModuloIsee moduloIsee) {
        storia.add(moduloIsee);
    }

}
