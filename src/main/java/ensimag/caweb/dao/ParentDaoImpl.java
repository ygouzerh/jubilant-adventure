/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.dao;

import ensimag.caweb.beans.Parent;
import static ensimag.caweb.dao.DAOUtilitaire.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author ayoubmrini424
 */
public class ParentDaoImpl implements ParentDao {
    
    private final DAOFactory daoFactory;
    private static final String SQL_SELECT_WITH_EMAIL_AND_PASSWORD = "SELECT * FROM parent WHERE email=? AND password=rpad(?, 64, ' ')";
    private static final String SQL_DELETE = "DELETE FROM PARENT WHERE email=?";
    private static final String SQL_INSERT = "INSERT INTO parent VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public ParentDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }
        
    @Override
    public void add( Parent parent ) throws DAOException {
        System.out.println(parent);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initializePreparedRequest( connection, SQL_INSERT, false,
                                                            parent.getId(),
                                                            parent.getNom(), parent.getPrenom(),
                                                            parent.getSexe(), parent.getDateNaissanceSql(),
                                                            parent.getAdresse(), parent.getEmail(),
                                                            parent.getTelephone(), parent.getMotDePasse(),
                                                            "rrr");           
            resultSet = preparedStatement.executeQuery();            
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            closures( resultSet, preparedStatement, connection );
        }
    }

    @Override
    public Parent find( String email, String motDePasse ) throws DAOException {
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Parent parent = null;
        
        try {
            /* get a connection */
            connection = daoFactory.getConnection();
            preparedStatement = initializePreparedRequest( connection, SQL_SELECT_WITH_EMAIL_AND_PASSWORD, false, email,motDePasse);
            
            resultSet = preparedStatement.executeQuery();

            if ( resultSet.next() ) {
                parent = map( resultSet );
            }
        
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            closures( resultSet, preparedStatement, connection );
        }

        return parent;
    }
    
    
    /**
     * Delete a parent
     * @param email The identifier of a parent
     */
    @Override
    public void delete( String email ) throws DAOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = daoFactory.getConnection();
            preparedStatement = initializePreparedRequest( connection, SQL_DELETE, false, email);           
            resultSet = preparedStatement.executeQuery();            
        } catch ( SQLException e ) {
            throw new DAOException( e );
        } finally {
            closures( resultSet, preparedStatement, connection );
        }
    }
    
        
    /*
     * performs a mapping between a result of a request (resultSet)
     * and a bean (parent) which it returns.
     * TODO : Get the right date format
     */
    private static Parent map( ResultSet resultSet ) throws SQLException {
        Parent parent = new Parent(resultSet.getInt( "id" ),                                
                                    resultSet.getString( "password" ),
                                    resultSet.getString( "email" ), 
                                    resultSet.getString( "nom" ),
                                    resultSet.getString( "prenom" ),
                                    resultSet.getString( "sexe" ),
                                    resultSet.getString( "adresse" ),
                                    resultSet.getString( "datenaissance" ),
                                    "dd/MM/yyyy",
                                    resultSet.getString( "telephone" ));
        return parent;
    }

}
