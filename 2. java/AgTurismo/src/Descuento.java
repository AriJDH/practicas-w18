public class Descuento {
    private double descuento;
    private String descripcion;
    private double totalDescuento;

    public Descuento(double descuento, String descripcion) {
        this.descuento = descuento;
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getTotalDescuento() {
        return totalDescuento;
    }

    public void setTotalDescuento(double totalDescuento) {
        this.totalDescuento = totalDescuento;
    }

    public static Descuento descuentoCliente(){
        return new Descuento(0.05,"Descuento 5% cliente");
    }
    public static Descuento descuentoLocalizador(){
        return new Descuento(0.1,"Descuento 10% por paquete completo");
    }
    public static Descuento descuentoDosReservas(){
        return new Descuento(0.05,"Descuento 5% por doble reserva hotel o boletos");
    }

    @Override
    public String toString() {
        return "Descuento{" +
                "descuento=" + descuento +
                ", descripcion='" + descripcion + '\'' +
                ", totalDescuento=" + totalDescuento +
                '}';
    }
}
