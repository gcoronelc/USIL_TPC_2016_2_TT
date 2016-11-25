package MegaStore.prueba;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class Prueba09 {

  public static void main(String[] args) {
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2013-07-20";

    try {

      Date date = formatter.parse(dateInString);
      System.out.println(date);
      System.out.println(formatter.format(date));

    } catch (ParseException e) {
      e.printStackTrace();
    }
  }
}
