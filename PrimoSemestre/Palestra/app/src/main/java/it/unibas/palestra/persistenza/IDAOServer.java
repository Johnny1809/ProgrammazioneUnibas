package it.unibas.palestra.persistenza;

import java.util.List;

import it.unibas.palestra.modello.Attrezzo;
import it.unibas.palestra.modello.Scheda;

public interface IDAOServer {
    public List<Scheda> findSchedaByDifficolta(int difficolta);
    public List<Attrezzo> findAllAttrezzi();
    public void updateListaSchede(List<Scheda> listaSchede);
}
