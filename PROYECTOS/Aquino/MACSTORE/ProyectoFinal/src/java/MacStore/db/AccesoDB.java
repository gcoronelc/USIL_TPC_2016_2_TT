package MacStore.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class AccesoDB {

    private AccesoDB() {

    }

    public static Connection getConnection() throws SQLException {
        // Parámetros
        String driver = "com.mysql.jdbc.Driver";
        String urlDB = "jdbc:mysql://localhost:3306/SISTVENTAS";
        String user = "ventas";
        String pass = "admin";
        // Variable
        Connection cn = null;
        // Proceso
        try {
            // Cargar el driver
            Class.forName(driver).newInstance();
            // Obtener la conexión
            cn = DriverManager.getConnection(urlDB, user, pass);
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se ha encontrado el driver de BD.");
        } catch (SQLException e) {
            throw e;
        } catch (Exception e) {
            throw new SQLException("No se tiene acceso al servidor de BD.");
        }
        // Retorno
        return cn;
    }
}
