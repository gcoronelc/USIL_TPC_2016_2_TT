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
    item.setImporte(redondear(item.getImporte()));
    carrito.getLista().add(item);
    double total = redondear(calcularTotal(carrito));
    double importe = redondear(total / 1.18);
    double impuesto = redondear(total - importe);
    // Actualizar el carrito
    carrito.setImporte(importe);
    carrito.setImpuesto(impuesto);
    carrito.setTotal(total);
  }

  private double calcularTotal(Carrito carrito) {
    double total = 0.0;
    for(Item i: carrito.getLista()){
      total += i.getImporte();
    }
    return total;
  }

  private double redondear(double valor) {
    valor *= 100.0;
    valor = Math.round(valor)/ 100.0;
    return valor;
  }

    
  
}
