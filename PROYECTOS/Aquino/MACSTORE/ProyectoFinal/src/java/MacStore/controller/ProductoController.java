package MacStore.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import MacStore.model.Producto;
import MacStore.service.ProductoService;

@WebServlet(name = "ProductoController", urlPatterns = {"/ConsultaProducto", "/ProdEditar", "/ProdEliminar", "/NuevoProd", "/ModificarProd", "/EliminarProd"})
public class ProductoController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        switch (request.getServletPath()) {
            case "/ConsultaProducto":
                if (request.getParameter("btnConsulta") != null) {
                    consulta(request, response);
                } else if (request.getParameter("btnNuevo") != null) {
                    nuevo(request, response);
                }
                break;
            case "/ProdEditar":
                editar(request, response);
                break;

            case "/ModificarProd":
                modificarProd(request, response);
                break;

            case "/ProdEliminar":
                eliminar(request, response);
                break;

            case "/EliminarProd":
                eliminarProducto(request, response);
                break;

            case "/NuevoProd":
                crearProducto(request, response);
                break;

        }
    }

    private void consulta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Datos
            Producto bean = new Producto();
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            // Proceso
            ProductoService service = new ProductoService();
            List<Producto> lista = service.leerProducto(bean);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        forward(request, response, "mantProducto.jsp");
    }

    private void forward(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }

    private void nuevo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String nuevo = request.getParameter("btnNuevo");
            request.setAttribute("nuevo", nuevo);
        } catch (Exception e) {
        }
        forward(request, response, "mantProducto.jsp");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            ProductoService service = new ProductoService();
            Producto bean = service.leerPorId(codigo);
            request.setAttribute("bean", bean);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        forward(request, response, "editarProducto.jsp");
    }

    private void crearProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Producto bean = new Producto();
        try {
            bean.setCategoria(Integer.parseInt(request.getParameter("idcat")));
            bean.setNombre(request.getParameter("nombre"));
            bean.setDescripcion(request.getParameter("descripcion"));
            bean.setPrecio(Double.parseDouble(request.getParameter("precio")));
            bean.setStock(Integer.parseInt(request.getParameter("stock")));
            bean.setEstado(Integer.parseInt(request.getParameter("estado")));

            ProductoService service = new ProductoService();
            service.nuevo(bean);
            destino = "mantProducto.jsp";
            request.setAttribute("mensaje", "EXITO. Codigo de producto creado: " + bean.getCodigo());
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "mantProducto.jsp";
        }

        forward(request, response, destino);
    }

    private void modificarProd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Producto bean = new Producto();
        try {
            // Datos
            bean.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            bean.setCategoria(Integer.parseInt(request.getParameter("categoria")));
            bean.setNombre(request.getParameter("nombre"));
            bean.setDescripcion(request.getParameter("descripcion"));
            bean.setPrecio(Double.parseDouble(request.getParameter("precio")));
            bean.setStock(Integer.parseInt(request.getParameter("stock")));
            bean.setEstado(Integer.parseInt(request.getParameter("estado")));

            // Proceso
            ProductoService service = new ProductoService();
            service.actualizar(bean);
            destino = "mantProducto.jsp";
            request.setAttribute("mensaje", "Producto actualizado Correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "editarProducto.jsp";
        }

        forward(request, response, destino);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int codigo = Integer.parseInt(request.getParameter("codigo"));

            ProductoService service = new ProductoService();
            Producto bean = service.leerPorId(codigo);
            request.setAttribute("bean", bean);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        forward(request, response, "eliminarProducto.jsp");
    }

    private void eliminarProducto(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destino;
        Producto bean = new Producto();
        try {
            // Datos
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            // Proceso
            ProductoService service = new ProductoService();
            service.eliminar(codigo);
            destino = "mantProducto.jsp";
            request.setAttribute("mensaje", "Producto Eliminado correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            request.setAttribute("bean", bean);
            destino = "eliminarProducto.jsp";
        }

        forward(request, response, destino);
    }

}
