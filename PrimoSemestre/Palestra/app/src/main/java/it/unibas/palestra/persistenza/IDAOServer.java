package it.unibas.palestra.persistenza;

import java.util.List;

import it.unibas.palestra.modello.Scheda;

public interface IDAOServer {
    public List<Scheda> findSchedaByDifficolta(int difficolta);
    public void updateListaSchede(List<Scheda> listaSchede);
}
