package pe.egcc.proyecto1.service;

import pe.egcc.proyecto1.model.Item;

public class DineroService {
  
  public Item[] procesar(int total){
    Item[] rpta = generaArreglo();
    descomponerTotal(rpta, total);
    return rpta;
  } // Fin de Procesar

  private void descomponerTotal(Item[] rpta, int total) {
    for (int i = 0; i < rpta.length; i++) {
      Item item = rpta[i];
      int cant = total / item.getValor();
      int importe = cant * item.getValor();
      item.setCant(cant);
      item.setImporte(importe);
      total = total - importe;
    }
  } // Fin de descomponerTotal
  
  
  

  private Item[] generaArreglo() {
    Item[] arreglo = {
      new Item("Billetes de 200 Soles", 200),
      new Item("Billetes de 100 Soles", 100),
      new Item("Billetes de 50 Soles", 50),
      new Item("Billetes de 20 Soles", 20),
      new Item("Billetes de 10 Soles", 10),
      new Item("Monedas de 5 Soles", 5),
      new Item("Monedas de 2 Soles", 2),
      new Item("Monedas de 1 Soles", 1)
    };
    return arreglo;
  } // Fin de generaArreglo
  
} // Fin de DineroService
