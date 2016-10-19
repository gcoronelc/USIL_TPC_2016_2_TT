package pe.egcc.app.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.app.model.Cliente;
import pe.egcc.app.service.ClienteService;

@WebServlet({"/Consulta", "/Editar", "/Eliminar",
  "/GrabarModificar", "/GrabarNuevo"})
public class ClienteController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response) throws ServletException, IOException {
    System.err.println("que pasa1");
    switch (request.getServletPath()) {
      case "/Consulta":
        if (request.getParameter("btnConsulta") != null) {
          consulta(request, response);
        } else if (request.getParameter("btnNuevo") != null) {
          nuevo(request, response);
        }
        break;
      case "/Editar":
        editar(request, response);
        break;
      case "/Eliminar":
        //eliminar(request,response);
        break;
      case "/GrabarModificar":
        grabarModificar(request, response);
        break;
      case "/GrabarNuevo":
        System.err.println("que pasa");
        grabarNuevo(request, response);
        break;
    }
  } // Fin de service

  private void consulta(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    try {
      // Datos
      Cliente bean = new Cliente();
      bean.setNombre(request.getParameter("nombre"));
      bean.setPaterno(request.getParameter("paterno"));
      bean.setMaterno(request.getParameter("materno"));
      // Proceso
      ClienteService service = new ClienteService();
      List<Cliente> lista = service.leer(bean);
      request.setAttribute("lista", lista);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    forward(request, response, "index.jsp");
  } // Fin de Consulta

  private void forward(HttpServletRequest request,
          HttpServletResponse response, String destino)
          throws ServletException, IOException {
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(destino);
    rd.forward(request, response);
  }

  private void editar(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    try {
      // Dato
      String codigo = request.getParameter("codigo");
      // Proceso
      ClienteService service = new ClienteService();
      Cliente bean = service.leer(codigo);
      request.setAttribute("bean", bean);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    forward(request, response, "editar.jsp");
  }

  private void grabarModificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String destino;
    Cliente bean = new Cliente();
    try {
      // Datos
      bean.setCodigo(request.getParameter("codigo"));
      bean.setPaterno(request.getParameter("paterno"));
      bean.setMaterno(request.getParameter("materno"));
      bean.setNombre(request.getParameter("nombre"));
      bean.setDni(request.getParameter("dni"));
      bean.setCiudad(request.getParameter("ciudad"));
      bean.setDireccion(request.getParameter("direccion"));
      bean.setTelefono(request.getParameter("telefono"));
      bean.setEmail(request.getParameter("email"));
      // Proceso
      ClienteService service = new ClienteService();
      service.modificar(bean);
      destino = "index.jsp";
      request.setAttribute("mensaje", "Proceso ok.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
      request.setAttribute("bean", bean);
      destino = "editar.jsp";
    }
    // Forward
    forward(request, response, destino);
  } // Fin de grabarModificar

  private void nuevo(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {
    forward(request, response, "nuevo.jsp");
  }

  private void grabarNuevo(HttpServletRequest request, 
          HttpServletResponse response) 
          throws ServletException, IOException {
    String destino;
    Cliente bean = new Cliente();
    try {
      // Datos
      bean.setPaterno(request.getParameter("paterno"));
      bean.setMaterno(request.getParameter("materno"));
      bean.setNombre(request.getParameter("nombre"));
      bean.setDni(request.getParameter("dni"));
      bean.setCiudad(request.getParameter("ciudad"));
      bean.setDireccion(request.getParameter("direccion"));
      bean.setTelefono(request.getParameter("telefono"));
      bean.setEmail(request.getParameter("email"));
      // Proceso
      ClienteService service = new ClienteService();
      service.nuevo(bean);
      destino = "index.jsp";
      request.setAttribute("mensaje", "Proceso ok. Codigo: " + bean.getCodigo() + ".");
    } catch (Exception e) {
      e.printStackTrace();
      request.setAttribute("error", e.getMessage());
      request.setAttribute("bean", bean);
      destino = "editar.jsp";
    }
    // Forward
    forward(request, response, destino);
  }

} // Fin de ClienteController
