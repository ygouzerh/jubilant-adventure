/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.dao;

import ensimag.caweb.beans.Parent;

/**
 *
 * @author ayoubmrini424
 */
public interface ParentDao {
    
    void add( Parent parent ) throws DAOException;

    Parent find( String email, String motDePasse ) throws DAOException;
    
    void delete ( String email ) throws DAOException;
    //Add update function
    
    //Add delete function (if the family moved to another city for example)
    
}
