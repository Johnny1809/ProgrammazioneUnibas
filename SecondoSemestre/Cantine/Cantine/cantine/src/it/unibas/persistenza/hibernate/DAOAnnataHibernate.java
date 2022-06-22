package it.unibas.persistenza.hibernate;

import it.unibas.cantine.modello.Annata;
import it.unibas.persistenza.DAOException;
import it.unibas.persistenza.IDAOAnnata;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DAOAnnataHibernate extends DAOGenericoHibernate<Annata> implements IDAOAnnata{

    public DAOAnnataHibernate() {
        super(Annata.class);
    }

    @Override
    public List<Annata> findByAnno(int anno) throws DAOException{
        Criteria criteria = DAOUtilHibernate.getCurrentSession().createCriteria(Annata.class);
        criteria.add(Restrictions.eq("anno", anno));
        criteria.addOrder(Order.asc("mese"));
        List<Annata> risultato  = criteria.list();
        return risultato;
    }

    
    
}
