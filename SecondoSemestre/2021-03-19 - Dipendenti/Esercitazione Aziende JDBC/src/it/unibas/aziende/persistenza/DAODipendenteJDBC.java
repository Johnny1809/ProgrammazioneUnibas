package it.unibas.aziende.persistenza;

import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Dipendente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DAODipendenteJDBC implements IDAODipendente {

    private DataSource dataSource = new DataSource();
    private static Logger logger = LoggerFactory.getLogger(DAODipendenteJDBC.class);

    @Override
    public Dipendente findByCodiceFiscale(String codiceFiscale) throws DAOException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            String query = "select * from dipendente where codice_fiscale = '" + codiceFiscale + "'";
            logger.info(query);
            resultSet = statement.executeQuery(query);
            Dipendente dipendente = null;
            if (resultSet.next()) {
                dipendente = new Dipendente();
                dipendente.setCodiceFiscale(resultSet.getString("codice_fiscale"));
                dipendente.setNome(resultSet.getString("nome"));
                dipendente.setCognome(resultSet.getString("cognome"));
                dipendente.setAnnoAssunzione(resultSet.getInt("anno_assunzione"));
            }
            return dipendente;
        } catch (SQLException ex) {
            throw new DAOException("Non è stato possibile eseguire la query: " + ex.getMessage());
        } finally {
            dataSource.close(connection);
        }
    }

    @Override
    public void salvaDipendente(Azienda azienda, Dipendente dipendente) throws DAOException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            StringBuilder query = new StringBuilder();
            query.append("insert into dipendente (codice_fiscale,  nome, cognome, anno_assunzione, azienda) values (");
            query.append("'").append(dipendente.getCodiceFiscale()).append("', ");
            query.append("'").append(dipendente.getNome()).append("', ");
            query.append("'").append(dipendente.getCognome()).append("', ");
            query.append("").append(dipendente.getAnnoAssunzione()).append(", ");
            query.append("'").append(azienda.getPartitaIVA()).append("' )");
            logger.info(query.toString());
            statement.executeUpdate(query.toString());
        } catch (SQLException ex) {
            throw new DAOException("Non è stato possibile eseguire la query: " + ex.getMessage());
        } finally {
            dataSource.close(connection);
        }
    }

    @Override
    public void cancellaDipendente(Dipendente dipendente) throws DAOException {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.createStatement();
            String query = "delete from dipendente where codice_fiscale = '"+ dipendente.getCodiceFiscale() + "'";
            logger.info(query);
            statement.executeUpdate(query);
        } catch (SQLException ex) {
            throw new DAOException("Non è stato possibile eseguire la query: " + ex.getMessage());
        } finally {
            dataSource.close(connection);
        }
    }

}
