package it.unibas.sondaggi.test.persistenza;

import it.unibas.sondaggi.modello.Sondaggio;
import it.unibas.sondaggi.persistenza.DAOSondaggioHibernate;
import it.unibas.sondaggi.persistenza.IDAOSondaggio;
import it.unibas.sondaggi.persistenza.hibernate.DAOException;
import it.unibas.sondaggi.persistenza.hibernate.DAOUtilHibernate;
import java.util.List;
import junit.framework.TestCase;

public class DAOSondaggiHibernateTest extends TestCase{

    private IDAOSondaggio daoSondaggio = new DAOSondaggioHibernate();
    
    public void testFindByTematica(){
        try {
            DAOUtilHibernate.beginTransaction();
            List<Sondaggio> sondaggiGenerici = daoSondaggio.findByTematica("generica");
            assertEquals(1, sondaggiGenerici.size());
            List<Sondaggio> sondaggiSportivi = daoSondaggio.findByTematica("sportivo");
            assertTrue(sondaggiSportivi.isEmpty());
            DAOUtilHibernate.commit();
        } catch (DAOException ex) {
            DAOUtilHibernate.rollback();
            fail();
        }
    }
    
}
