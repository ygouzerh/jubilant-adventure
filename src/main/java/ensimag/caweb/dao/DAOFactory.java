
package ensimag.caweb.dao;

import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;

/**
 *
 * @author 
 */
public class DAOFactory {
    
    private final DataSource ds;
    
   
    public DAOFactory(DataSource ds) {
        this.ds = ds;
    }
    
    
    
    
    
    /* gets a new connection to the database */
    public Connection getConnection() throws SQLException {
        return ds.getConnection();
    } 
    
    
    /* returns a new ParentDaoImpl */
    public ParentDao getParentDao() {
        return new ParentDaoImpl( this );
    }
    
    //TODO singleton
    
    
    
    
}
