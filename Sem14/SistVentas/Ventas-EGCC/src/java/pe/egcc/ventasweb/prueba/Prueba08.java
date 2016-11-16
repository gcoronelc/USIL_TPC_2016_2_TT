package pe.egcc.ventasweb.prueba;

import java.util.Calendar;
import pe.egcc.ventasweb.model.Detalle;
import pe.egcc.ventasweb.model.Venta;
import pe.egcc.ventasweb.service.espec.VentaServiceEspec;
import pe.egcc.ventasweb.service.impl.VentaServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba08 {

  public static void main(String[] args) {
    
    // Creando una venta
    Venta venta = new Venta();
    venta.setCliente("Gustavo");
    venta.setIdemp(1002);
    venta.setFecha(Calendar.getInstance().getTime());
    venta.addItem(new Detalle(0, 0, 1, "Papas", 5, 3, 1, 5));
    venta.addItem(new Detalle(0, 0, 2, "Camote", 15, 4, 2, 30));
    venta.addItem(new Detalle(0, 0, 3, "Zapatos", 15, 4, 2, 30));

    try {
      // Grabar venta
      VentaServiceEspec service = new VentaServiceImpl();
      service.grabar(venta);
      System.out.println("idventa = " + venta.getIdventa());
    } catch (Exception e) {
      System.err.println("Error: " + e.getMessage());
    }

  }
}
