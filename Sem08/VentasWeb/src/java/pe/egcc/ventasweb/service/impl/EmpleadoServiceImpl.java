package pe.egcc.ventasweb.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import pe.egcc.ventasweb.db.AccesoDB;
import pe.egcc.ventasweb.model.Empleado;
import pe.egcc.ventasweb.service.espec.EmpleadoServiceEspec;
import pe.egcc.ventasweb.service.mapper.EmpleadoMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class EmpleadoServiceImpl
        implements EmpleadoServiceEspec {

  private final String SQL_SELECT = "select "
          + "idemp, nombre, apellido, email, telefono "
          + "from empleado ";
  private final String SQL_INSERT = "insert into empleado "
          + "(nombre, apellido, email, telefono) "
          + "values(?, ?, ?, ?) ";
  private final String SQL_UPDATE = "UPDATE ";
  private final String SQL_DELETE = "DELETE ";

  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Obtener ID del empleado
      String sql = "select idemp from usuario "
              + "where usuario = ?  and "
              + "clave = SHA(?)  and estado = 1";
      PreparedStatement pstm;
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      int idemp = -1;
      if (rs.next()) {
        idemp = rs.getInt("idemp");
      }
      rs.close();
      pstm.close();
      if (idemp == -1) {
        throw new Exception("Datos incorrectos.");
      }
      bean = leer(idemp);
    } catch (Exception e) {
      String texto = "Error en el proceso. ";
      texto += e.getMessage();
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

  @Override
  public void crear(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void modificar(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void eliminar(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Empleado leer(int id) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = SQL_SELECT + "where idemp = ?";
      PreparedStatement pstm;
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, id);
      ResultSet rs = pstm.executeQuery();
      EmpleadoMapper mapper = new EmpleadoMapper();
      if (rs.next()) {
        bean = mapper.mapRow(rs);
      }
      rs.close();
      pstm.close();
      if(bean == null){
        throw new Exception("Datos incorrectos.");
      }
    } catch (Exception e) {
      String texto = "Error en el proceso. ";
      texto += e.getMessage();
      throw new RuntimeException(texto);
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

  @Override
  public List<Empleado> leer() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public List<Empleado> leer(Empleado bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
