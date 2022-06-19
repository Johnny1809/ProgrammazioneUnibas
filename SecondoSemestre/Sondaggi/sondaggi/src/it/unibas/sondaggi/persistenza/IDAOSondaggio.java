package it.unibas.sondaggi.persistenza;
import it.unibas.sondaggi.modello.Sondaggio;
import it.unibas.sondaggi.persistenza.hibernate.DAOException;
import it.unibas.sondaggi.persistenza.hibernate.IDAOGenerico;
import java.util.List;

public interface IDAOSondaggio extends IDAOGenerico<Sondaggio>{
    List<Sondaggio> findByTematica(String tematica) throws DAOException;
}
