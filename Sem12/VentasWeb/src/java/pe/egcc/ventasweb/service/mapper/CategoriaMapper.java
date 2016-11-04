package pe.egcc.ventasweb.service.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import pe.egcc.ventasweb.model.Categoria;
import pe.egcc.ventasweb.service.espec.RowMapper;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class CategoriaMapper 
  implements RowMapper<Categoria>{

  @Override
  public Categoria mapRow(ResultSet rs) throws SQLException {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  
}
