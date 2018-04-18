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

    @Override
    public void init() throws ServletException {
        /* Gets the unique instance of DAOFactory and then creates a new ParentDao object and stocks it in parentDao  */
        this.parentDao = ( (DAOFactory) getServletContext().getAttribute( "daofactory" ) ).getParentDao();
    }
    @Override
    protected ArrayList<String> launcherTests(HttpServletRequest request) {
        ArrayList<String> results = new ArrayList<>();
        results.add(this.launchOneTest(request, "addParent", this.addParent()));
        return results;
    }
    
    /**
     * Test to insert one parent
     * @return the name of the function 
     */
    private String addParent(){
        System.out.println("add");
        Parent parent = new Parent(28, "test1@parent.fr", "one", "test", "M",
                                   "8 rue du test", "31/02/2018", "06251548", "toto");
        parentDao.add(parent);
        return "AddParent : Ok";
    }
}
