package ensimag.caweb.config;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test for the date treatment
 * @author ygouzerh
 */
public class DateModifierTest {
    
    public DateModifierTest() {
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
     * Test of dateFromString method, of class DateModifier.
     */
    @Test
    public void testDateFromString() {
        System.out.println("dateFromString");
        String dateString = "28/12/2015";
        String format = "dd/MM/yyyy";
        Date dateInitial = DateModifier.dateFromString(dateString, format);
        assertEquals(dateInitial.toString(), "Mon Dec 28 00:00:00 CET 2015");
        Date newDate = DateModifier.convertDateSqlToUtil(DateModifier.convertDateUtilToSql(dateInitial));
        assertEquals(dateInitial.getTime(), newDate.getTime());
    }
    
    @Test
    public void testDateConversion(){
        System.out.println("testDateConversion");
        String dateString = "28/12/2015";
        String format = "dd/MM/yyyy";
        Date dateInitial = DateModifier.dateFromString(dateString, format);
        Date newDate = DateModifier.convertDateSqlToUtil(DateModifier.convertDateUtilToSql(dateInitial));
        assertEquals(dateInitial.getTime(), newDate.getTime());
    }
}
