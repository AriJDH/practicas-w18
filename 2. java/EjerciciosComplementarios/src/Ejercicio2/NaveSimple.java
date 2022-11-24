package Ejercicio2;

public class NaveSimple implements IUnidadDefensa {

 private String nombre;
 private PuntoEspacio puntoEspacio;
 private Double puntaje;

 public NaveSimple() {
 }

 public NaveSimple(String nombre, PuntoEspacio puntoEspacio, Double puntaje) {
  this.nombre = nombre;
  this.puntoEspacio = puntoEspacio;
  this.puntaje = puntaje;
 }

 public String getNombre() {
  return nombre;
 }

 public PuntoEspacio getPuntoEspacio() {
  return puntoEspacio;
 }

 public Double getPuntaje() {
  return puntaje;
 }

 @Override
 public void addPuntaje() {
  this.puntaje++;
 }

 @Override
 public Double calcularDistancia(PuntoEspacio puntoEspacio) {
  return this.puntoEspacio.calcularDistancia(puntoEspacio);
 }

 @Override
 public String toString() {
  return "\n  ________     " + nombre + "     ________     " + puntoEspacio +
          "\n Puntaje de la nave: " + puntaje + "\n  _________________________________  \n";
 }
}
