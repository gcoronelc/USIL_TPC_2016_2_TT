package pe.egcc.ventasweb.controller;

import java.io.IOException;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.ventasweb.model.Detalle;
import pe.egcc.ventasweb.model.Empleado;
import pe.egcc.ventasweb.model.Producto;
import pe.egcc.ventasweb.model.Venta;
import pe.egcc.ventasweb.service.espec.ProductoServiceEspec;
import pe.egcc.ventasweb.service.espec.VentaServiceEspec;
import pe.egcc.ventasweb.service.impl.ProductoServiceImpl;
import pe.egcc.ventasweb.service.impl.VentaServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "VentaController", 
        urlPatterns = {"/VentaGetForm","/VentaPostForm"})
public class VentaController extends HttpServlet {
  
  private ProductoServiceEspec productoService;
  private VentaServiceEspec ventaService;

  @Override
  public void init() throws ServletException {
    productoService = new ProductoServiceImpl();
    ventaService = new VentaServiceImpl();
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
    }
  } // Fin de service

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
      Empleado bean = (Empleado) UtilController.getValue(request, "usuario");    
      venta.setIdemp(bean.getIdemp());
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

  
} // Fin de VentaController
