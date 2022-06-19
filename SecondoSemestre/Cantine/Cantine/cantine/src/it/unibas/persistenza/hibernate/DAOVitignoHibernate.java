package it.unibas.persistenza.hibernate;

import it.unibas.cantine.modello.Vitigno;
import it.unibas.persistenza.IDAOVitigno;

public class DAOVitignoHibernate extends DAOGenericoHibernate<Vitigno> implements IDAOVitigno{
    
    public DAOVitignoHibernate() {
        super(Vitigno.class);
    }
    
}
