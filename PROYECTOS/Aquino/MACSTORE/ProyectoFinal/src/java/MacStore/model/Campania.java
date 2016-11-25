package MacStore.model;


public class Campania {
    
    private int codigo;
    private String nombre;
    private String descripcion;
    private String fecInicio;
    private String fecFin;
    private int estado;
    private int anulado;

    public Campania() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
