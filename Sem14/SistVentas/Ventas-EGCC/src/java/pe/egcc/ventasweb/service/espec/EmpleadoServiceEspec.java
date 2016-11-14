package pe.egcc.ventasweb.service.espec;

import pe.egcc.ventasweb.model.Empleado;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public interface EmpleadoServiceEspec 
        extends CrudServiceEspec<Empleado>{
  
  Empleado validar(String usuario, String clave);
  
}
