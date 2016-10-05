package pe.tecsac.ep.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.tecsac.ep.model.Item;
import pe.tecsac.ep.service.EPService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "EProcesar",
        urlPatterns = {"/EProcesar"})
public class EProcesar extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      double mesAnt = Double.parseDouble(request.getParameter("mesAnt"));
      double mesAct = Double.parseDouble(request.getParameter("mesAct"));
      // Proceso
      double consumo = mesAnt - mesAct;
      EPService service = new EPService();
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

}
