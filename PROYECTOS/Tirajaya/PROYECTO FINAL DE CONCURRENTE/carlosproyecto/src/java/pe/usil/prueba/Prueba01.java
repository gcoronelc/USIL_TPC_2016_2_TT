package pe.usil.prueba;

import java.sql.Connection;
import pe.usil.bd.AccesoDB;


public class Prueba01 {
    public static void main(String[] args) {
        try {
            Connection cn = AccesoDB.getConnection();
            System.out.println("Conexion ok");
            cn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
