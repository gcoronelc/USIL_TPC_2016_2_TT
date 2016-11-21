package pe.egcc.ventasweb.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.ventasweb.db.AccesoDB;
import pe.egcc.ventasweb.model.Producto;
import pe.egcc.ventasweb.service.espec.ProductoServiceEspec;
import pe.egcc.ventasweb.service.mapper.ProductoMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class ProductoServiceImpl
        implements ProductoServiceEspec {

  @Override
  public void crear(Producto bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void modificar(Producto bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void eliminar(int id) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Producto leerPorId(int id) {
    Producto bean = null;
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select idprod, idcat, nombre, "
              + "precio, stock from producto "
              + "where idprod = ? ";
      PreparedStatement pstm;
      pstm = cn.prepareStatement(sql);
      pstm.setInt(1, id);
      ResultSet rs = pstm.executeQuery();
      if(rs.next()){
        ProductoMapper mapper = new ProductoMapper();
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
  public List<Producto> leerTodos() {
    List<Producto> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select idprod, idcat, nombre, "
              + "precio, stock from producto ";
      PreparedStatement pstm;
      pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      ProductoMapper mapper = new ProductoMapper();
      while(rs.next()){
        Producto bean = mapper.mapRow(rs);
        lista.add(bean);
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
  public List<Producto> leer(Producto bean) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

}
