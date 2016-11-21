package pe.egcc.ventasweb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.ventasweb.model.Empleado;
import pe.egcc.ventasweb.service.espec.EmpleadoServiceEspec;
import pe.egcc.ventasweb.service.impl.EmpleadoServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "LogonController", 
        urlPatterns = {"/LogonIngresar","/LogonSalir"})
public class LogonController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    switch(request.getServletPath()){
      case "/LogonIngresar":
        logonIngresar(request,response);
        break;
      case "/LogonSalir":
        LogonSalir(request,response);
        break;
    }
  } // Fin de service

  private void logonIngresar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String destino;
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
      EmpleadoServiceEspec service = new EmpleadoServiceImpl();
      Empleado bean = service.validar(usuario, clave);
      UtilController.setValue(request, "usuario", bean);
      destino = "main.jsp";
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    UtilController.forward(request, response, destino);
  } // Fin de LogonIngresar

  private void LogonSalir(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    request.getSession().invalidate();
    UtilController.forward(request, response, "index.jsp");
  } // Fin de LogonSalir

  
  
  
  
} // Fin de LogonController
