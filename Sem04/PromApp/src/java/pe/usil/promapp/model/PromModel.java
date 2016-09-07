package pe.usil.promapp.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class PromModel {
  
  // Datos
  private int promPract;
  private int exaParcial;
  private int exaFinal;
  // Resultado
  private int promFinal;
  private String condicion;

  /**
   * Constructor por defecto
   */
  public PromModel() {
  }

  /**
   * Constructor adicional.
   * 
   * @param promPract
   * @param exaParcial
   * @param exaFinal 
   */
  public PromModel(int promPract, int exaParcial, int exaFinal) {
    this.promPract = promPract;
    this.exaParcial = exaParcial;
    this.exaFinal = exaFinal;
  }

  /**
   * @return the promPract
   */
  public int getPromPract() {
    return promPract;
  }

  /**
   * @param promPract the promPract to set
   */
  public void setPromPract(int promPract) {
    this.promPract = promPract;
  }

  /**
   * @return the exaParcial
   */
  public int getExaParcial() {
    return exaParcial;
  }

  /**
   * @param exaParcial the exaParcial to set
   */
  public void setExaParcial(int exaParcial) {
    this.exaParcial = exaParcial;
  }

  /**
   * @return the exaFinal
   */
  public int getExaFinal() {
    return exaFinal;
  }

  /**
   * @param exaFinal the exaFinal to set
   */
  public void setExaFinal(int exaFinal) {
    this.exaFinal = exaFinal;
  }

  /**
   * @return the promFinal
   */
  public int getPromFinal() {
    return promFinal;
  }

  /**
   * @param promFinal the promFinal to set
   */
  public void setPromFinal(int promFinal) {
    this.promFinal = promFinal;
  }

  /**
   * @return the condicion
   */
  public String getCondicion() {
    return condicion;
  }

  /**
   * @param condicion the condicion to set
   */
  public void setCondicion(String condicion) {
    this.condicion = condicion;
  }


}
