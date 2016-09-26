package pe.egcc.proyecto1.prueba;

import pe.egcc.proyecto1.model.Item;
import pe.egcc.proyecto1.service.DineroService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    // Datos
    int total = 848;
    // Proceso
    DineroService service = new DineroService();
    Item[] arreglo = service.procesar(total);
    // Reporte
    System.out.println("Total: " + total);
    for (Item i : arreglo) {
      String texto = i.getDenominacion() +
              " | " + i.getCant() + 
              " | " + i.getImporte();
      System.out.println(texto);
    }
  }
}
