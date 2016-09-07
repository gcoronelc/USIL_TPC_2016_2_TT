package pe.egcc.app.prueba;

import pe.egcc.app.model.MateModel;
import pe.egcc.app.service.MateService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    // Datos
    MateModel model = new MateModel(15, 20);
    // Proceso
    MateService service = new MateService();
    service.procesar(model);
    // Reporte
    System.out.println("MCD: " + model.getMcd());
    System.out.println("MCM: " + model.getMcm());
  }
}
