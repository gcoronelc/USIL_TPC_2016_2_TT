package pe.usil.cocina.model;

/**
 *
 * @author Eric Gustavo Coronel Castillo
 * @blog www.desarrollasoftware.com
 * @email gcoronelc@gmail.com
 */
public class CocinaModel { // Inicio de la clase

  // Datos
  private String curso;
  private String categoria;
  private int vacantes;
  // Resultado
  private double ingresos;
  private double publicidad;
  private double logistica;
  private double materiales;
  private double instructor;
  private double rentabilidad;

  public CocinaModel() {
  }

  public String getCurso() {
    return curso;
  }

  public void setCurso(String curso) {
    this.curso = curso;
  }

  public String getCategoria() {
    return categoria;
  }

  public void setCategoria(String categoria) {
    this.categoria = categoria;
  }

  public int getVacantes() {
    return vacantes;
  }

  public void setVacantes(int vacantes) {
    this.vacantes = vacantes;
  }

  public double getIngresos() {
    return ingresos;
  }

  public void setIngresos(double ingresos) {
    this.ingresos = ingresos;
  }

  public double getPublicidad() {
    return publicidad;
  }

  public void setPublicidad(double publicidad) {
    this.publicidad = publicidad;
  }

  public double getLogistica() {
    return logistica;
  }

  public void setLogistica(double logistica) {
    this.logistica = logistica;
  }

  public double getMateriales() {
    return materiales;
  }

  public void setMateriales(double materiales) {
    this.materiales = materiales;
  }

  public double getInstructor() {
    return instructor;
  }

  public void setInstructor(double instructor) {
    this.instructor = instructor;
  }

  public double getRentabilidad() {
    return rentabilidad;
  }

  public void setRentabilidad(double rentabilidad) {
    this.rentabilidad = rentabilidad;
  }

  
  

} // Fin de la clase
