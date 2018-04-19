package ensimag.caweb.config;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Use this class to manipulate the date
 * @author ygouzerh
 */
public class DateModifier {
    
    /**
     * Tranform a date passed in the specified format into a java.util.date
     * @param dateString The string date in the format format
     * @param format The format of the string, for example : dd/MM/yyyy
     * @return The Java.util.date
     */
    public static java.util.Date dateFromString(String dateString, String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        java.util.Date dateTransformed = null;
        try {
            dateTransformed = simpleDateFormat.parse(dateString);
        } catch (ParseException e){
            System.err.println("The date must be in "+format+" format");
        }
        return dateTransformed;
    }
    
    /**
     * Transform a java.util.Date to a java.sql Date
     * @param utilDate the util date
     * @return the sql date
     */
    public static java.sql.Date convertDateUtilToSql(java.util.Date utilDate){
        return new java.sql.Date(utilDate.getTime());
    }
    
    /**
     * Transform a java.sql.Date to a java.util date
     * @param sqlDate
     * @return 
     */
    public static java.util.Date convertDateSqlToUtil(java.sql.Date sqlDate){
        return new java.util.Date(sqlDate.getTime());
    }
}
