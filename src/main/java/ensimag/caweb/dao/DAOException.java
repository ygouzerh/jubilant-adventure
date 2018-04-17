
package ensimag.caweb.dao;

/**
 *
 * @author 
 */
public class DAOException extends RuntimeException {
    /*
     * Constructors
     */
    public DAOException( String message ) {
        super( message );
    }

    public DAOException( String message, Throwable cause ) {
        super( message, cause );
    }

    public DAOException( Throwable cause ) {
        super( cause );
    }
}
