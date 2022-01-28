package it.unibas.palestra.persistenza;

import java.util.List;

import it.unibas.palestra.modello.Attrezzo;
import it.unibas.palestra.modello.Scheda;

public interface IDAOServer {
    public List<Scheda> findSchedaByDifficolta(int difficolta);
    public List<Scheda> findAllSchede();
    public List<Attrezzo> findAllAttrezzi();
    void updateListaSchede(Scheda scheda);
}
