package pe.egcc.ventasweb.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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

  private final String SQL_SELECT = "select idemp, "
          + "nombre, apellido, email, telefono "
          + "from empleado ";
  private final String SQL_INSERT = "insert into "
          + "empleado(nombre, apellido, email, telefono) "
          + "values(?, ?, ?, ?) ";
  private final String SQL_UPDATE = "";
  private final String SQL_DELETE = "";

  @Override
  public void crear(Empleado bean) {
    Connection cn = null;
    try {
      // Obtener objeto Connection
      cn = AccesoDB.getConnection();
      // Inicio de Tx
      cn.setAutoCommit(false);
      // Registrar empleado
      PreparedStatement pstm = cn.prepareStatement(SQL_INSERT);
      pstm.setString(1, bean.getNombre());
      pstm.setString(2, bean.getApellido());
      pstm.setString(3, bean.getEmail());
      pstm.setString(4, bean.getTelefono());
      pstm.executeUpdate();
      pstm.close();
      // Recuperar ID del empleado
      String sql = "select last_insert_id() id";
      pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      rs.next();
      int id = rs.getInt("id");
      bean.setIdemp(id);
      // Confirmar Tx
      cn.commit();
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      String texto = "Error en el proceso crear empleado. ";
      texto += e.getMessage();
      throw new RuntimeException(texto);
    } finally{
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  @Override
  public void modificar(Empleado bean) {
  
  }

  @Override
  public void eliminar(int id) {
  
  }

  @Override
  public Empleado leerPorId(int id) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = SQL_SELECT + " where idemp = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setInt(1, id);
      ResultSet rs = pstm.executeQuery();
      EmpleadoMapper mapper = new EmpleadoMapper();
      if (rs.next()) {
        bean = mapper.mapRow(rs);
      }
      rs.close();
      pstm.close();
      if (bean == null) {
        throw new Exception("Id no existe.");
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
  public List<Empleado> leerTodos() {
    List<Empleado> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = SQL_SELECT;
      PreparedStatement pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      EmpleadoMapper mapper = new EmpleadoMapper();
      while (rs.next()) {
        lista.add(mapper.mapRow(rs));
      }
      rs.close();
      pstm.close();
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
    return lista;
  }

  @Override
  public List<Empleado> leer(Empleado bean) {
    List<Empleado> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = SQL_SELECT
              + " where apellido like concat(?,'%') "
              + "and nombre like concat(?,'%') ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getApellido());
      pstm.setString(2, bean.getNombre());
      ResultSet rs = pstm.executeQuery();
      EmpleadoMapper mapper = new EmpleadoMapper();
      while (rs.next()) {
        lista.add(mapper.mapRow(rs));
      }
      rs.close();
      pstm.close();
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
    return lista;
  }

  @Override
  public Empleado validar(String usuario, String clave) {
    Empleado bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      // Obtener el idemp
      String sql = "select idemp from usuario "
              + "where usuario = ? and clave = SHA(?) and estado = 1";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, usuario);
      pstm.setString(2, clave);
      ResultSet rs = pstm.executeQuery();
      int idemp = -1;
      if(rs.next()){
        idemp = rs.getInt("idemp");
      }
      rs.close();
      pstm.close();
      if(idemp == -1){
        throw new RuntimeException("Datos incorrectos.");
      }
      // Recuperar datos del empleado
      bean = leerPorId(idemp);
      bean.setUsuario(usuario);
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

}
