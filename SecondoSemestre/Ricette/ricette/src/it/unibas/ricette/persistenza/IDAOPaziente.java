package it.unibas.ricette.persistenza;

import it.unibas.ricette.modello.Paziente;
import java.util.List;


public interface IDAOPaziente extends IDAOGenerico<Paziente>{
        
    public List<Paziente> findByNome(String nome) throws DAOException;
    
}
