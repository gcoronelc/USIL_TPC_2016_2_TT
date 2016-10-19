package pe.egcc.app.prueba;

import java.util.List;
import pe.egcc.app.model.Cliente;
import pe.egcc.app.service.ClienteService;

public class Prueba02 {

  public static void main(String[] args) {
    try {
      // Dato
      Cliente bean = new Cliente();
      bean.setPaterno("C");
      bean.setMaterno("");
      bean.setNombre("");
      // Proceso
      ClienteService service = new ClienteService();
      List<Cliente> lista = service.leer(bean);
      // Reporte
      for (Cliente c : lista) {
        System.out.println(c.getCodigo() + " | " +
                c.getPaterno() + " | " + c.getMaterno() +
                " | " + c.getNombre());
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}
