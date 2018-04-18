
package ensimag.caweb.forms;

import ensimag.caweb.beans.Parent;
import ensimag.caweb.dao.ParentDao;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

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
    
    public String getResult() {
        return result;
    }

    public Map<String, String> getErrors() {
        return errors;
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
    
    
    /**
     * Validate the given email.
     */
    private void validateEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Validate the given password.
     */
    private void validatePassword( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }

    /*
     * add a new error.
     */
    private void setError( String champ, String message ) {
        errors.put( champ, message );
    }

    /*
    * returns null if a field in empty, its value in lower case (if not a password) instead
    */
    private static String fieldName( HttpServletRequest request, String fieldName ) {
        String value = request.getParameter( fieldName );
        if ( value == null || value.trim().length() == 0 ) {
            return null;
        } else {
            if (!fieldName.equals("password") && !fieldName.equals("motdepasse")) {
                /* Converts to lower case if not a password */
                return value.trim().toLowerCase();
            } else {
                return value.trim();
            }

        }
    }
    
   
}