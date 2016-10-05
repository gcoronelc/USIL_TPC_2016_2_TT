package pe.tecsac.ep.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Item {

    // Datos
    private int tramo;
    private int intervalo;
    private double precio;
    public int mesAct;
    public int mesAnt;

    public int getMesAct() {
        return mesAct;
    }

    public void setMesAct(int mesAct) {
        this.mesAct = mesAct;
    }

    public int getMesAnt() {
        return mesAnt;
    }

    public void setMesAnt(int mesAnt) {
        this.mesAnt = mesAnt;
    }

    // Resultado
    private String descripcion;
    private double consumo;
    private double importe;

    public Item() {
    }

    public Item(int tramo, int intervalo, double precio) {
        this.tramo = tramo;
        this.intervalo = intervalo;
        this.precio = precio;
    }

    public int getTramo() {
        return tramo;
    }

    public void setTramo(int tramo) {
        this.tramo = tramo;
    }

    public int getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(int intervalo) {
        this.intervalo = intervalo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        String texto = tramo + " | " + intervalo +" | " + mesAct +" | "+ mesAnt
                + " | " + descripcion
                + " | " + precio + " | " + consumo
                + " | " + importe;
        return texto;
    }
    

}
