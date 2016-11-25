package MacStore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MacStore.db.AccesoDB;
import MacStore.model.Promocion;

public class PromocionService {
    //Nueva Promocion

    public void nuevo(Promocion bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String insert = "insert into promocion (idprom, idprod, fecInicio,"
                    + " fecFin, precio, oferta, estado, anulado) "
                    + "values (?,?,?,?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(insert);
            pstm.setInt(1, bean.getCodigo());
            pstm.setInt(2, bean.getIdprod());
            pstm.setString(3, bean.getFecInicio());
            pstm.setString(4, bean.getFecFin());
            pstm.setDouble(5, bean.getPrecio());
            pstm.setDouble(6, bean.getOferta());
            pstm.setInt(7, bean.getEstado());
            pstm.setInt(8, bean.getAnulado());

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
            throw new RuntimeException("Error al crear promocion. " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }

    //Leer Promocion
    public List<Promocion> leerPromocion(Promocion bean) {
        List<Promocion> lista = new ArrayList();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idprom, idprod, fecInicio, fecFin, precio, oferta, "
                    + "estado, anulado from promocion "
                    + "where idprom like concat (?, '%')";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getCodigo());
            ResultSet rs = pstm.executeQuery();
            RowMapper mapper = new RowMapper();
            while (rs.next()) {
                lista.add(mapper.PromocionToBean(rs));
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
    public Promocion leerPorId(int codigo) {
        Promocion bean = null;
        Connection connection = null;
        try {
            connection = AccesoDB.getConnection();
            String sql = "select idprom, idprod, fecInicio, fecFin, precio, oferta, "
                    + "estado, anulado from promocion where idprom = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            RowMapper mapper = new RowMapper();
            if (rs.next()) {
                bean = mapper.PromocionToBean(rs);
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
    public void actualizar(Promocion bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String update = "update promocion set idprod = ?, fecInicio = ?, fecFin = ?, "
                    + "precio = ?, oferta = ?, estado = ?, anulado = ? where idprom = ?";
            PreparedStatement pstm = cn.prepareStatement(update);
            pstm.setInt(1, bean.getIdprod());
            pstm.setString(2, bean.getFecInicio());
            pstm.setString(3, bean.getFecFin());
            pstm.setDouble(4, bean.getPrecio());
            pstm.setDouble(5, bean.getOferta());
            pstm.setInt(6, bean.getEstado());
            pstm.setInt(7, bean.getAnulado());
            pstm.setInt(8, bean.getCodigo());

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
            throw new RuntimeException("Error al modificar promocion. " + e.getMessage());
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

            //Verificar si promocion existe
            String query = "select count(1) cont from promocion where idprom = ?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            cont = rs.getInt("cont");
            if (cont == 0) {
                throw new SQLException("El codigo de promocion no existe");
            }

            // Eliminar promocion
            String delete = "delete from promocion where idprom = ?";
            pstm = cn.prepareStatement(delete);
            pstm.setInt(1, codigo);

            int filas = pstm.executeUpdate();
            if (filas == 0) {
                throw new SQLException("Código de promocion no existe, "
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
            throw new RuntimeException("Error al tratar de eliminar promocion.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
}
