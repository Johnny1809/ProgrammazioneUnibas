package it.unibas.persistenza;

import it.unibas.cantine.modello.Annata;
import it.unibas.persistenza.IDAOGenerico;
import java.util.List;

public interface IDAOAnnata  extends IDAOGenerico<Annata>{

    public List<Annata> findByAnno(int anno) throws DAOException;
    
}
