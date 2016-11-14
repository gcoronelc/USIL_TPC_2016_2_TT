package pe.egcc.ventasweb.service.espec;

import java.util.List;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public interface CrudServiceEspec<T> {
  
  void crear(T bean);
  
  void modificar(T bean);
  
  void eliminar(int id);
  
  T leerPorId(int id);
  
  List<T> leerTodos();
  
  List<T> leer(T bean);
  
}
