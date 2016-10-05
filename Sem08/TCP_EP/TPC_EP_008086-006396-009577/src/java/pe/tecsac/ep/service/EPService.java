package pe.tecsac.ep.service;

import java.util.ArrayList;
import java.util.List;
import pe.tecsac.ep.model.Item;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class EPService {
  
  public List<Item> procesar(double consumo){
    List<Item> repo = generaLista();
    determinarConsumo(repo, consumo);
    calcularImportes(repo);
    repo = depurar(repo);
    agregarDescripcion(repo);
    agregarTotal(repo);
    return repo;
  } 

  private List<Item> generaLista() {
    List<Item> repo = new ArrayList<>();
    repo.add(new Item(1, 2000, 0.016));
    repo.add(new Item(2, 300, 0.020));
    repo.add(new Item(3, 4000, 0.025));
    repo.add(new Item(4, 5000, 0.030));
    repo.add(new Item(5, 100000, 0.050));
    return repo;
  }

  private void determinarConsumo(List<Item> repo, double consumo) {
    for (Item item : repo) {
      double consumoItevalo;
      consumoItevalo=item.getMesAnt()-item.getMesAct();
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

  private void agregarDescripcion(List<Item> repo) {
    for (Item item : repo) {
      String texto;
      texto = "Tramo " + item.getTramo() +
              " consumo " + item.getConsumo() 
              + " M3";
      item.setDescripcion(texto);
    }
  }

  private void agregarTotal(List<Item> repo) {
    double consumo = 0.0;
    double total = 0.0;
    for (Item item : repo) {
      consumo += item.getConsumo();
      total += item.getImporte();
    }
    Item bean = new Item();
    bean.setDescripcion("Totales");
    bean.setConsumo(consumo);
    bean.setImporte(total);
    repo.add(bean);
  }
  
  
}
