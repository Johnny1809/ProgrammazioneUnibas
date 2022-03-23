package it.unibas.aziende.persistenza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class DataSource {

    private static Logger logger = LoggerFactory.getLogger(DataSource.class);
    private String uriJDBC = "jdbc:postgresql:aziende";
    private String username = "pguser";
    private String password = "pguser";
    
    static {
        try {
            Class.forName("org.postgresql.Driver");
            logger.debug("Driver caricato");
        } catch (ClassNotFoundException ex) {
            logger.error("Non è stato possibile caricare il driver: " + ex.getMessage());
            throw new IllegalArgumentException(ex);
        }
    }
    
    public Connection getConnection () throws DAOException{
        try {
            return DriverManager.getConnection(uriJDBC, username, password);
        } catch (SQLException ex) {
            throw new DAOException("Non è stato possibile creare la connessione: " + ex.getMessage());
        }        
    }
    
    public void close (Connection connection) {
        if (connection != null) try {
            connection.close();
        } catch (SQLException ex) {
            logger.warn("non è stato possibile chiudere la connessione");
        }
    }
    
}
