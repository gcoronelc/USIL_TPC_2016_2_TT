package pe.egcc.app.prueba;

import pe.egcc.app.service.ClienteService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba04 {

  public static void main(String[] args) {
    try {
      // Dato
      String codigo = "00001";
      // Proceso
      ClienteService service = new ClienteService();
      service.eliminar(codigo);
      System.out.println("Cliente eliminado correctamente.");
      // Reporte
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
