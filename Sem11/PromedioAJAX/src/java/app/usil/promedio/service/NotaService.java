package app.usil.promedio.service;

import app.usil.promedio.model.Notas;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email egcc.usil@gmail.com
 */
public class NotaService {
  
  public void procesar(Notas notas){
    // Variables
    int promPract, promTrab, promFinal;
    String condicion;
    // Proceso
    promPract = (notas.getPract1() + 
            notas.getPract2() + notas.getPract3())/3;
    promTrab = (notas.getTrab1() + 
            notas.getTrab2() + notas.getTrab3())/3;
    promFinal = (promPract + promTrab + 
            notas.getExaParcial() + notas.getExaFinal()) / 4;
    if(promFinal >= 13.0){
      condicion = "Aprobado";
    } else {
      condicion = "Desaprobado";
    }
    // Reporte
    notas.setPromPract(promPract);
    notas.setPromTrab(promTrab);
    notas.setPromFinal(promFinal);
    notas.setCondicion(condicion);
  }
}
