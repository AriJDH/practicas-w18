import java.util.ArrayList;

public abstract class Reserva {
     private int total;
     private String nombre;
     private String fechaInicio;
     private String fechaFin;
     private Descuento descuento;

     public Descuento getDescuento() {
          return descuento;
     }

     public void setDescuento(Descuento descuento) {
          this.descuento = descuento;
          descuento.setTotalDescuento(total * descuento.getDescuento());
     }

     public Reserva(int total, String nombre, String fechaInicio, String fechaFin) {
          this.total = total;
          this.nombre = nombre;
          this.fechaInicio = fechaInicio;
          this.fechaFin = fechaFin;
     }

     public int getTotal() {
          return total;
     }

     public void setTotal(int total) {
          this.total = total;
     }

     public String getNombre() {
          return nombre;
     }

     public void setNombre(String nombre) {
          this.nombre = nombre;
     }

     public String getFechaInicio() {
          return fechaInicio;
     }

     public void setFechaInicio(String fechaInicio) {
          this.fechaInicio = fechaInicio;
     }

     public String getFechaFin() {
          return fechaFin;
     }

     public void setFechaFin(String fechaFin) {
          this.fechaFin = fechaFin;
     }

     @Override
     public String toString() {
          return " \n \t Reserva{" +
                  "total=" + total +
                  ", nombre='" + nombre + '\'' +
                  ", fechaInicio='" + fechaInicio + '\'' +
                  ", fechaFin='" + fechaFin + '\'' +
                  ", descuento=" + descuento +
                  '}';
     }

}
