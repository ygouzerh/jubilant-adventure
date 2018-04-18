/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.forms;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ayoubmrini424
 */
public class ValidationUtilitaire {
    
    /*
    * returns null if a field in empty, its value in lower case (if not a password) instead
    */
    public static String fieldName( HttpServletRequest request, String fieldName ) {
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
    
    
    /**
     * Validate the given email.
     */
    public static void validateEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Validate the given password.
     */
    public static void validatePassword( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caractères." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
    
}
