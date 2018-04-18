/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ensimag.caweb.config;

import ensimag.caweb.dao.DAOFactory;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 *
 * @author ayoubmrini424
 */
public class DAOFactoryInitialization implements ServletContextListener {
    
    @Resource(name="jdbc/caweb")
    private DataSource ds;

    private static final String ATT_DAO_FACTORY = "daofactory";
    private DAOFactory daoFactory;


    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        this.daoFactory = new DAOFactory(ds);
        servletContext.setAttribute( ATT_DAO_FACTORY, this.daoFactory );

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Nothing for the moment
    }

    public DataSource getDs() {
        if(this.ds == null){
            throw new NullPointerException("Unable to load the datasource");
        }
        return ds;
    }
        
}
