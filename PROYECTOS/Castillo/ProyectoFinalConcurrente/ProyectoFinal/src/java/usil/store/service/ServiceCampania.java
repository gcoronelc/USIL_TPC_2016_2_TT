package usil.store.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import usil.store.db.AccesoDB;
import usil.store.model.Campania;


public class ServiceCampania {

    //Nueva Campaña
    public void nuevo(Campania bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String insert = "insert into campania (idcamp, nombre, descripcion, "
                    + "fecInicio, fecFin, estado, anulado) "
                    + "values (?,?,?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(insert);
            pstm.setInt(1, bean.getCodigo());
            pstm.setString(2, bean.getNombre());
            pstm.setString(3, bean.getDescripcion());
            pstm.setString(4, bean.getFecInicio());
            pstm.setString(5, bean.getFecFin());
            pstm.setInt(6, bean.getEstado());
            pstm.setInt(7, bean.getAnulado());

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
            throw new RuntimeException("Error al crear campaña. " + e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }


    //Leer Campania
    public List<Campania> leerCampaña(Campania bean) {
        List<Campania> lista = new ArrayList();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idcamp, nombre, descripcion, fecInicio, fecFin,"
                    + " estado, anulado from campania "
                    + "where idcamp like concat (?, '%')";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getCodigo());
            ResultSet rs = pstm.executeQuery();
            RowMapper mapper = new RowMapper();
            while (rs.next()) {
                lista.add(mapper.CampaniaToBean(rs));
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
    public Campania leerPorId(int codigo) {
        Campania bean = null;
        Connection connection = null;
        try {
            connection = AccesoDB.getConnection();
            String sql = "select idcamp, nombre, descripcion, fecInicio, fecFin,"
                    + " estado, anulado from campania where idcamp = ?";
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            RowMapper mapper = new RowMapper();
            if (rs.next()) {
                bean = mapper.CampaniaToBean(rs);
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
    public void actualizar(Campania bean) {
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            cn.setAutoCommit(false);
            String update = "update campania set nombre = ?, descripcion = ?, "
                    + "fecInicio = ?, fecFin = ?, estado = ?, anulado = ? where idcamp = ?";
            PreparedStatement pstm = cn.prepareStatement(update);
            pstm.setString(1, bean.getNombre());
            pstm.setString(2, bean.getDescripcion());
            pstm.setString(3, bean.getFecInicio());
            pstm.setString(4, bean.getFecFin());
            pstm.setInt(5, bean.getEstado());
            pstm.setInt(6, bean.getAnulado());
            pstm.setInt(7, bean.getCodigo());

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
            throw new RuntimeException("Error al modificar campaña. " + e.getMessage());
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

            //Verificar si campaña existe
            String query = "select count(1) cont from campania where idcamp = ?";
            PreparedStatement pstm = cn.prepareStatement(query);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            cont = rs.getInt("cont");
            if (cont == 0) {
                throw new SQLException("El codigo de campaña no existe");
            }

            // Eliminar campaña
            String delete = "delete from campania where idcamp = ?";
            pstm = cn.prepareStatement(delete);
            pstm.setInt(1, codigo);

            int filas = pstm.executeUpdate();
            if (filas == 0) {
                throw new SQLException("Código de campaña no existe, "
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
            throw new RuntimeException("Error al tratar de eliminar campaña.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
}
