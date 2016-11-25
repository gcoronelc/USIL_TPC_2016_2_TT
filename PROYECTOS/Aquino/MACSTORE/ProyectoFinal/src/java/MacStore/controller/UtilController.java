package MacStore.controller;


import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public final class UtilController {

  private UtilController() {
  }
  
  // Constantes del CRUD
  public static final String CRUD_NUEVO = "NUEVO";
  public static final String CRUD_EDITAR = "EDITAR";
  public static final String CRUD_ELIMINAR = "ELIMINAR";

  public static void forward(HttpServletRequest request, 
          HttpServletResponse response, String target) 
          throws ServletException, IOException {
    RequestDispatcher rd;
    rd = request.getRequestDispatcher(target);
    rd.forward(request, response);
  }
  
  
  
  /**
   * Guardar un dato en session
   * 
   * @param request
   * @param key
   * @param value 
   */
  public static void setValue(HttpServletRequest request, String key, Object value){
    HttpSession session = request.getSession();
    session.setAttribute(key, value);
  }
  
  /**
   * Lee un dato de session
   * 
   * @param request
   * @param key
   * @return 
   */
  public static Object getValue(HttpServletRequest request, String key){
    HttpSession session = request.getSession();
    return session.getAttribute(key);
  }
}
