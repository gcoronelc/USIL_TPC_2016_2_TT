package pe.egcc.ventasweb.prueba;

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
    EmpleadoServiceEspec service;
    service = new EmpleadoServiceImpl();
    for(int i = 1; i <= 4; i++){
      System.out.println("Rol: " + i 
              + "  ==>  Permiso: " 
              + service.getEstado(1002, i));
    }
  }
}
