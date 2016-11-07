package pe.egcc.ventasweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.ventasweb.model.Promocion;
import pe.egcc.ventasweb.service.espec.PromocionServiceEspec;
import pe.egcc.ventasweb.service.impl.PromocionServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "PromocionController", 
        urlPatterns = {"/PromocionConsultar", "/aaaaaa", "/bbbbbb"})
public class PromocionController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
  
    switch(request.getServletPath()){
      
      case "/PromocionConsultar":
        promocionConsultar(request,response);
        break;
        
    }
    
  
  }

  private void promocionConsultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      int idprod = Integer.parseInt(request.getParameter("idprod"));
      PromocionServiceEspec service;
      service = new PromocionServiceImpl();
      List<Promocion> lista = service.getPromociones(idprod);
      request.setAttribute("listado", lista);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    UtilController.forward(request, response, "listaPromociones.jsp");
  }

  
  
  
}
