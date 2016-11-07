package pe.egcc.ventasweb.prueba;

import java.util.List;
import pe.egcc.ventasweb.model.Empleado;
import pe.egcc.ventasweb.service.espec.EmpleadoServiceEspec;
import pe.egcc.ventasweb.service.impl.EmpleadoServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba05 {
  
  public static void main(String[] args) {
    try {
      // Dato
      String usuario = "atorres";
      String clave = "suertes";
      // Proceso
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      Empleado bean = service.validar(usuario, clave);
      System.out.println("Hola: " + bean.getNombre());
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
