package it.unibas.aziende.persistenza;

import it.unibas.aziende.modello.Azienda;
import java.util.List;


public interface IDAOAzienda {
    
    public List<Azienda> findBySede (String sede) throws DAOException;
    
    public void caricaDipendenti (Azienda azienda) throws DAOException;

}
