package pe.egcc.proyecto1.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Item {

  // Datos
  private String denominacion;
  private int valor;
  // Resultado
  private int cant;
  private int importe;

  public Item() {
  }

  public Item(String denominacion, int valor) {
    this.denominacion = denominacion;
    this.valor = valor;
  }

  public String getDenominacion() {
    return denominacion;
  }

  public void setDenominacion(String denominacion) {
    this.denominacion = denominacion;
  }

  public int getValor() {
    return valor;
  }

  public void setValor(int valor) {
    this.valor = valor;
  }

  public int getCant() {
    return cant;
  }

  public void setCant(int cant) {
    this.cant = cant;
  }

  public int getImporte() {
    return importe;
  }

  public void setImporte(int importe) {
    this.importe = importe;
  }

}// Fin de Item
