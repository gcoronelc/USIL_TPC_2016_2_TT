package pe.egcc.carrito.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.egcc.carrito.model.Carrito;
import pe.egcc.carrito.model.Item;
import pe.egcc.carrito.service.CarritoService;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "CarritoController", 
        urlPatterns = {"/AddItem"})
public class CarritoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, 
          HttpServletResponse response) throws ServletException, IOException {
    try {
      // Item
      Item item = new Item();
      item.setNombre(request.getParameter("articulo"));
      item.setPrecio(Double.parseDouble(request.getParameter("precio")));
      item.setCant(Integer.parseInt(request.getParameter("cant")));
      // Proceso
      Carrito carrito = obtenerCarrito(request);
      CarritoService service = new CarritoService();
      service.addItem(carrito, item);
      // Mensaje
      request.setAttribute("mensaje", "Proceso ok.");
    } catch (Exception e) {
      request.setAttribute("error", e.getMessage());
    }
    // Forward
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("agregar.jsp");
    rd.forward(request, response);
  }

  private Carrito obtenerCarrito(HttpServletRequest request) {
    HttpSession session = request.getSession();
    if(session.getAttribute("carrito") == null){
      session.setAttribute("carrito", new Carrito());
    }
    Carrito carrito;
    carrito = (Carrito) session.getAttribute("carrito");
    return carrito;
  }

  
}
