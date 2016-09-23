package pe.egcc.carrito.service;

import pe.egcc.carrito.model.Carrito;
import pe.egcc.carrito.model.Item;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class CarritoService {
  
  public void addItem(Carrito carrito, Item item){
    // Proceso
    item.setImporte(item.getPrecio() * item.getCant());
    carrito.getLista().add(item);
    double total = calcularTotal(carrito);
    double importe = total / 1.18;
    double impuesto = total - importe;
    // Actualizar el carrito
    carrito.setImporte(importe);
    carrito.setImpuesto(impuesto);
    carrito.setTotal(total);
  }

  private double calcularTotal(Carrito carrito) {
    double total = 0.0;
  
    return total;
  }
  
  
}
