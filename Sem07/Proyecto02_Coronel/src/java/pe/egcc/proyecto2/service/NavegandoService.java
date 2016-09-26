package pe.egcc.proyecto2.service;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import pe.egcc.proyecto2.model.Item;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class NavegandoService {
  
  public List<Item> procesar(double consumo){
    List<Item> repo = generaLista();
    determinarConsumo(repo, consumo);
    calcularImportes(repo);
    repo = depurar(repo);
    return repo;
  } 

  private List<Item> generaLista() {
    List<Item> repo = new ArrayList<>();
    repo.add(new Item(1, 4, 12.0));
    repo.add(new Item(2, 4, 10.0));
    repo.add(new Item(3, 4, 8.0));
    repo.add(new Item(4, 100000, 6.0));
    return repo;
  }

  private void determinarConsumo(List<Item> repo, double consumo) {
    for (Item item : repo) {
      double consumoItevalo;
      if( consumo >= item.getIntervalo()){
        consumoItevalo = item.getIntervalo();
      } else {
        consumoItevalo = consumo;
      }
      item.setConsumo(consumoItevalo);
      consumo -= consumoItevalo;
    }
  }

  private void calcularImportes(List<Item> repo) {
    for (Item item : repo) {
      item.setImporte(item.getConsumo() * item.getPrecio());
    }
  }

  private List<Item> depurar(List<Item> repo) {
    List<Item> repo2 = new ArrayList<>();
    for (Item item : repo) {
      if(item.getImporte()>0.0){
        repo2.add(item);
      }
    }
    return repo2;
  }
  
  
}
