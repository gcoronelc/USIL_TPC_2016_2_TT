package pe.egcc.ventasweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

  private void logonIngresar(HttpServletRequest request, HttpServletResponse response) {
    
  } // Fin de LogonIngresar

  private void LogonSalir(HttpServletRequest request, HttpServletResponse response) {
    
  } // Fin de LogonSalir

  
  
  
  
} // Fin de LogonController
