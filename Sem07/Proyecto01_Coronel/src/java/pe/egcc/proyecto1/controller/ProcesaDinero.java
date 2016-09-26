package pe.egcc.proyecto1.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.proyecto1.model.Item;
import pe.egcc.proyecto1.service.DineroService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "ProcesaDinero", urlPatterns = {"/ProcesaDinero"})
public class ProcesaDinero extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Dato
      int valor = Integer.parseInt(request.getParameter("valor"));
      // Proceso
      DineroService service = new DineroService();
      Item[] arreglo = service.procesar(valor);
      // Reporte
      request.setAttribute("total", valor);
      request.setAttribute("arreglo", arreglo);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  } // Fin de doPost

} // Fin de ProcesaDinero
