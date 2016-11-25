package pe.usil.controller;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.usil.model.Detalle;
import pe.usil.model.Empleado;
import pe.usil.model.Producto;
import pe.usil.model.Usuario;
import pe.usil.model.Venta;
import pe.usil.service.ProductoService;
import pe.usil.service.VentaService;


/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "VentaController", 
        urlPatterns = {"/VentaGetForm","/VentaPostForm", "/ReporteVenta", "/Detalleventa", "/VerVenta"})
public class VentaController extends HttpServlet {
  
  private ProductoService productoService;
  private VentaService ventaService;

  @Override
  public void init() throws ServletException {
    productoService = new ProductoService();
    ventaService = new VentaService();
  }
  
  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    switch(request.getServletPath()){
      case "/VentaGetForm":
        getForm(request, response);
        break;
      case "/VentaPostForm":
        if(request.getParameter("btnGrabarVenta") != null){
          grabarVenta(request,response);
        } else if(request.getParameter("btnAddItem") != null){
          addItem(request, response);
        }
        break;
            case "/ReporteVenta":
                reporte(request, response);
                break;
            case "/Detalleventa":
                detalleventa(request, response);
                break;
                case "/VerVenta":
                verventa(request, response);
                break;
    }
  } // Fin de service

   private void forward(HttpServletRequest request, HttpServletResponse response, String destino) throws ServletException, IOException {
        RequestDispatcher rd;
        rd = request.getRequestDispatcher(destino);
        rd.forward(request, response);
    }
  
  private void getForm(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    try {
      // Productos para el combo
      request.setAttribute("productos", productoService.leerTodos());
      // Objeto venta en session
      Object o = UtilController.getValue(request, "venta");
      if(o == null){
        Venta venta = new Venta();
        UtilController.setValue(request, "venta", venta);
      }
    } catch (Exception e) {
    }
    // Forward
    UtilController.forward(request, response, "venta.jsp");
  }

  private void grabarVenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
      // Productos para el combo
      request.setAttribute("productos", productoService.leerTodos());
      // Cliente
      String cliente = request.getParameter("cliente");
      // El objeto venta
      Venta venta;
      Object o = UtilController.getValue(request, "venta");
      if(o == null){
        venta = new Venta();
        UtilController.setValue(request, "venta", venta);
      } else {
        venta = (Venta) o;
      }
      venta.setCliente(cliente);
      if(venta.getItems().size() == 0){
        throw new Exception("No tiene productos esta venta.");
      }
      // El empleado
      Usuario bean = (Usuario) UtilController.getValue(request, "usuario");    
      venta.setIdemp(bean.getCodigo());
      // Grabar venta
      venta.setFecha(Calendar.getInstance().getTime());
      ventaService.grabar(venta);
      request.setAttribute("mensaje", "Proceso ok. IdVenta=" + venta.getIdventa() + ".");
      // Reset de venta
      venta.reset();
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    UtilController.forward(request, response, "venta.jsp");
  }

  private void addItem(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    try {
      // Productos para el combo
      request.setAttribute("productos", productoService.leerTodos());
      // Datos
      String cliente = request.getParameter("cliente");
      int idprod = Integer.parseInt(request.getParameter("idprod"));
      int cant = Integer.parseInt(request.getParameter("cant"));
      // Verificar producto
      if(idprod == 0){
        throw new Exception("Debe seleccionar un producto.");
      }
      // Construyendo el detalle
      Producto prod = productoService.leerPorId(idprod);
      Detalle detalle = new Detalle();
      detalle.setIdprod(idprod);
      detalle.setNombre(prod.getNombre());
      detalle.setPrecatalogo(prod.getPrecio());
      detalle.setPreventa(prod.getPrecio());
      detalle.setCant(cant);
      detalle.setSubtotal(cant * detalle.getPreventa());
      // El objeto venta
      Venta venta;
      Object o = UtilController.getValue(request, "venta");
      if(o == null){
        venta = new Venta();
        UtilController.setValue(request, "venta", venta);
      } else {
        venta = (Venta) o;
      }
      // Agregar el item
      venta.setCliente(cliente);
      venta.addItem(detalle);
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    UtilController.forward(request, response, "venta.jsp");
  } // Fin de addItem

  
    private void reporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Datos
            Venta bean = new Venta();
            bean.setIdventa(Integer.parseInt(request.getParameter("codventa")));
            // Proceso
            VentaService service = new VentaService();
            List<Venta> lista = service.leerVenta(bean);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        forward(request, response, "ReporteVenta.jsp");
    }

    private void detalleventa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            // Datos
           Detalle bean = new Detalle();
            bean.setIdventa(Integer.parseInt(request.getParameter("codventa")));
            // Proceso
            VentaService service = new VentaService();
            List<Detalle> lista = service.leerdetalle(bean);
            request.setAttribute("lista", lista);
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
        }
        // Forward
        forward(request, response, "DetalleVenta.jsp");

    }

    private void verventa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    String destino;
        try {
            // Dato
            int codigo =Integer.parseInt(request.getParameter("codventa"));
            // Proceso
            VentaService service = new VentaService();
            Venta bean = service.leerven(codigo);
            request.setAttribute("bean", bean);
            destino = "DetalleVenta.jsp";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destino = "mainAdmin.jsp";
        }
        // Forward
        forward(request, response, destino);
    }
  
} // Fin de VentaController
