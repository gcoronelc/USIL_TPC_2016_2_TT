package pe.egcc.ventasweb.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.ventasweb.model.Empleado;
import pe.egcc.ventasweb.service.espec.RowMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class EmpleadoMapper implements RowMapper<Empleado>{

  @Override
  public Empleado mapRow(ResultSet rs) throws SQLException {
    Empleado bean = new Empleado();
    bean.setIdemp(rs.getInt("idemp"));
    bean.setApellido(rs.getString("apellido"));
    bean.setNombre(rs.getString("nombre"));
    bean.setEmail(rs.getString("email"));
    bean.setTelefono(rs.getString("telefono"));
    return bean;
  }
  
}
