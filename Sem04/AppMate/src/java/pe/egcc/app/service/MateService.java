package pe.egcc.app.service;

import pe.egcc.app.model.MateModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class MateService {

  public void procesar(MateModel model) {
    // Variables
    int a, b, mcd, mcm;
    // Datos
    a = model.getNum1();
    b = model.getNum2();
    // Calculo de MCD
    while (a != b) {
      if (a > b) {
        a -= b;
      } else {
        b -= a;
      }
    }
    mcd = a;
    // mcm
    mcm = model.getNum1() * model.getNum2() / mcd;
    // Reporte
    model.setMcd(mcd);
    model.setMcm(mcm);
  }
}
