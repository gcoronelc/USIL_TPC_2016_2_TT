package pe.egcc.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "Registrar", urlPatterns = {"/Registrar"})
public class Registrar extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {

    // Dato
    String nombre = request.getParameter("nombre");
    // Acceso a la sesión
    HttpSession session = request.getSession();
    session.setAttribute("nombre", nombre);
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("resultado.jsp");
    rd.forward(request, response);
    
  } // Fin de service

} // Fin de clase
