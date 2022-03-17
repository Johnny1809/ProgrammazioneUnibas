package it.unibas.aziende.persistenza;

import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Dipendente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAOAziendaJDBC implements IDAOAzienda {

    private DataSource dataSource = new DataSource();
    private static Logger logger = LoggerFactory.getLogger(DAOAziendaJDBC.class);

    @Override
    public List<Azienda> findBySede(String sede) throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            String query = "select * from azienda where sede = '" + sede + "' order by denominazione asc";
            logger.info(query);
            resultSet = statement.executeQuery(query);
            List<Azienda> aziende = new ArrayList<>();
            while (resultSet.next()) {
                Azienda azienda = new Azienda();
                azienda.setPartitaIVA(resultSet.getString("partita_iva"));
                azienda.setDenominazione(resultSet.getString("denominazione"));
                azienda.setSede(resultSet.getString("sede"));
                aziende.add(azienda);
            }
            return aziende;
        } catch (SQLException ex) {
            throw new DAOException("Non è stato possibile eseguire la query: " + ex.getMessage());
        } finally {
            dataSource.close(connection);
        }
    }

    @Override
    public void caricaDipendenti(Azienda azienda) throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            String query = "select * from dipendente where azienda = '" + azienda.getPartitaIVA() + "'";
            logger.info(query);
            resultSet = statement.executeQuery(query);
            List<Dipendente> dipendenti = new ArrayList<>();
            while (resultSet.next()) {
                Dipendente dipendente = new Dipendente();
                dipendente.setCodiceFiscale(resultSet.getString("codice_fiscale"));
                dipendente.setNome(resultSet.getString("nome"));
                dipendente.setCognome(resultSet.getString("cognome"));
                dipendente.setAnnoAssunzione(resultSet.getInt("anno_assunzione"));
                dipendenti.add(dipendente);
            }
            azienda.setDipendenti(dipendenti);
        } catch (SQLException ex) {
            throw new DAOException("Non è stato possibile eseguire la query: " + ex.getMessage());
        } finally {
            dataSource.close(connection);

        }
    }

}
