package pe.egcc.ventasweb.prueba;

import java.util.List;
import pe.egcc.ventasweb.model.Detalle;
import pe.egcc.ventasweb.model.Promocion;
import pe.egcc.ventasweb.model.Venta;
import pe.egcc.ventasweb.service.espec.PromocionServiceEspec;
import pe.egcc.ventasweb.service.impl.PromocionServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba07 {

  public static void main(String[] args) {
    Venta venta = new Venta();
    venta.setCliente("Gustavo");
    venta.addItem(new Detalle(0, 0, 1, "Papas", 5, 3, 1, 5));
    venta.addItem(new Detalle(0, 0, 2, "Camote", 15, 4, 2, 30));

    System.out.println("Importe: " + venta.getImporte());
    System.out.println("Impuesto: " + venta.getImpuesto());
    System.out.println("Total: " + venta.getTotal());

    System.out.println("ITEMS");

    for (Detalle i : venta.getItems()) {
      System.out.println(i.getIdprod() + " | "
              + i.getNombre() + " | "
              + i.getCant() + " | "
              + i.getPreventa() + " | "
              + i.getSubtotal());
    }

  }
}
