package it.unibas.sondaggi.persistenza;

import it.unibas.sondaggi.modello.Sondaggio;
import it.unibas.sondaggi.persistenza.hibernate.DAOException;
import it.unibas.sondaggi.persistenza.hibernate.DAOGenericoHibernate;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DAOSondaggioHibernate extends DAOGenericoHibernate<Sondaggio> implements IDAOSondaggio{

    public DAOSondaggioHibernate() {
        super(Sondaggio.class);
    }

    
    @Override
    public List<Sondaggio> findByTematica(String tematica) throws DAOException {
        Criteria criteria = getSession().createCriteria(Sondaggio.class);
        criteria.add(Restrictions.eq("tematica", tematica));
        criteria.addOrder(Order.asc("dataScadenza"));
        List<Sondaggio> risultato = criteria.list();
        return risultato;
    }
    
}
