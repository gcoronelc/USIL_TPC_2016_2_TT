package MacStore.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Venta {

  private int idventa;
  private int idemp;
  private String cliente;
  private Date fecha;
  private double importe;
  private double impuesto;
  private double total;
  private List<Detalle> items;

  public Venta() {
    items = new ArrayList<>();
  }

  public void addItem(Detalle item){
    // Buscar el producto
    Detalle det = null;
    for(Detalle d: this.items){
      if( d.getIdprod() == item.getIdprod()){
        det = d;
        break;
      }
    }
    if(det == null){
      items.add(item);
    } else { 
      det.setCant( det.getCant() + item.getCant());
      det.setSubtotal(det.getPreventa() * det.getCant());
      if(det.getCant() <= 0){
        this.items.remove(det);
      }
    }
    calcularTotal();
  }
  
  public List<Detalle> getItems() {
    return items;
  }

  public void setItems(List<Detalle> items) {
    this.items = items;
  }
  
  public int getIdventa() {
    return idventa;
  }

  public void setIdventa(int idventa) {
    this.idventa = idventa;
  }

  public int getIdemp() {
    return idemp;
  }

  public void setIdemp(int idemp) {
    this.idemp = idemp;
  }

  public String getCliente() {
    return cliente;
  }

  public void setCliente(String cliente) {
    this.cliente = cliente;
  }

  public Date getFecha() {
    return fecha;
  }

  public void setFecha(Date fecha) {
    this.fecha = fecha;
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

  private void calcularTotal() {
    this.total = 0.0;
    for (Detalle item : items) {
      this.total += item.getSubtotal();
    }
    this.importe = this.total / 1.18;
    this.impuesto = this.total - this.importe;
  }

  public void reset() {
    items = new ArrayList<>();
    cliente = "";
    importe = 0.0;
    impuesto = 0.0;
    total = 0.0;
  }

}
