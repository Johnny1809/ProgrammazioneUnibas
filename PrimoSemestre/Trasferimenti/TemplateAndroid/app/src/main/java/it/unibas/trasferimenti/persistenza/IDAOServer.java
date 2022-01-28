package it.unibas.trasferimenti.persistenza;

import java.util.List;

import it.unibas.trasferimenti.modello.Calciatore;

public interface IDAOServer {
    List<Calciatore> findAllCalciatori(String criterioOrdinamento);

    void salvaCalciatore(Calciatore calciatore);
}
