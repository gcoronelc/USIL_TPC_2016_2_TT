package pe.usil.calcapp.service;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class MateService {
  
  public int procesar(String opera, int num1, int num2){
    int rpta = 0;
    switch (opera) {
      case "S":
        rpta = num1 + num2;
        break;
      case "R":
        rpta = num1 - num2;
        break;
    }
    return rpta;
  }
}
