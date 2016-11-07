package pe.egcc.ventasweb.service.espec;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *  Aplicando RowMapper, es una tecnica de Spring Framework.
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public interface RowMapper<T> {
  
  T mapRow(ResultSet rs ) throws SQLException;
  
}
