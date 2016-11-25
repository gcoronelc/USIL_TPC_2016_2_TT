package MegaStore.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MegaStore.model.Empleado;
import MegaStore.service.espec.EmpleadoServiceEspec;
import MegaStore.service.impl.EmpleadoServiceImpl;

@WebServlet(name = "EmpleadoController",
        urlPatterns = {"/EmpleadoConsulta", "/EmpleadoEliminar",
          "/EmpleadoEditar", "/EmpleadoGrabar"})
public class EmpleadoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    switch (request.getServletPath()) {
      case "/EmpleadoConsulta":
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
      case "/EmpleadoGrabar":
        grabar(request, response);
        break;
    }

  } // Fin de service

  private void consultar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      Empleado criterio = new Empleado();
      criterio.setNombre(request.getParameter("nombre"));
      criterio.setApellido(request.getParameter("apellido"));
      // Proceso
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      List<Empleado> lista = service.leer(criterio);
      // Datos para el view
      request.setAttribute("criterio", criterio);
      request.setAttribute("lista", lista);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    UtilController.forward(request, response, "mantEmpleados.jsp");
  } // Fin de consultar

  private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      Empleado criterio = new Empleado();
      criterio.setNombre(request.getParameter("nombre"));
      criterio.setApellido(request.getParameter("apellido"));
      // Datos para el view
      request.setAttribute("criterio", criterio);
      request.setAttribute("bean", new Empleado());
      request.setAttribute("accion", UtilController.CRUD_NUEVO);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    UtilController.forward(request, response, "mantEmpleados.jsp");
  }

  private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      int id = Integer.parseInt(request.getParameter("id"));
      // Recuperar datos del empleado
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      Empleado bean = service.leerPorId(id);
      // Datos para el view
      request.setAttribute("bean", bean);
      request.setAttribute("accion", UtilController.CRUD_ELIMINAR);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    UtilController.forward(request, response, "mantEmpleados.jsp");
  } // Fin de eliminar

  private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      int id = Integer.parseInt(request.getParameter("id"));
      // Recuperar datos del empleado
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      Empleado bean = service.leerPorId(id);
      // Datos para el view
      request.setAttribute("bean", bean);
      request.setAttribute("accion", UtilController.CRUD_EDITAR);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    UtilController.forward(request, response, "mantEmpleados.jsp");
  } // Fin de editar

  private void grabar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Datos
      String accion = request.getParameter("accion");
      Empleado bean = new Empleado();
      bean.setIdemp(Integer.parseInt(request.getParameter("idemp")));
      if(!accion.equals(UtilController.CRUD_ELIMINAR)){
        bean.setApellido(request.getParameter("apellido"));
        bean.setNombre(request.getParameter("nombre"));
        bean.setEmail(request.getParameter("email"));
        bean.setTelefono(request.getParameter("telefono"));
        bean.setDni(request.getParameter("dni"));
        bean.setDireccion(request.getParameter("direccion"));
        bean.setEstado(request.getParameter("estado"));
        
      }
      // Proceso
      EmpleadoServiceEspec service;
      service = new EmpleadoServiceImpl();
      String mensaje = "";
      switch(accion){
        case UtilController.CRUD_NUEVO:
          service.crear(bean);
          mensaje = "Empleado crea correctamente, con id " + bean.getIdemp() + ".";
          break;
        case UtilController.CRUD_EDITAR:
          service.modificar(bean);
          mensaje = "Empleado se ha actualizado correctamente.";
          break;
        case UtilController.CRUD_ELIMINAR:
          service.eliminar(bean.getIdemp());
           mensaje = "Empleado se ha Eliminado correctamente.";
          break;
      }
      request.setAttribute("mensaje", mensaje);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    UtilController.forward(request, response, "mantEmpleados.jsp");
  } // Fin de grabar

} // Fin de EmpleadoController
