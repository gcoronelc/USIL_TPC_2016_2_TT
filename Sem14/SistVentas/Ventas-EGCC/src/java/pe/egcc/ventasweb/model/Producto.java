package pe.egcc.ventasweb.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Producto {

  private int idprod;
  private int idcat;
  private String nombre;
  private double precio;
  private int stock;

  public Producto() {
  }

  public int getIdprod() {
    return idprod;
  }

  public void setIdprod(int idprod) {
    this.idprod = idprod;
  }

  public int getIdcat() {
    return idcat;
  }

  public void setIdcat(int idcat) {
    this.idcat = idcat;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(double precio) {
    this.precio = precio;
  }

  public int getStock() {
    return stock;
  }

  public void setStock(int stock) {
    this.stock = stock;
  }

}
