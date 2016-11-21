package pe.egcc.ventasweb.service.impl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public final class JdbcUtil {

  private JdbcUtil() {
  }
  
  public static java.sql.Date 
        utilDateToSqlDate(java.util.Date utilDate){
    java.sql.Date sqlDate;
    sqlDate = new java.sql.Date(utilDate.getTime());
    return sqlDate;
  }
}
