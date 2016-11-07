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
public class Prueba02 {
  
  public static void main(String[] args) {
    try {
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      Empleado bean = service.leerPorId(1004);
      System.out.println("Hola " + bean.getNombre());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
