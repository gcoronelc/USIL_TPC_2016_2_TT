package pe.egcc.ventasweb.controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.egcc.ventasweb.model.JsonBean;
import pe.egcc.ventasweb.model.Producto;
import pe.egcc.ventasweb.service.espec.ProductoServiceEspec;
import pe.egcc.ventasweb.service.impl.ProductoServiceImpl;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
@WebServlet(name = "ProductoController",
        urlPatterns = {"/ProductoTraerUno", "/fsdfsdfs", "/sdfsdfsd"})
public class ProductoController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request,
          HttpServletResponse response)
          throws ServletException, IOException {

    switch (request.getServletPath()) {
      case "/ProductoTraerUno":
        traerUno(request, response);
        break;
    }

  }

  private void traerUno(HttpServletRequest request, HttpServletResponse response) throws IOException {
    JsonBean jsonBean = new JsonBean();
    try {
      // Dato
      int id = Integer.parseInt(request.getParameter("id"));
      // Proceso
      ProductoServiceEspec service;
      service = new ProductoServiceImpl();
      Producto bean = service.leerPorId(id);
      // Pasar bean a JSON
      Gson gson = new Gson();
      String text = gson.toJson(bean);
      jsonBean.setCode(1);
      jsonBean.setText(text);
    } catch (Exception e) {
      jsonBean.setCode(-1);
      jsonBean.setText(e.getMessage());
    }
    // Respuesta
    UtilController.responseJson(response, jsonBean);
  }

}
