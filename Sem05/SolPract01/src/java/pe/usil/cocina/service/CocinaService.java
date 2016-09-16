package pe.usil.cocina.service;

import pe.usil.cocina.model.CocinaModel;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
public class CocinaService {

  // Cursos
  private final String CUR01 = "Gestión de Eventos";
  private final String CUR02 = "Sopas y Caldos Tradicionales";
  private final String CUR03 = "Estofados Criollos";
  private final String CUR04 = "Pescado en Tu Mesa";

  // Categorías
  private final String CAT01 = "BASICO";
  private final String CAT02 = "AVANZADO";
  private final String CAT03 = "EXPERTO";
  
  /**
   * 
   * @return Retorna un arreglo con los cursos.
   */
  public String[] getCursos(){
    String[] cursos = {CUR01,CUR02,CUR03,CUR04};
    return cursos;
  }
  
  /**
   * 
   * @return Retorna un arreglo con las categorías.
   */
  public String[] getCategorias(){
    String[] categorias = {CAT01,CAT02,CAT03};
    return categorias;
  }
  
  public void procesar(CocinaModel model){
    
  }
  
  
}
