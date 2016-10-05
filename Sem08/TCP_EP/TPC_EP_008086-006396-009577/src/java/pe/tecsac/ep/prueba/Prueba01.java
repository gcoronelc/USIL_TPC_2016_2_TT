package pe.tecsac.ep.prueba;

import java.util.List;
import pe.tecsac.ep.model.Item;
import pe.tecsac.ep.service.EPService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    // Dato
    double consumoMa = 4500 ;
      
    // Procesar
    EPService service = new EPService();
    List<Item> repo = service.procesar(consumoMa);
    // Reporte
    System.out.println("Consumo: " + consumoMa + " KB");
     
   
    for (Item item : repo) {
      System.out.println(item.toString());
    }
  }
}
