package MacStore.service;

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
