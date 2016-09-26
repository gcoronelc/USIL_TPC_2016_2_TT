package pe.egcc.proyecto2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.proyecto2.model.Item;
import pe.egcc.proyecto2.service.NavegandoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "NavegandoController",
        urlPatterns = {"/NavegandoController"})
public class NavegandoController extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      double consumo = Double.parseDouble(
              request.getParameter("consumo"));
      // Proceso
      NavegandoService service = new NavegandoService();
      List<Item> repo = service.procesar(consumo);
      Item total = repo.get(repo.size() - 1);
      repo.remove(repo.size() - 1);
      // Reporte
      request.setAttribute("repo", repo);
      request.setAttribute("total", total);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
  }

} // Fin de NavegandoController
