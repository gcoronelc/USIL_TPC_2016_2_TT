package pe.usil.calcapp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.usil.calcapp.service.MateService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "CalculaServlet", urlPatterns = {"/CalculaServlet"})
public class CalculaServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    // Variables
    String opera;
    int n1, n2, rpta = 0;

    // Datos
    opera = request.getParameter("opera").toString();
    n1 = Integer.parseInt(request.getParameter("num1"));
    n2 = Integer.parseInt(request.getParameter("num2"));

    // Proceso
    MateService service = new MateService();
    rpta = service.procesar(opera, n1, n2);

    // Preparar datos para la JSP
    request.setAttribute("opera", opera);
    request.setAttribute("n1", n1);
    request.setAttribute("n2", n2);
    request.setAttribute("rpta", rpta);

    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("calcula.jsp");
    rd.forward(request, response);
  }

}
