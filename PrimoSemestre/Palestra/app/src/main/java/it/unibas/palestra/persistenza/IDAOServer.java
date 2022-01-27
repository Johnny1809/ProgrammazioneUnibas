package it.unibas.palestra.persistenza;

import java.util.List;

import it.unibas.palestra.modello.Scheda;

public interface IDAOServer {
    List<Scheda> findSchedaByDifficolta(int difficolta);
}
