/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.test.servlets;

import ensimag.caweb.beans.Parent;
import ensimag.caweb.dao.DAOFactory;
import ensimag.caweb.dao.ParentDao;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet that test the Parent dao
 * @author ygouzerh
 */
@WebServlet(name = "TesteurParentDao", urlPatterns = {"/test/parentDao"})
public class TesteurParentDao extends AbstractTesteur {
    
    private ParentDao parentDao;
    Parent parentTest1 = new Parent(15, "toto", "test1@testing.com",
                            "test", "One",
                            "F", "8 street of testing",
                            "28/02/1998", "dd/MM/yyyy", "06281548");
    @Override
    public void init() throws ServletException {
        /* Gets the unique instance of DAOFactory and then creates a new ParentDao object and stocks it in parentDao  */
        this.parentDao = ( (DAOFactory) getServletContext().getAttribute( "daofactory" ) ).getParentDao();
    }
    @Override
    protected ArrayList<String> launcherTests(HttpServletRequest request) {
        ArrayList<String> results = new ArrayList<>();
        results.add(this.launchOneTest(request, "addParent", this.addParent()));
        results.add(this.launchOneTest(request, "deleteParent", this.deleteParent()));
        results.add(this.launchOneTest(request, "findParent", this.findParent()));
        return results;
    }
    
    /**
     * Test to insert one parent
     * Assume that the find works
     * @return the name of the function 
     */
    private String addParent(){
        System.out.println("add");        
        parentDao.add(parentTest1);
        return "AddParent : No Sql errors";
    }
    
    /**
     * Test if we found a parent
     * Assume that the adding works
     * @return the parent of the function
     */
    private String findParent(){
        this.addParent();
        if(parentDao.find(parentTest1.getEmail(), parentTest1.getMotDePasse()) != null){
            return "Find : Ok";            
        } else {
            return "Find : No";
        }
    }
    
    /**
     * Test to delete a parent
     * @return the result of the test
     */
    private String deleteParent(){
        System.out.println("delete");
        addParent();
        parentDao.delete(parentTest1.getEmail());
        if(parentDao.find(parentTest1.getEmail(), "toto") != null){
            return "Delete : No";
        } else {
            return "Delete : Ok";
        }
    }
}
