package pe.egcc.ventasweb.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.ventasweb.model.Producto;
import pe.egcc.ventasweb.service.espec.RowMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class ProductoMapper implements RowMapper<Producto>{

  @Override
  public Producto mapRow(ResultSet rs) throws SQLException {
    Producto bean = new Producto();
    bean.setIdprod(rs.getInt("idprod"));
    bean.setIdcat(rs.getInt("idcat"));
    bean.setNombre(rs.getString("nombre"));
    bean.setPrecio(rs.getDouble("precio"));
    bean.setStock(rs.getInt("stock"));
    return bean;
  }
  
}
