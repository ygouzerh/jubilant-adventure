/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.test.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Allow to test each internals modules.
 * Each sub classes must override the launcherTests() function
 * which run each specific unit test function using launchOneTest()
 * @author ygouzerh
 */
public abstract class AbstractTesteur extends HttpServlet {
   
    abstract protected ArrayList<String> launcherTests(HttpServletRequest request);

    /**
     * Handles the HTTP <code>GET</code> method.
     * Print the results of the tests.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("text/html;charset=UTF-8");
        ArrayList<String> launchingResults = launcherTests(request);
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Testeur</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Testeur at " + request.getContextPath() + "</h1>");
            for (String result : launchingResults){
                if( ! result.equals("") ){
                    out.println(result);
                }            
            }
            out.println("</body>");
            out.println("</html>");
        }
    }            
    
    /**
     * Launch a unit test if we have specified it in the request
     * @param nameField If this name is passed in argument, when we print the 
     * result of resultFunction
     * @param request The request to search the get fieldname
     * @param resultFunction Result of the unit test function
     * @return The result of the function in an paragraph html tag
     */
    protected String launchOneTest(HttpServletRequest request, String nameField, String resultFunction){
        if(request.getParameter("t").equals(nameField)){
            String result = "<p>"+resultFunction+"</p>";
            return result;
        }
        return "";
    }    
}
