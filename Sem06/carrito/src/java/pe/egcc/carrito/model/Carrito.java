package pe.egcc.carrito.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
public class Carrito {

  private double importe;
  private double impuesto;
  private double total;
  private List<Item> lista;

  public Carrito() {
    lista = new ArrayList<>();
  }

  public double getImporte() {
    return importe;
  }

  public void setImporte(double importe) {
    this.importe = importe;
  }

  public double getImpuesto() {
    return impuesto;
  }

  public void setImpuesto(double impuesto) {
    this.impuesto = impuesto;
  }

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }

  public List<Item> getLista() {
    return lista;
  }

  public void setLista(List<Item> lista) {
    this.lista = lista;
  }

}
