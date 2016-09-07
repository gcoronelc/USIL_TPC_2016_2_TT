package pe.egcc.app.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class MateModel {

  // Datos
  private int num1;
  private int num2;
  // Resultado
  private int mcd;
  private int mcm;

  public MateModel() {
  }

  public MateModel(int num1, int num2) {
    this.num1 = num1;
    this.num2 = num2;
  }

  public int getNum1() {
    return num1;
  }

  public void setNum1(int num1) {
    this.num1 = num1;
  }

  public int getNum2() {
    return num2;
  }

  public void setNum2(int num2) {
    this.num2 = num2;
  }

  public int getMcd() {
    return mcd;
  }

  public void setMcd(int mcd) {
    this.mcd = mcd;
  }

  public int getMcm() {
    return mcm;
  }

  public void setMcm(int mcm) {
    this.mcm = mcm;
  }

}
