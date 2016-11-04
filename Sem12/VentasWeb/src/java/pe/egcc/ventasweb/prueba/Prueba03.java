package pe.egcc.ventasweb.prueba;

import pe.egcc.ventasweb.model.Empleado;
import pe.egcc.ventasweb.service.espec.EmpleadoServiceEspec;
import pe.egcc.ventasweb.service.impl.EmpleadoServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba03 {
  
  public static void main(String[] args) {
    try {
      // Dato
      String usuario = "lcarrasco";
      String clave = "felicidad";
      // Proceso
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      Empleado bean = service.validar(usuario, clave);
      System.out.println(bean.getNombre() 
              + " | " + bean.getApellido());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
