package pe.usil.promapp.service;

import pe.usil.promapp.model.PromModel;

public class PromService {
  
  public void procesar(PromModel model){
    // Variables
    int prom;
    String condicion;
    // Proceso
    prom = (model.getPromPract() + model.getExaParcial() 
            + model.getExaFinal()) / 3;
    if( prom >= 13){
      condicion = "Aprobado";
    } else if(prom > 11){
      condicion = "Sustitutorio";
    } else {
      condicion = "Desaprobado";
    }
    // Reporte
    model.setPromFinal(prom);
    model.setCondicion(condicion);
  }
}
