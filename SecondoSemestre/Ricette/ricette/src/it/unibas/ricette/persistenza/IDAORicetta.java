package it.unibas.ricette.persistenza;

import it.unibas.ricette.modello.Ricetta;
import java.util.Calendar;
import java.util.List;

public interface IDAORicetta extends IDAOGenerico<Ricetta> {

    List<Ricetta> findByPeriodo(Calendar inizio, Calendar fine) throws DAOException;

}
