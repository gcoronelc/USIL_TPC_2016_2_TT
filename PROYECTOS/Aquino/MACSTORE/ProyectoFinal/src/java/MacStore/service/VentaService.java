package MacStore.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import MacStore.db.AccesoDB;
import MacStore.model.Detalle;
import MacStore.model.Venta;


public class VentaService {

    public void grabar(Venta venta) {
        int idventa = 0;
        Connection cn = null;
        try {
            // La conexión
            cn = AccesoDB.getConnection();
            // Iniciamos la Tx
            cn.setAutoCommit(false);
            // Grabra Venta
            String sql = "insert into venta(idemp,cliente,"
                    + "fecha,importe,impuesto,total) "
                    + "values(?,?,?,?,?,?)";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, venta.getIdemp());
            pstm.setString(2, venta.getCliente());
            pstm.setDate(3,
                    JdbcUtil.utilDateToSqlDate(venta.getFecha()));
            pstm.setDouble(4, venta.getImporte());
            pstm.setDouble(5, venta.getImpuesto());
            pstm.setDouble(6, venta.getTotal());
            pstm.executeUpdate();
            pstm.close();
            // Leer el idventa
            sql = "select last_insert_id() id;";
            pstm = cn.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();
            rs.next();
            idventa = rs.getInt("id");
            rs.close();
            pstm.close();
            // Grabar Detalles
            sql = "insert into detalle(idventa,idprod,cant,"
                    + "precatalogo,preventa,subtotal) "
                    + "values(?,?,?,?,?,?)";
            pstm = cn.prepareStatement(sql);
            for (Detalle i : venta.getItems()) {
                pstm.setInt(1, idventa);
                pstm.setInt(2, i.getIdprod());
                pstm.setInt(3, i.getCant());
                pstm.setDouble(4, i.getPrecatalogo());
                pstm.setDouble(5, i.getPreventa());
                pstm.setDouble(6, i.getSubtotal());
                pstm.executeUpdate();
            }
            pstm.close();
      // Grabar Pagos

            // Cancelar Tx
            cn.commit();
            venta.setIdventa(idventa);
        } catch (Exception e) {
            try {
                cn.rollback();
            } catch (Exception e1) {
            }
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
    }
    
            public List<Venta> leerVenta(Venta bean) {
        List<Venta> lista = new ArrayList();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idventa ,idemp, cliente, "
                    + "fecha, importe, impuesto,"
                    + "total from venta "
                    + "where idventa like concat(?,'%') ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdventa());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                lista.add(rowToBeanVenta(rs));
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

    private Venta rowToBeanVenta(ResultSet rs) throws SQLException {
        Venta bean = new Venta();
        bean.setIdventa(rs.getInt("idventa"));
        bean.setIdemp(rs.getInt("idemp"));
        bean.setCliente(rs.getString("cliente"));
        bean.setFecha(rs.getDate("fecha"));
        bean.setImporte(rs.getDouble("importe"));
        bean.setImpuesto(rs.getDouble("impuesto"));
        bean.setTotal(rs.getDouble("total"));
        return bean;
    }
    
     public List<Detalle> leerdetalle(Detalle bean) {
        List<Detalle> lista = new ArrayList();
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select iddetalle, idventa ,idprod , cant, "
                    + "precatalogo, preventa, "
                    + "subtotal from detalle "
                    + "where idventa =?";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, bean.getIdventa());
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                lista.add(rowToBeanDetalleVenta(rs));
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


    private Detalle rowToBeanDetalleVenta(ResultSet rs) throws SQLException {

    Detalle bean = new Detalle();
        bean.setIddetalle(rs.getInt("iddetalle"));
        bean.setIdventa(rs.getInt("idventa"));
        bean.setIdprod(rs.getInt("idprod"));
        bean.setCant(rs.getInt("cant"));
        bean.setPrecatalogo(rs.getDouble("precatalogo"));
        bean.setPreventa(rs.getDouble("preventa"));
        bean.setSubtotal(rs.getDouble("subtotal"));
        return bean;
    
    }
      public Venta leerven(int codigo) {
       Venta bean = null;
        Connection cn = null;
        try {
            cn = AccesoDB.getConnection();
            String sql = "select idventa ,idemp, cliente, "
                    + "fecha, importe, impuesto,"
                    + "total from venta "
                    + "where idventa =? ";
            PreparedStatement pstm = cn.prepareStatement(sql);
            pstm.setInt(1, codigo);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                bean = rowToBeanVenta(rs);
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

}
