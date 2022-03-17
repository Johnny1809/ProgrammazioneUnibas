/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package it.unibas.aziende.test.persistenza;

import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Dipendente;
import it.unibas.aziende.persistenza.DAOAziendaJDBC;
import it.unibas.aziende.persistenza.DAODipendenteJDBC;
import it.unibas.aziende.persistenza.DAOException;
import it.unibas.aziende.persistenza.IDAOAzienda;
import it.unibas.aziende.persistenza.IDAODipendente;
import java.util.List;
import junit.framework.TestCase;


public class DAOAziendaJDBCTest extends TestCase{

    private IDAOAzienda daoAzienda = new DAOAziendaJDBC();
    private IDAODipendente daoDipendente = new DAODipendenteJDBC();
    
    public DAOAziendaJDBCTest() {
    }
    
    public void testCercaAziende() {
        try {
            List<Azienda> risultatoPotenza = daoAzienda.findBySede("Potenza");
            assertEquals(0, risultatoPotenza.size());            
            List<Azienda> risultatoSanFrancisco = daoAzienda.findBySede("San Francisco");
            assertEquals(2, risultatoSanFrancisco.size());
            Azienda aziendaGoogle = risultatoSanFrancisco.get(1);
            assertEquals("Google", aziendaGoogle.getDenominazione());
            assertEquals(0, aziendaGoogle.getDipendenti().size());
            daoAzienda.caricaDipendenti(aziendaGoogle);
            assertEquals(2, aziendaGoogle.getDipendenti().size());
            Dipendente dipendenteTest = new Dipendente("xxxxxxx", "Test", "Test", 1990);
            daoDipendente.salvaDipendente(aziendaGoogle, dipendenteTest);
            daoAzienda.caricaDipendenti(aziendaGoogle);
            assertEquals(3, aziendaGoogle.getDipendenti().size());
            assertNotNull(daoDipendente.findByCodiceFiscale("xxxxxxx"));
            daoDipendente.cancellaDipendente(dipendenteTest);
            daoAzienda.caricaDipendenti(aziendaGoogle);
            assertEquals(2, aziendaGoogle.getDipendenti().size()); 
            assertNull(daoDipendente.findByCodiceFiscale("xxxxxxx"));
        } catch (DAOException ex) {
            ex.printStackTrace();
            fail();
        }
    }

}