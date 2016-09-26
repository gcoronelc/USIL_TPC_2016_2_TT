package pe.egcc.proyecto2.prueba;

import java.util.List;
import pe.egcc.proyecto2.model.Item;
import pe.egcc.proyecto2.service.NavegandoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    // Dato
    double consumo = 10.50;
    // Procesar
    NavegandoService service = new NavegandoService();
    List<Item> repo = service.procesar(consumo);
    // Reporte
    System.out.println("Consumo: " + consumo + " GB");
    for (Item item : repo) {
      System.out.println(item.toString());
    }
  }
}
