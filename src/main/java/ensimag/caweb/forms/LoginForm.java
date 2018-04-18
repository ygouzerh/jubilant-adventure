
package ensimag.caweb.forms;

import ensimag.caweb.beans.Parent;
import ensimag.caweb.dao.ParentDao;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import static ensimag.caweb.forms.ValidationUtilitaire.*;


/**
 *
 * @author 
 */
public class LoginForm {
    
    private static final String EMAIL  = "email";
    private static final String PASSWORD   = "motdepasse";
    
    private String result;
    private Map<String, String> errors = new HashMap<String, String>();
        
    /* LoginForm uses a ParentDAO to interact with the base*/
    private final ParentDao parentDao;

    public LoginForm( ParentDao parentDao ) {
        this.parentDao = parentDao;
        
    }
    
    public Parent verifyLogin(HttpServletRequest request) {
        String email = fieldName( request, EMAIL );
        String password = fieldName( request, PASSWORD );
        
        try {
            validateEmail( email );
        } catch ( Exception e ) {
            setError( EMAIL, e.getMessage() );
        }
        
        try {
            validatePassword( password );
        } catch ( Exception e ) {
            setError( PASSWORD, e.getMessage() );
        }
        
        if (!errors.isEmpty()) {
            result = "Echec de la connexion, veuillez réessayer ";
            return null;
        }
        
               
        Parent parent = parentDao.find(email, password);
        
        if ( parent == null) {
            result = "Echec de la connexion, veuillez réessayer ";
        }
        return parent;
        //TODO
  
    }
    
    /*
     * returns the result of the fill in (fail or success).
     */
    public String getResult() {
        return result;
    }

    /*
     * return errors to help the user fixing the problems.
     */
    public Map<String, String> getErrors() {
        return errors;
    }

    /*
     * adds a new error.
     */
    private void setError( String champ, String message ) {
        errors.put( champ, message );
    }


    
   
}