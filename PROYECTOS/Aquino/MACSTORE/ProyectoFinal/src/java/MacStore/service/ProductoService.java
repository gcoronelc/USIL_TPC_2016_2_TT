package MacStore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MacStore.db.AccesoDB;
import MacStore.model.Producto;

public class ProductoService {

    //Nuevo Producto
    public void nuevo(Producto bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String insert = "insert into producto (idprod, idcat, nombre, descripcion, precio, stock, estado) "
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(insert);
            pstm.setInt(1, bean.getCodigo());
            pstm.setInt(2, bean.getCategoria());
            pstm.setString(3, bean.getNombre());
            pstm.setString(4, bean.getDescripcion());
            pstm.setDouble(5, bean.getPrecio());
            pstm.setInt(6, bean.getStock());
            pstm.setInt(7, bean.getEstado());

            pstm.executeUpdate();
            pstm.close();

            String sql = "select LAST_INSERT_ID() id";
            pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            int id = rs.getInt("id");
            bean.setCodigo(id);

            rs.close();
            pstm.close();
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error al crear producto. " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    //Leer Producto
    public List<Producto> leerProducto(Producto bean) {
        List<Producto> lista = new ArrayList();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idprod, idcat, nombre, "
                    + "descripcion, precio, stock, estado from producto "
                    + "where idprod like concat (?, '%')";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getCodigo());
            ResultSet rs = pstm.executeQuery();
            RowMapper mapper = new RowMapper();
            while (rs.next()) {
                lista.add(mapper.ProductoToBean(rs));
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

    //Leer por ID
    public Producto leerPorId(int codigo) {
        Producto bean = null;
        Connection connection = null;
        try {
            connection = AccesoDB.getConnection();
            String sql = "select idprod ,idcat , nombre, "
                    + " descripcion, precio, stock, estado from producto "
                    + "where idprod = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            RowMapper mapper = new RowMapper();
            if (rs.next()) {
                bean = mapper.ProductoToBean(rs);
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
                connection.close();
            } catch (Exception e) {
            }
        }
        return bean;
    }

    //Editar
    public void actualizar(Producto bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String update = "update producto set nombre = ?, descripcion = ?, precio = ?, stock = ?, estado = ? where idprod = ?";
            PreparedStatement pstm = cn.prepareStatement(update);
            pstm.setString(1, bean.getNombre());
            pstm.setString(2, bean.getDescripcion());
            pstm.setDouble(3, bean.getPrecio());
            pstm.setInt(4, bean.getStock());
            pstm.setInt(5, bean.getEstado());
            pstm.setInt(6, bean.getCodigo());

            int filas = pstm.executeUpdate();
            pstm.close();
            if (filas == 0) {
                throw new Exception("Error. Datos incorrectos. ");
            }
            cn.commit();
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException("Error al modificar producto. " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    //Eliminar
    public void eliminar(int codigo) {
        Connection cn = null;
        int cont;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);

            //Verificar si producto existe
            String query = "select count(1) cont from producto where idprod = ?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            cont = rs.getInt("cont");
            if (cont == 0) {
                throw new SQLException("El codigo de producto no existe");
            }

            // Eliminar el producto
            String delete = "delete from producto where idprod = ?";
            pstm = cn.prepareStatement(delete);
            pstm.setInt(1, codigo);

            int filas = pstm.executeUpdate();
            if (filas == 0) {
                throw new SQLException("Código de producto no existe, "
                        + "posiblemente fue eliminado por otro usuario.");
            }
            cn.commit();
            pstm.close();

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
            throw new RuntimeException("Error al tratar de eliminar producto.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
    
      public List<Producto> leerTodos() {
    List<Producto> lista = new ArrayList<>();
    Connection cn = null;
    try {
      cn = AccesoDB.getConnection();
      String sql = "select idprod, idcat, nombre,descripcion, "
              + "precio, stock, estado from producto ";
      PreparedStatement pstm;
      pstm = cn.prepareStatement(sql);
      ResultSet rs = pstm.executeQuery();
      RowMapper mapper = new RowMapper();
      while(rs.next()){
        Producto bean = mapper.ProductoToBean(rs);
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
}
