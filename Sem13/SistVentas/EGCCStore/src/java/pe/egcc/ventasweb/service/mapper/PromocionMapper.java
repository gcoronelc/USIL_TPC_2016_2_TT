package pe.egcc.ventasweb.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.ventasweb.model.Promocion;
import pe.egcc.ventasweb.service.espec.RowMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class PromocionMapper implements RowMapper<Promocion>{

  @Override
  public Promocion mapRow(ResultSet rs) throws SQLException {
    Promocion bean = new Promocion();
    bean.setIdprom(rs.getInt("idprom"));
    bean.setFecinicio(rs.getDate("fecinicio"));
    bean.setFecfin(rs.getDate("fecfin"));
    bean.setIdprod(rs.getInt("idprod"));
    bean.setNombre(rs.getString("nombre"));
    bean.setPactual(rs.getDouble("pactual"));
    bean.setPrecio(rs.getDouble("precio"));
    bean.setOferta(rs.getDouble("oferta"));
    bean.setEstado(rs.getInt("estado"));
    bean.setAnulado(rs.getInt("anulado"));
    return bean;
  }
  
}
