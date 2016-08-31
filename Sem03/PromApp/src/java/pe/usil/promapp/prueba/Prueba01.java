package pe.usil.promapp.prueba;

import pe.usil.promapp.model.PromModel;
import pe.usil.promapp.service.PromService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    // Datos
    PromModel model = new PromModel(10, 10, 16);
    // Proceso
    PromService service = new PromService();
    service.procesar(model);
    // Reporte
    System.out.println("Promedio: " + model.getPromFinal());
    System.out.println("Condición: " + model.getCondicion());
  }
}
