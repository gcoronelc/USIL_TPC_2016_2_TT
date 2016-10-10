package pe.egcc.ventasweb.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "EmpleadoController", 
        urlPatterns = {"/EmpleadoConsultar", "/EmpleadoLeerPorId"})
public class EmpleadoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    switch(request.getServletPath()){
      case "/EmpleadoConsultar":
        consultar(request,response);
        break;
    }
  } // Fin de service

  private void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Datos
    String nombre = request.getParameter("nombre");
    String apellido = request.getParameter("apellido");
    // Proceso
    Empleado bean = new Empleado();
    bean.setNombre(nombre);
    bean.setApellido(apellido);
    EmpleadoServiceEspec service = new EmpleadoServiceImpl();
    List<Empleado> lista = service.leer(bean);
    // Forward
    request.setAttribute("lista", lista);
    UtilController.forward(request, response, "mantEmpleados.jsp");
  }

  
  
} // Fin de EmpleadoController
