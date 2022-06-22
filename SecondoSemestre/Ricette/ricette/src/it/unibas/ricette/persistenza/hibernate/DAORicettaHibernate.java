package it.unibas.ricette.persistenza.hibernate;

import it.unibas.ricette.modello.Ricetta;
import it.unibas.ricette.persistenza.DAOException;
import it.unibas.ricette.persistenza.IDAORicetta;
import java.util.Calendar;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class DAORicettaHibernate extends DAOGenericoHibernate<Ricetta> implements IDAORicetta {

    public DAORicettaHibernate() {
        super(Ricetta.class);
    }

    public List<Ricetta> findByPeriodo(Calendar inizio, Calendar fine) throws DAOException {
        Session session = DAOUtilHibernate.getCurrentSession();
        Criteria criteria = session.createCriteria(Ricetta.class);
        criteria.add(Restrictions.between("dataCreazione", inizio, fine));
        List<Ricetta> risultato = criteria.list();
        return risultato;

    }

}
