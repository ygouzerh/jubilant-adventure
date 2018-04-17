/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author 
 */
public class DAOUtilitaire {
    
    /*
     * Initializes and returns the prepared request based on the Connection,
     * the sql (String) and the objects.
     */
    public static PreparedStatement initializePreparedRequest( Connection connection, String sql, boolean returnGeneratedKeys,Object...objects) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement( sql, returnGeneratedKeys ? Statement.RETURN_GENERATED_KEYS : Statement.NO_GENERATED_KEYS );
        for ( int i = 0; i < objects.length; i++ ) {
            preparedStatement.setObject( i + 1, objects[i] );
        }

        return preparedStatement;
    }
    
    /* closes the resultset */
    public static void closure( ResultSet resultSet ) {
        if ( resultSet != null ) {
            try {
                resultSet.close();
            } catch ( SQLException e ) {
                System.out.println( "ResultSet closure failed : " + e.getMessage() );
            }
        }
    }

    /* closes the statement */
    public static void closure( Statement statement ) {
        if ( statement != null ) {
            try {
                statement.close();
            } catch ( SQLException e ) {
                System.out.println( "Statement closure failed : " + e.getMessage() );
            }
        }
    }

    /* closes the connexion */
    public static void closure( Connection connexion ) {
        if ( connexion != null ) {
            try {
                connexion.close();
            } catch ( SQLException e ) {
                System.out.println( "Connection closure failed : " + e.getMessage() );
            }
        }
    }

    /* closes the statement and the connexion */
    public static void closures( Statement statement, Connection connexion ) {
        closure( statement );
        closure( connexion );
    }

    /* closes the resultset, the statement and the connexion */
    public static void closures( ResultSet resultSet, Statement statement, Connection connexion ) {
        closure( resultSet );
        closure( statement );
        closure( connexion );
    }
    
}
