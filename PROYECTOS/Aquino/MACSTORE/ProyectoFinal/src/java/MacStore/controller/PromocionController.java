package MacStore.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MacStore.model.Promocion;
import MacStore.service.PromocionService;


@WebServlet(name = "PromocionController", urlPatterns = {"/ConsultaPromo", "/PromoEditar", "/PromoEliminar", "/NuevoPromo", "/ModificarPromo", "/EliminarPromo"})
public class PromocionController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/ConsultaPromo":
                if (request.getParameter("btnConsulta") != null) {
                    consulta(request, response);
                } else if (request.getParameter("btnNuevo") != null) {
                    nuevo(request, response);
                }
                break;
            case "/PromoEditar":
                editar(request, response);
                break;

            case "/ModificarPromo":
                modificarPromo(request, response);
                break;

            case "/PromoEliminar":
                eliminar(request, response);
                break;

            case "/EliminarPromo":
                eliminarPromo(request, response);
                break;

            case "/NuevoPromo":
                crearPromo(request, response);
                break;
        }

    }

    private void consulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Datos
            Promocion bean = new Promocion();
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            // Proceso
            PromocionService service = new PromocionService();
            List<Promocion> lista = service.leerPromocion(bean);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        forward(request, response, "mantPromocion.jsp");
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nuevo = request.getParameter("btnNuevo");
            request.setAttribute("nuevo", nuevo);
        } catch (Exception e) {
        }
        forward(request, response, "mantPromocion.jsp");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            PromocionService service = new PromocionService();
            Promocion bean = service.leerPorId(codigo);
            request.setAttribute("bean", bean);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        forward(request, response, "editarPromocion.jsp");
    }

    private void modificarPromo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Promocion bean = new Promocion();
        try {
            // Datos
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            bean.setIdprod(Integer.parseInt(request.getParameter("idprod")));
            bean.setFecInicio(request.getParameter("fecInicio"));
            bean.setFecFin(request.getParameter("fecFin"));
            bean.setPrecio(Double.parseDouble(request.getParameter("precio")));
            bean.setOferta(Double.parseDouble(request.getParameter("oferta")));
            bean.setEstado(Integer.parseInt(request.getParameter("estado")));
            bean.setAnulado(Integer.parseInt(request.getParameter("anulado")));

            // Proceso
            PromocionService service = new PromocionService();
            service.actualizar(bean);
            destino = "mantPromocion.jsp";
            request.setAttribute("mensaje", "Promocion actualizada correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "editarPromocion.jsp";
        }

        forward(request, response, destino);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            PromocionService service = new PromocionService();
            Promocion bean = service.leerPorId(codigo);
            request.setAttribute("bean", bean);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        forward(request, response, "eliminarPromocion.jsp");
    }

    private void eliminarPromo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Promocion bean = new Promocion();
        try {
            // Datos
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            // Proceso
            PromocionService service = new PromocionService();
            service.eliminar(codigo);
            destino = "mantPromocion.jsp";
            request.setAttribute("mensaje", "Promocion Eliminada correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "eliminarPromocion.jsp";
        }

        forward(request, response, destino);
    }

    private void crearPromo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Promocion bean = new Promocion();
        try {
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            bean.setIdprod(Integer.parseInt(request.getParameter("idprod")));
            bean.setFecInicio(request.getParameter("fecInicio"));
            bean.setFecFin(request.getParameter("fecFin"));
            bean.setPrecio(Double.parseDouble(request.getParameter("precio")));
            bean.setOferta(Double.parseDouble(request.getParameter("oferta")));
            bean.setEstado(Integer.parseInt(request.getParameter("estado")));
            bean.setAnulado(Integer.parseInt(request.getParameter("anulado")));

            PromocionService service = new PromocionService();
            service.nuevo(bean);
            destino = "mantPromocion.jsp";
            request.setAttribute("mensaje", "Promocion creada correctamente");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "mantPromocion.jsp";
        }

        forward(request, response, destino);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
}
