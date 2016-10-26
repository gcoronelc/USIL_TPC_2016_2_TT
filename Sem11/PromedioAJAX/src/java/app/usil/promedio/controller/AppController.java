package app.usil.promedio.controller;

import app.usil.promedio.model.Notas;
import app.usil.promedio.service.NotaService;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ocule
 */
@WebServlet(name = "AppController", urlPatterns = {"/AppController"})
public class AppController extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    // Datos
    int pract1 = Integer.parseInt(request.getParameter("prac1"));
    int pract2 = Integer.parseInt(request.getParameter("prac2"));
    int pract3 = Integer.parseInt(request.getParameter("prac3"));
    int trab1 = Integer.parseInt(request.getParameter("tra1"));
    int trab2 = Integer.parseInt(request.getParameter("tra2"));
    int trab3 = Integer.parseInt(request.getParameter("tra3"));
    int exaParcial = Integer.parseInt(request.getParameter("parcial"));
    int exaFinal = Integer.parseInt(request.getParameter("final"));

    // Proceso
    NotaService notaService = new NotaService();
    Notas bean = new Notas();
    bean.setPract1(pract1);
    bean.setPract2(pract2);
    bean.setPract3(pract3);
    bean.setTrab1(trab1);
    bean.setTrab2(trab2);
    bean.setTrab3(trab3);
    bean.setExaParcial(exaParcial);
    bean.setExaFinal(exaFinal);
    notaService.procesar(bean);
    
    // Crear texto json
    Gson gson = new Gson();
    String objJson = gson.toJson(bean);

    // Reporte
    //response.setContentType("text/plain;charset=UTF-8");
    response.setContentType("application/json;charset=UTF-8");
    PrintWriter out = response.getWriter();
    out.println(objJson);
    out.flush();
  }

}
