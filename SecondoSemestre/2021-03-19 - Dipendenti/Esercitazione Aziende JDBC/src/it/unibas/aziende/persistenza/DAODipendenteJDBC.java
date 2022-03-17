package it.unibas.aziende.persistenza;

import it.unibas.aziende.modello.Azienda;
import it.unibas.aziende.modello.Dipendente;
import it.unibas.aziende.persistenza.DAOException;
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
            String query = "select * from dipendente where codice_fiscale = '" + codiceFiscale +"'";
            logger.debug(query);
            resultSet = statement.executeQuery(query);
            Dipendente dipendente = null;
            if(resultSet.next()){
                dipendente = new Dipendente();
                dipendente.setCodiceFiscale(resultSet.getString("codice_fiscale"));
                dipendente.setAnnoAssunzione(resultSet.getInt("anno_assunzione"));
                dipendente.setCognome(resultSet.getString("cognome"));
                dipendente.setNome(resultSet.getString("nome"));
            }
            return dipendente;
        } catch (SQLException ex) {
            throw new DAOException("E' stato impossibile eseguire la query: " + ex.getMessage());
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
            StringBuilder sb =  new StringBuilder();
            sb.append("insert into dipendente (codice_fiscale, nome, cognome, anno_assunzione, azienda) values (");
            sb.append("'" + dipendente.getCodiceFiscale() +"', ");
            sb.append("'" + dipendente.getNome()+"', ");
            sb.append("'" + dipendente.getCognome()+"', ");
            sb.append(dipendente.getAnnoAssunzione()+", ");
            sb.append("'" + azienda.getPartitaIVA() + "')");
            String query = sb.toString();
            statement.execute(query);
            logger.debug("Eseguita la query " +  query);
        } catch (SQLException e) {
            throw new DAOException("Non è stato possibile eseguire la query: " + e.getMessage());
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
            String query = "delete from dipendente where codice_fiscale = '" + dipendente.getCodiceFiscale() + "'";
            logger.debug(query);
            statement.executeUpdate(query);
        } catch (SQLException e) {
            throw new DAOException("Non è stato possibile eseguire la query: " + e.getMessage());
        }
    }

}
