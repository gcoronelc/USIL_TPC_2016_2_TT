package pe.egcc.ventasweb.prueba;

import java.util.List;
import pe.egcc.ventasweb.model.Promocion;
import pe.egcc.ventasweb.service.espec.PromocionServiceEspec;
import pe.egcc.ventasweb.service.impl.PromocionServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba06 {
  
  public static void main(String[] args) {
    try {
      // Dato
      int idprod = 1;
      // Proceso
      PromocionServiceEspec service;
      service = new PromocionServiceImpl();
      List<Promocion> lista = service.getPromociones(idprod);
      for (Promocion p : lista) {
        System.out.println(p.getIdprod() + " - " + p.getPactual() + " - " +  p.getPrecio() + " - " + p.getOferta());
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
    }
  }
}
