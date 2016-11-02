
package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassConection {
    public Connection conecion(){
        Connection cn = null;
        try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         cn=DriverManager.getConnection("jdbc:sqlserver://Maria-PC:1433;DatabaseName=PROYETO;","sa","123");
         }catch(  ClassNotFoundException | SQLException c){}
       return cn; 
    }
    
}
