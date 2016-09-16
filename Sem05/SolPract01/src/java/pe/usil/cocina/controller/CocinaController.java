package pe.usil.cocina.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.usil.cocina.model.CocinaModel;
import pe.usil.cocina.service.CocinaService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
@WebServlet(urlPatterns = {"/CocinaFormulario","/CocinaProcesar"})
public class CocinaController extends HttpServlet{

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/CocinaFormulario")){
      cocinaFormulario(request,response);
    } else if(path.equals("/CocinaProcesar")){
      cocinaProcesar(request,response);
    }
  }

  private void cocinaFormulario(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
  
    CocinaService service = new CocinaService();
    request.setAttribute("cursos", service.getCursos());
    request.setAttribute("categorias", service.getCategorias());
  
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("formulario.jsp");
    rd.forward(request, response);
    
  }

  private void cocinaProcesar(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    CocinaModel model = new CocinaModel();
    try {
      // Datos
      model.setCurso(request.getParameter("curso"));
      model.setCategoria(request.getParameter("categoria"));
      model.setVacantes(Integer.parseInt(request.getParameter("vacantes")));
      // Proceso
      CocinaService service = new CocinaService();
      service.procesar(model);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      cocinaFormulario(request, response);
    }
    // Forward
    request.setAttribute("model", model);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("resultado.jsp");
    rd.forward(request, response);
  }

}
