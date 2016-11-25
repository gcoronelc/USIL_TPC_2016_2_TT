package usil.store.model;

public class Usuario {

    public Usuario() {
    }

    private int codigo;
    private String usuario;
    private String clave;
    private double estado;

    public double getEstado() {
        return estado;
    }

    public void setEstado(double estado) {
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
