package app.usil.promedio.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Notas {

  // Datos
  private int pract1;
  private int pract2;
  private int pract3;
  private int trab1;
  private int trab2;
  private int trab3;
  private int exaParcial;
  private int exaFinal;
  // Resultado
  private int promPract;
  private int promTrab;
  private int promFinal;
  private String condicion;

  public Notas() {
  }

  public int getPract1() {
    return pract1;
  }

  public void setPract1(int pract1) {
    this.pract1 = pract1;
  }

  public int getPract2() {
    return pract2;
  }

  public void setPract2(int pract2) {
    this.pract2 = pract2;
  }

  public int getPract3() {
    return pract3;
  }

  public void setPract3(int pract3) {
    this.pract3 = pract3;
  }

  public int getTrab1() {
    return trab1;
  }

  public void setTrab1(int trab1) {
    this.trab1 = trab1;
  }

  public int getTrab2() {
    return trab2;
  }

  public void setTrab2(int trab2) {
    this.trab2 = trab2;
  }

  public int getTrab3() {
    return trab3;
  }

  public void setTrab3(int trab3) {
    this.trab3 = trab3;
  }

  public int getExaParcial() {
    return exaParcial;
  }

  public void setExaParcial(int exaParcial) {
    this.exaParcial = exaParcial;
  }

  public int getExaFinal() {
    return exaFinal;
  }

  public void setExaFinal(int exaFinal) {
    this.exaFinal = exaFinal;
  }

  public int getPromPract() {
    return promPract;
  }

  public void setPromPract(int promPract) {
    this.promPract = promPract;
  }

  public int getPromTrab() {
    return promTrab;
  }

  public void setPromTrab(int promTrab) {
    this.promTrab = promTrab;
  }

  public int getPromFinal() {
    return promFinal;
  }

  public void setPromFinal(int promFinal) {
    this.promFinal = promFinal;
  }

  public String getCondicion() {
    return condicion;
  }

  public void setCondicion(String condicion) {
    this.condicion = condicion;
  }

}
