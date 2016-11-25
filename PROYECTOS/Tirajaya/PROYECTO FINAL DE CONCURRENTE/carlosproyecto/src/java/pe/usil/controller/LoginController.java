
package pe.usil.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.usil.model.Usuario;
import pe.usil.service.LogInService;


@WebServlet(name = "ControllerLogin", urlPatterns = {"/LoginInicio", "/LoginSalir"})
public class LoginController extends HttpServlet {

    @Override
  protected void service(HttpServletRequest request, HttpServletResponse response) 
          throws ServletException, IOException {
    String path = request.getServletPath();
    if(path.equals("/LoginInicio")){
      loginUsuario(request,response);
    } else if(path.equals("/LoginSalir")){
      loginSalir(request,response);
    }
    
  }

    private void loginUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String destino = "";
    try {
      // Datos
      String usuario = request.getParameter("usuario");
      String clave = request.getParameter("clave");
      // Proceso
       LogInService service = new LogInService();
       Usuario bean = service.validarUsuario(usuario, clave);
      // Guardando datos en session
      HttpSession session = request.getSession();
      session.setAttribute("usuario", bean);
      destino = "main.jsp";
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
      destino = "index.jsp";
    }
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
    }

    private void loginSalir(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Cerrar session
    HttpSession session = request.getSession();
    session.invalidate();
    // Forward
    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
    rd.forward(request, response);
    }
}
