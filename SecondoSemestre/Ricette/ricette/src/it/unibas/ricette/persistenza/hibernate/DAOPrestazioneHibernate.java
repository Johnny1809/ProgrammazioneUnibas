package it.unibas.ricette.persistenza.hibernate;

import it.unibas.ricette.modello.Prestazione;
import it.unibas.ricette.persistenza.IDAOPrestazione;

public class DAOPrestazioneHibernate extends DAOGenericoHibernate<Prestazione> implements  IDAOPrestazione{

    public DAOPrestazioneHibernate() {
        super(Prestazione.class);
    }

    
}
