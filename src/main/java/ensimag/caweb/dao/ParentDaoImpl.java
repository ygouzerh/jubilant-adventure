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
    private static final String SQL_SELECT_WITH_EMAIL_AND_PASSWORD = "SELECT email, password, nom FROM parent WHERE email=? AND password=rpad(?, 64, ' ')";

    public ParentDaoImpl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
    }

    
    
    @Override
    public void add(Parent parent) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Parent find(String email, String motDePasse) throws DAOException {
        
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
    
        
    /*
     * performs a mapping between a result of a request (resultSet)
     * and a bean (parent) which it returns.
     */
    private static Parent map( ResultSet resultSet ) throws SQLException {
        Parent parent = new Parent();
        
        parent.setEmail( resultSet.getString( "email" ) );
        parent.setMotDePasse( resultSet.getString( "password" ) );
        parent.setNom(resultSet.getString( "nom" ));
        // TODO need others ?

        return parent;
    }

}
