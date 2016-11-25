package MacStore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MacStore.db.AccesoDB;
import MacStore.model.Categoria;



public class CategoriaService {
    //Nueva Categoria
    public void nuevo(Categoria bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String insert = "insert into categoria (idcat, nombre, descripcion) "
                    + "values (?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(insert);
            pstm.setInt(1, bean.getCodigo());
            pstm.setString(2, bean.getNombre());
            pstm.setString(3, bean.getDescripcion());
            
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
            throw new RuntimeException("Error al crear categoria. " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    //Leer Categoria
    public List<Categoria> leerCategoria(Categoria bean) {
        List<Categoria> lista = new ArrayList();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idcat, nombre, "
                    + "descripcion from producto "
                    + "where idcat like concat (?, '%')";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getCodigo());
            ResultSet rs = pstm.executeQuery();
            RowMapper mapper = new RowMapper();
            while (rs.next()) {
                lista.add(mapper.CategoriaToBean(rs));
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
    public Categoria leerPorId(int codigo) {
        Categoria bean = null;
        Connection connection = null;
        try {
            connection = AccesoDB.getConnection();
            String sql = "select idcat , nombre, "
                    + " descripcion from categoria "
                    + "where idcat = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            RowMapper mapper = new RowMapper();
            if (rs.next()) {
                bean = mapper.CategoriaToBean(rs);
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
    public void actualizar(Categoria bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String update = "update categoria set nombre = ?, descripcion = ? where idcat = ?";
            PreparedStatement pstm = cn.prepareStatement(update);
            pstm.setString(1, bean.getNombre());
            pstm.setString(2, bean.getDescripcion());
            pstm.setInt(3, bean.getCodigo());

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
            throw new RuntimeException("Error al modificar categoria. " + e.getMessage());
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

            //Verificar si categoria existe
            String query = "select count(1) cont from categoria where idcat = ?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            cont = rs.getInt("cont");
            if (cont == 0) {
                throw new SQLException("El codigo de categoria no existe");
            }

            // Eliminar categoria
            String delete = "delete from categoria where idcat = ?";
            pstm = cn.prepareStatement(delete);
            pstm.setInt(1, codigo);

            int filas = pstm.executeUpdate();
            if (filas == 0) {
                throw new SQLException("Código de categoria no existe, "
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
            throw new RuntimeException("Error al tratar de eliminar categoria.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
}
