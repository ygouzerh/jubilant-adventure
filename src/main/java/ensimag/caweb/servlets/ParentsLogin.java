/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.servlets;

import ensimag.caweb.beans.Parent;
import ensimag.caweb.dao.DAOFactory;
import ensimag.caweb.dao.ParentDao;
import ensimag.caweb.forms.LoginForm;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ayoubmrini424
 */
@WebServlet(name = "ParentsLogin", urlPatterns = {"/ParentsLogin"})
public class ParentsLogin extends HttpServlet {
    
    public static final String HOME_VIEW        = "/WEB-INF/Accueil_parents.jsp";
    public static final String LOGIN_VIEW        = "/WEB-INF/Connexion_parents.jsp";
    public static final String CONF_DAO_FACTORY = "daofactory";
    public static final String ATT_FORM         = "form";
    public static final String ATT_PARENT         = "parent";
    



    private ParentDao parentDao;
    
    @Override
    public void init() throws ServletException {
        /* Gets the unique instance of DAOFactory and then creates a new ParentDao object and stocks it in parentDao  */
        this.parentDao = ( (DAOFactory) getServletContext().getAttribute( CONF_DAO_FACTORY ) ).getParentDao();
    }
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( LOGIN_VIEW ).forward( request, response );
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* Initialize a new LoginForm */
        LoginForm form = new LoginForm( parentDao );

        Parent parent = form.verifyLogin( request );
        
        request.setAttribute( ATT_FORM, form );
        request.setAttribute( ATT_PARENT, parent );
        
        /* get the session from the reqest */
        HttpSession session = request.getSession();
        /*we add the bean parent to the session, parent may be null (sanitycheck) */
        session.setAttribute( ATT_PARENT, parent );
        
        if (parent == null ) {
            this.getServletContext().getRequestDispatcher( LOGIN_VIEW ).forward( request, response );
        } else {
            this.getServletContext().getRequestDispatcher( HOME_VIEW ).forward( request, response );
        }


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
