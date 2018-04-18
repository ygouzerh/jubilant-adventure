package ensimag.caweb.dao;

import ensimag.caweb.beans.Parent;
import ensimag.caweb.config.DAOFactoryInitialization;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ygouzerh
 */
public class ParentDaoImplTest {
    @Resource(name="jdbc/caweb")
    private DataSource ds;
            
    public ParentDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of add method, of class ParentDaoImpl.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Parent parent = new Parent(28, "test1@parent.fr", "one", "test", "M",
                                   "8 rue du test", "31/02/2018", "06251548", "toto");
        DAOFactoryInitialization daoFactoryInit = new DAOFactoryInitialization();
        ParentDao instance = new DAOFactory(ds).getParentDao();
        instance.add(parent);
    }

    /**
     * Test of find method, of class ParentDaoImpl.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        String email = "";
        String motDePasse = "";
        ParentDaoImpl instance = null;
        Parent expResult = null;
        Parent result = instance.find(email, motDePasse);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ParentDaoImpl.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        String email = "";
        ParentDaoImpl instance = null;
        instance.delete(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
