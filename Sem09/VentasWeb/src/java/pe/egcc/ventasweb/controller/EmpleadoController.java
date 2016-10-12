package pe.egcc.ventasweb.controller;

import java.io.IOException;
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
        urlPatterns = {"/EmpleadoConsultar",
          "/EmpleadoEditar", "/EmpleadoEliminar",
          "/EmpleadoLeerPorId"})
public class EmpleadoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    switch (request.getServletPath()) {
      case "/EmpleadoConsultar":
        if (request.getParameter("btnConsultar") != null) {
          consultar(request, response);
        } else if (request.getParameter("btnNuevo") != null) {
          nuevo(request, response);
        }
        break;
      case "/EmpleadoEditar":
        editar(request, response);
        break;
      case "/EmpleadoEliminar":
        eliminar(request, response);
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

  private void nuevo(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    // Variables
    Empleado bean = new Empleado();
    // Datos para la página
    request.setAttribute("accion", UtilController.CRUD_NUEVO);
    request.setAttribute("bean", bean);
    UtilController.forward(request, response, "editarEmpleado.jsp");
  } // Fin de nuevo

  private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Parámetro
    int id = Integer.parseInt(request.getParameter("id"));
    // Recuperar datos del empleado
    EmpleadoServiceEspec service;
    service = new EmpleadoServiceImpl();
    Empleado bean = service.leer(id);
    // Datos de la página
    request.setAttribute("bean", bean);
    request.setAttribute("accion", UtilController.CRUD_EDITAR);
    UtilController.forward(request, response, "editarEmpleado.jsp");
  }

  private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Parámetro
    int id = Integer.parseInt(request.getParameter("id"));
    // Recuperar datos del empleado
    EmpleadoServiceEspec service;
    service = new EmpleadoServiceImpl();
    Empleado bean = service.leer(id);
    // Datos de la página
    request.setAttribute("bean", bean);
    request.setAttribute("accion", UtilController.CRUD_ELIMIAR);
    UtilController.forward(request, response, "editarEmpleado.jsp");
  }

} // Fin de EmpleadoController
