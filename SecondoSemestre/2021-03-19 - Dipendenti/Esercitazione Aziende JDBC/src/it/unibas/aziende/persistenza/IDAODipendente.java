package it.unibas.aziende.persistenza;

import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Dipendente;


public interface IDAODipendente {

    public Dipendente findByCodiceFiscale (String codiceFiscale) throws DAOException;
    
    public void salvaDipendente (Azienda azienda, Dipendente dipendente) throws DAOException;
    
    public void cancellaDipendente (Dipendente dipendente) throws DAOException;
}
