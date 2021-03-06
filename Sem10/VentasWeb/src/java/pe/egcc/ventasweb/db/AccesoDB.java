package pe.egcc.ventasweb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public final class AccesoDB {

  private AccesoDB() {
  }
  
  public static Connection getConnection() throws SQLException{
    // Parámetros para la conexión
    String driver = "com.mysql.jdbc.Driver";
    String urlDB = "jdbc:mysql://172.17.19.251:3306/ventas";
    String user = "ventas";
    String password = "admin";
    // Variables
    Connection cn = null;
    try {
      // Paso 1: Cargar el driver
      Class.forName(driver).newInstance();
      // Paso 2: Crear objeto Connection
      cn = DriverManager.getConnection(urlDB, user, password);
    } catch (ClassNotFoundException e) {
      throw new SQLException("No se encuentra el driver.");
    } catch(SQLException e){
      throw e;
    } catch(Exception e){
      throw new SQLException("No se tiene acceso a la BD.");
    }
    return cn;
  }
  
} // Fin de AccesoDB
