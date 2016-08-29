package usil.edu.pe;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ocule
 */
@WebServlet(name = "CALCULARServlet", urlPatterns = {"/CALCULARServlet"})
public class CALCULARServlet extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {

    //variables
    String opera;
    int nu1, nu2, rpta = 0;
    //datos
    nu1 = Integer.parseInt(request.getParameter("num1"));
    nu2 = Integer.parseInt(request.getParameter("num2"));
    opera = request.getParameter("operacion").toString();

    //proceso
    switch (opera) {
      case "S":
        opera = "SUMA";
        rpta = nu1 + nu2;
        break;
      case "R":
        opera = "RESTA";
        rpta = nu1 - nu2;
        break;
      case "M":
        opera = "MULTIPLICACION";
        rpta = nu1 * nu2;
        break;
      case "D":
        opera = "DIVICION";
        rpta = nu1 / nu2;
        break;
    }
    request.setAttribute("operacion", opera);
    request.setAttribute("num1", nu1);
    request.setAttribute("num2", nu2);
    request.setAttribute("rpta", rpta);

    //FORWARD
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("calcular.jsp");
    rd.forward(request, response);
  }

}
