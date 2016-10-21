package pe.egcc.app.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.app.db.AccesoDB;
import pe.egcc.app.model.Cliente;

public class ClienteService {

  public List<Cliente> leer(Cliente bean) {
    List<Cliente> lista = new ArrayList();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cliecodigo,vch_cliepaterno,"
              + "vch_cliematerno,vch_clienombre,"
              + "chr_cliedni,vch_clieciudad,"
              + "vch_cliedireccion,vch_clietelefono,"
              + "vch_clieemail from cliente "
              + "where vch_cliepaterno like concat(?,'%') "
              + "and vch_cliematerno like concat(?,'%') "
              + "and vch_clienombre like concat(?,'%') ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getPaterno());
      pstm.setString(2, bean.getMaterno());
      pstm.setString(3, bean.getNombre());
      ResultSet rs = pstm.executeQuery();
      while (rs.next()) {
        lista.add(rowToBean(rs));
      }
      rs.close();
      pstm.close();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return lista;
  }

  private Cliente rowToBean(ResultSet rs)
          throws SQLException {
    Cliente bean = new Cliente();
    bean.setCodigo(rs.getString("chr_cliecodigo"));
    bean.setPaterno(rs.getString("vch_cliepaterno"));
    bean.setMaterno(rs.getString("vch_cliematerno"));
    bean.setNombre(rs.getString("vch_clienombre"));
    bean.setDni(rs.getString("chr_cliedni"));
    bean.setCiudad(rs.getString("vch_clieciudad"));
    bean.setDireccion(rs.getString("vch_cliedireccion"));
    bean.setTelefono(rs.getString("vch_clietelefono"));
    bean.setEmail(rs.getString("vch_clieemail"));
    return bean;
  }

  public Cliente leer(String codigo) {
    Cliente bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select chr_cliecodigo,vch_cliepaterno,"
              + "vch_cliematerno,vch_clienombre,"
              + "chr_cliedni,vch_clieciudad,"
              + "vch_cliedireccion,vch_clietelefono,"
              + "vch_clieemail from cliente "
              + "where chr_cliecodigo = ? ";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);
      ResultSet rs = pstm.executeQuery();
      if (rs.next()) {
        bean = rowToBean(rs);
      }
      rs.close();
      pstm.close();
      if (bean == null) {
        throw new Exception("Codigo " + codigo + " no existe.");
      }
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
    return bean;
  }

  public void modificar(Cliente bean) {
    Connection cn = null;
    try {
      // Obtener objeto Connection
      cn = AccesoDB.getConnection();
      // Inicio de Tx
      cn.setAutoCommit(false);
      // Proceso
      String sql = "update cliente set "
              + "vch_cliepaterno = ?, "
              + "vch_cliematerno = ?, "
              + "vch_clienombre = ?, "
              + "chr_cliedni = ?, "
              + "vch_clieciudad = ?, "
              + "vch_cliedireccion = ?, "
              + "vch_clietelefono = ?, "
              + "vch_clieemail = ? "
              + "where chr_cliecodigo = ?";
      PreparedStatement pstm = cn.prepareStatement(sql);
      pstm.setString(1, bean.getPaterno());
      pstm.setString(2, bean.getMaterno());
      pstm.setString(3, bean.getNombre());
      pstm.setString(4, bean.getDni());
      pstm.setString(5, bean.getCiudad());
      pstm.setString(6, bean.getDireccion());
      pstm.setString(7, bean.getTelefono());
      pstm.setString(8, bean.getEmail());
      pstm.setString(9, bean.getCodigo());
      int filas = pstm.executeUpdate();
      if (filas == 0) {
        throw new Exception("Datos incorrectos.");
      }
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
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  public void nuevo(Cliente bean) {
    Connection cn = null;
    try {
      // Obtener objeto Connection
      cn = AccesoDB.getConnection();
      // Inicio de Tx
      cn.setAutoCommit(false);
      // Paso 1: Actualizar contador
      String sql = "update contador "
              + "set int_contitem = int_contitem + 1 "
              + "where vch_conttabla = 'Cliente'";
      PreparedStatement pstm = cn.prepareStatement(sql);
      int filas = pstm.executeUpdate();
      pstm.close();
      if (filas == 0) {
        throw new RuntimeException("contador no existe.");
      }
      // Paso 2: Recuperar contador
      sql = "select int_contitem,int_contlongitud "
              + "from contador "
              + "where vch_conttabla='Cliente'";
      pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      if (!rs.next()) {
        throw new RuntimeException("No se puede recuperar el contador.");
      }
      int cont = rs.getInt("int_contitem");
      int longitud = rs.getInt("int_contlongitud");
      // Paso 3: Generar código
      String codigo = "00000000" + cont;
      codigo = codigo.substring(codigo.length() - longitud, codigo.length());
      // Paso 4: insert
      sql = "insert into cliente(chr_cliecodigo,"
              + "vch_cliepaterno,vch_cliematerno,"
              + "vch_clienombre,chr_cliedni,"
              + "vch_clieciudad,vch_cliedireccion,"
              + "vch_clietelefono,vch_clieemail) "
              + "values(?,?,?,?,?,?,?,?,?)";
      pstm = cn.prepareStatement(sql);
      pstm.setString(1, codigo);
      pstm.setString(2, bean.getPaterno());
      pstm.setString(3, bean.getMaterno());
      pstm.setString(4, bean.getNombre());
      pstm.setString(5, bean.getDni());
      pstm.setString(6, bean.getCiudad());
      pstm.setString(7, bean.getDireccion());
      pstm.setString(8, bean.getTelefono());
      pstm.setString(9, bean.getEmail());
      pstm.executeUpdate();
      bean.setCodigo(codigo); // Retorn el codigo
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
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }

  public void eliminar(String codigo) {
    Connection cn = null;
    String query;
    PreparedStatement pstm;
    ResultSet rs;
    int cont;
    try {
      cn = AccesoDB.getConnection();
      cn.setAutoCommit(false);
      // Verificar si cliente existe
      query = "select count(1) cont from cliente where chr_cliecodigo = ?";
      pstm = cn.prepareStatement(query);
      pstm.setString(1, codigo);
      rs = pstm.executeQuery();
      rs.next();
      cont = rs.getInt("cont");
      rs.close();
      pstm.close();
      if (cont == 0) {
        throw new SQLException("El codigo de cliente no existe");
      }
      // Verificar si el cliente tiene cuentas
      query = "select count(*) cont from cuenta where chr_cliecodigo = ?";
      pstm = cn.prepareStatement(query);
      pstm.setString(1, codigo);
      rs = pstm.executeQuery();
      rs.next();
      cont = rs.getInt("cont");
      rs.close();
      pstm.close();
      if (cont > 0) {
        throw new SQLException("El cliente tiene cuentas, no se puede eliminar.");
      }
      // Eliminar el cliente
      query = "delete from cliente where chr_cliecodigo=?";
      pstm = cn.prepareStatement(query);
      pstm.setString(1, codigo);
      int filas = pstm.executeUpdate();
      pstm.close();
      if (filas == 0) {
        throw new SQLException("Código de cliente no existe, "
                + "posiblemente fue eliminado por otro usuario.");
      }
      // Confirmar Tx
      cn.commit();
    } catch (SQLException e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException(e.getMessage());
    } catch (Exception e) {
      try {
        cn.rollback();
      } catch (Exception e1) {
      }
      throw new RuntimeException("Error al tratar de eliminar el cliente.");
    } finally {
      try {
        cn.close();
      } catch (Exception e) {
      }
    }
  }
}
