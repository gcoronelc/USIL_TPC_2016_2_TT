package pe.usil.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.usil.model.Campania;
import pe.usil.service.CampaniaService;

@WebServlet(name = "CampaniaController", urlPatterns = {"/ConsultaCamp", "/CampEditar", "/CampEliminar", "/NuevoCamp", "/ModificarCamp", "/EliminarCamp"})
public class CampaniaController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/ConsultaCamp":
                if (request.getParameter("btnConsulta") != null) {
                    consulta(request, response);
                } else if (request.getParameter("btnNuevo") != null) {
                    nuevo(request, response);
                }
                break;
            case "/CampEditar":
                editar(request, response);
                break;

            case "/ModificarCamp":
                modificarCamp(request, response);
                break;

            case "/CampEliminar":
                eliminar(request, response);
                break;

            case "/EliminarCamp":
                eliminarCamp(request, response);
                break;

            case "/NuevoCamp":
                crearCamp(request, response);
                break;
        }
    }

    private void consulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Datos
            Campania bean = new Campania();
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            // Proceso
            CampaniaService service = new CampaniaService();
            List<Campania> lista = service.leerCampaña(bean);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        forward(request, response, "mantCampania.jsp");
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nuevo = request.getParameter("btnNuevo");
            request.setAttribute("nuevo", nuevo);
        } catch (Exception e) {
        }
        forward(request, response, "mantCampania.jsp");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            CampaniaService service = new CampaniaService();
            Campania bean = service.leerPorId(codigo);
            request.setAttribute("bean", bean);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        forward(request, response, "editarCampania.jsp");
    }

    private void modificarCamp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Campania bean = new Campania();
        try {
            // Datos
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            bean.setNombre(request.getParameter("nombre"));
            bean.setDescripcion(request.getParameter("descripcion"));
            bean.setFecInicio(request.getParameter("fecInicio"));
            bean.setFecFin(request.getParameter("fecFin"));
            bean.setEstado(Integer.parseInt(request.getParameter("estado")));
            bean.setAnulado(Integer.parseInt(request.getParameter("anulado")));

            // Proceso
            CampaniaService service = new CampaniaService();
            service.actualizar(bean);
            destino = "mantCampania.jsp";
            request.setAttribute("mensaje", "Campaña actualizada correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "editarCampania.jsp";
        }

        forward(request, response, destino);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            CampaniaService service = new CampaniaService();
            Campania bean = service.leerPorId(codigo);
            request.setAttribute("bean", bean);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        forward(request, response, "eliminarCampania.jsp");
    }

    private void eliminarCamp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Campania bean = new Campania();
        try {
            // Datos
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            // Proceso
            CampaniaService service = new CampaniaService();
            service.eliminar(codigo);
            destino = "mantCampania.jsp";
            request.setAttribute("mensaje", "Campaña Eliminada correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "eliminarCampania.jsp";
        }

        forward(request, response, destino);
    }

    private void crearCamp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Campania bean = new Campania();
        try {
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            bean.setNombre(request.getParameter("nombre"));
            bean.setDescripcion(request.getParameter("descripcion"));
            bean.setFecInicio(request.getParameter("fecInicio"));
            bean.setFecFin(request.getParameter("fecFin"));
            bean.setEstado(Integer.parseInt(request.getParameter("estado")));
            bean.setAnulado(Integer.parseInt(request.getParameter("anulado")));

            CampaniaService service = new CampaniaService();
            service.nuevo(bean);
            destino = "mantCampania.jsp";
            request.setAttribute("mensaje", "Campaña creada correctamente");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "mantCampania.jsp";
        }

        forward(request, response, destino);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

}
