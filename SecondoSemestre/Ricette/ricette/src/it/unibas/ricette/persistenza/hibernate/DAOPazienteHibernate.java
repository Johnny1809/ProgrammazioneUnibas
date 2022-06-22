package it.unibas.ricette.persistenza.hibernate;

import it.unibas.ricette.modello.Paziente;
import it.unibas.ricette.persistenza.DAOException;
import it.unibas.ricette.persistenza.IDAOPaziente;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class DAOPazienteHibernate extends DAOGenericoHibernate<Paziente> implements IDAOPaziente{

    public DAOPazienteHibernate() {
        super(Paziente.class);
    }
    
    @Override
    public List<Paziente> findByNome(String nome) throws DAOException {
        Criteria criteria = getSession().createCriteria(Paziente.class);
        criteria.add(Restrictions.eq("nome", nome));
        criteria.addOrder(Order.desc("dataDiNascita"));
        return criteria.list();
    }
    
}
