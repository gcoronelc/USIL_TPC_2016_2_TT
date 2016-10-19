package pe.egcc.app.prueba;

import java.util.List;
import pe.egcc.app.model.Cliente;
import pe.egcc.app.service.ClienteService;

public class Prueba03 {

  public static void main(String[] args) {
    try {
      // Dato
      String codigo = "000073";
      // Proceso
      ClienteService service = new ClienteService();
      Cliente bean = service.leer(codigo);
      // Reporte
      System.out.println("Codigo: " + bean.getCodigo());
      System.out.println("Paterno: " + bean.getPaterno());
      System.out.println("Materno: " + bean.getMaterno());
      System.out.println("Nombre: " + bean.getNombre());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
