
package MacStore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import MacStore.db.AccesoDB;
import MacStore.model.Usuario;



public class LogInService {
    
      public Usuario validarUsuario(String usuario, String clave) {
    Usuario bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "SELECT e.idemp, u.usuario, u.estado " 
              + "FROM usuario u inner join empleado e "           
              + "on u.idemp=e.idemp "           
              + "where u.usuario= ? "
              + "and u.clave = SHA(?)";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        bean = new Usuario();
        bean.setCodigo(rs.getInt("idemp"));
        bean.setUsuario(rs.getString("usuario"));
        bean.setClave("********");
      }
      rs.close();
      pstm.close();
      if(bean == null){
        throw new Exception("Datos incorrectos.");
      }
    } catch (Exception e) {
      throw  new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }
}
