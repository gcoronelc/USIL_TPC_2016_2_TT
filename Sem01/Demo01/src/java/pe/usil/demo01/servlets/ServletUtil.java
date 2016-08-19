package pe.usil.demo01.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public final class ServletUtil {

  private ServletUtil() {
  }

  public static void sendError(HttpServletRequest request,
          HttpServletResponse response) throws IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>ERROR</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>ERROR</h1>");
    out.println("<p>Se ha producido un error en el proceso</p>");
    out.println("<p>" + request.getAttribute("error") + "</p>");
    out.println("<a href='" + request.getAttribute("page") + "'>Volver</a>");
    out.println("</body>");
    out.println("</html>");
  }

}
