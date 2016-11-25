package MegaStore.prueba;

import java.util.List;
import MegaStore.model.Promocion;
import MegaStore.service.espec.PromocionServiceEspec;
import MegaStore.service.impl.PromocionServiceImpl;

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
      int idprod = 4;
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
