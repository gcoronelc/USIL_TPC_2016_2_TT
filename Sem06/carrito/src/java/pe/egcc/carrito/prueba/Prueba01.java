package pe.egcc.carrito.prueba;

import pe.egcc.carrito.model.Carrito;
import pe.egcc.carrito.model.Item;
import pe.egcc.carrito.service.CarritoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba01 {
  
  public static void main(String[] args) {
    Carrito carrito = new Carrito();
    CarritoService service = new CarritoService();
    
    service.addItem(carrito, new Item("Tamal",3.0,5));
    service.addItem(carrito, new Item("Tamal - Feo",4.0,3));
    service.addItem(carrito, new Item("Tamal - Bonito",7.0,5));
    
    mostrarCarrito(carrito);
    
  }

  private static void mostrarCarrito(Carrito carrito) {
    System.out.println("Importe: " + carrito.getImporte());
    System.out.println("Impuesto: " + carrito.getImpuesto());
    System.out.println("Total: " + carrito.getTotal());
    
    for(Item i: carrito.getLista()){
      System.out.println(i.toString());
    }
    
  }
}
