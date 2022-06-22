package it.unibas.sondaggi.persistenza;

import it.unibas.sondaggi.modello.Azienda;
import it.unibas.sondaggi.persistenza.hibernate.DAOGenericoHibernate;

public class DAOAziendaHibernate extends DAOGenericoHibernate<Azienda> implements IDAOAzienda{
    
    public DAOAziendaHibernate() {
        super(Azienda.class);
    }
    
}
