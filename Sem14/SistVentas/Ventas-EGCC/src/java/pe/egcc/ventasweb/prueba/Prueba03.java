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
public class Prueba03 {
  
  public static void main(String[] args) {
    try {
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      List<Empleado> lista = service.leerTodos();
      for (Empleado e : lista) {
        System.out.println(e.getNombre() + " | " + e.getApellido());
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
