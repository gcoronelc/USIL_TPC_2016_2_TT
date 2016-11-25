package usil.store.model;

public class Promocion {

    private int codigo;
    private String fecInicio;
    private String fecFin;
    private double precio;
    private double oferta;
    private int idprod;
    private int estado;
    private int anulado;

    public Promocion() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(String fecInicio) {
        this.fecInicio = fecInicio;
    }

    public String getFecFin() {
        return fecFin;
    }

    public void setFecFin(String fecFin) {
        this.fecFin = fecFin;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getOferta() {
        return oferta;
    }

    public void setOferta(double oferta) {
        this.oferta = oferta;
    }

    public int getIdprod() {
        return idprod;
    }

    public void setIdprod(int idprod) {
        this.idprod = idprod;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getAnulado() {
        return anulado;
    }

    public void setAnulado(int anulado) {
        this.anulado = anulado;
    }

    
}
