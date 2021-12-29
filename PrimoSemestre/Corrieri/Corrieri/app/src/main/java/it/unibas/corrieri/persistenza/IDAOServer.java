package it.unibas.corrieri.persistenza;

import java.util.List;

import it.unibas.corrieri.modello.Corriere;
import it.unibas.corrieri.modello.Pacco;
import it.unibas.corrieri.modello.Utente;

public interface IDAOServer {

    public List<Corriere> findCorriereByZona(String zona) throws DAOException;
    public List<Utente> findAllUtenti() throws DAOException;
    public void salvaPacco(Pacco pacco) throws DAOException;

}
