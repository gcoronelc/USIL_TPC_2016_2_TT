package usil.store.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import usil.store.model.Categoria;
import usil.store.service.ServiceCategoria;


@WebServlet(name = "CategoriaController", urlPatterns = {"/ConsultaCat", "/CatEditar",
    "/CatEliminar", "/NuevoCat", "/ModificarCat", "/EliminarCat","/ConCate"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/ConsultaCat":
                if (request.getParameter("btnConsulta") != null) {
                    consulta(request, response);
                } else if (request.getParameter("btnNuevo") != null) {
                    nuevo(request, response);
                }
                break;
            case "/CatEditar":
                editar(request, response);
                break;

            case "/ModificarCat":
                modificarCat(request, response);
                break;

            case "/CatEliminar":
                eliminar(request, response);
                break;

            case "/EliminarCat":
                eliminarCat(request, response);
                break;

            case "/NuevoCat":
                crearCat(request, response);
                break;
                case "/ConCate":
                concate(request, response);
                break;
        }
    }

    private void consulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Datos
            Categoria bean = new Categoria();
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            // Proceso
            ServiceCategoria service = new ServiceCategoria();
            List<Categoria> lista = service.leerCategoria(bean);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        forward(request, response, "mantCategoria.jsp");
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nuevo = request.getParameter("btnNuevo");
            request.setAttribute("nuevo", nuevo);
        } catch (Exception e) {
        }
        forward(request, response, "mantCategoria.jsp");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            ServiceCategoria service = new ServiceCategoria();
            Categoria bean = service.leerPorId(codigo);
            request.setAttribute("bean", bean);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        forward(request, response, "editarCategoria.jsp");
    }

    private void modificarCat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Categoria bean = new Categoria();
        try {
            // Datos
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            bean.setNombre(request.getParameter("nombre"));
            bean.setDescripcion(request.getParameter("descripcion"));

            // Proceso
            ServiceCategoria service = new ServiceCategoria();
            service.actualizar(bean);
            destino = "mantCategoria.jsp";
            request.setAttribute("mensaje", "Categoria actualizada correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "editarCategoria.jsp";
        }

        forward(request, response, destino);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            ServiceCategoria service = new ServiceCategoria();
            Categoria bean = service.leerPorId(codigo);
            request.setAttribute("bean", bean);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        forward(request, response, "eliminarCategoria.jsp");
    }

    private void eliminarCat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Categoria bean = new Categoria();
        try {
            // Datos
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            // Proceso
            ServiceCategoria service = new ServiceCategoria();
            service.eliminar(codigo);
            destino = "mantCategoria.jsp";
            request.setAttribute("mensaje", "Categoria Eliminada correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "eliminarCategoria.jsp";
        }

        forward(request, response, destino);
    }

    private void crearCat(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Categoria bean = new Categoria();
        try {
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            bean.setNombre(request.getParameter("nombre"));
            bean.setDescripcion(request.getParameter("descripcion"));

            ServiceCategoria service = new ServiceCategoria();
            service.nuevo(bean);
            destino = "mantCategoria.jsp";
            request.setAttribute("mensaje", "Categoria creada correctamente");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "mantCategoria.jsp";
        }

        forward(request, response, destino);
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    private void concate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        
         try {
            // Datos
            Categoria bean = new Categoria();
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            // Proceso
            ServiceCategoria service = new ServiceCategoria();
            List<Categoria> lista = service.leerCategoria(bean);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        forward(request, response, "consultaCategoria.jsp");
    }

}
