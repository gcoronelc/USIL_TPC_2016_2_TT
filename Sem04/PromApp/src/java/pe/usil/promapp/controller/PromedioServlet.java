package pe.usil.promapp.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.usil.promapp.model.PromModel;
import pe.usil.promapp.service.PromService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "PromedioServlet", urlPatterns = {"/PromedioServlet"})
public class PromedioServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    // Datos
    PromModel model = new PromModel();
    model.setPromPract(Integer.parseInt(request.getParameter("pp")));
    model.setExaParcial(Integer.parseInt(request.getParameter("ep")));
    model.setExaFinal(Integer.parseInt(request.getParameter("ef")));
    // Proceso
    PromService service = new PromService();
    service.procesar(model);
    // Forward
    request.setAttribute("model", model);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("promedio.jsp");
    rd.forward(request, response);
  }

}