import java.util.ArrayList;
import java.util.stream.Collector;

public class Localizador {

    private ArrayList<Reserva> listaReservas;
    private Descuento descuentoCliente;
    private Descuento descuentoCompleto;

    public Localizador() {
        descuentoCompleto = null;
        descuentoCliente = null;
        listaReservas = new ArrayList<>();
    }

    public void setDescuentoCliente() {
        descuentoCliente = Descuento.descuentoCliente();
    }

    public ArrayList<Reserva> getListaReservas() {
        return listaReservas;
    }

    public void setListaReservas(ArrayList<Reserva> listaReservas) {
        this.listaReservas = listaReservas;
    }

    public double calcularTotal() {
        return getListaReservas().stream().mapToInt(Reserva::getTotal).sum();
    }
    public double calcularDescuento(){
        return 0;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                "listaReservas=" + listaReservas +
                ", descuentoCliente=" + descuentoCliente +
                ", descuentoCompleto=" + descuentoCompleto +
                '}';
    }

    public void agregarReserva(Reserva res){

//        Lo primero es agregar a la lista
        listaReservas.add(res);

//        Calculo descuento por 2 reservas mismo tipo Hotel o Transporte y aplico a la reserva
//        Obtengo valores para saber si debo aplicar el descuento de localizador.

        int hotel = 0,transporte = 0, boleto =0, comida=0;
        ArrayList<Hotel> listaHoteles = new ArrayList<>();
        ArrayList<Transporte> listaTransporte = new ArrayList<>();
        for (Reserva r:listaReservas
             ) {
            switch (r.getClass().getName()){
                case "Hotel":
                    listaHoteles.add((Hotel) r);
                    hotel+=1;
                    break;
                case "Transporte":
                    listaTransporte.add((Transporte) r);
                    transporte+=1;
                    break;
                case "Boleto":
                    boleto += 1;
                    break;
                case "Comida":
                    comida += 1;
                    break;

            }
        }
//        Descuento 2 o mas hoteles
        if (listaHoteles.size()>1){
            for (Hotel h:listaHoteles
            ) {
                h.setDescuento(Descuento.descuentoDosReservas());
            }
        }
//        Descuento 2 o mas transportes
        if (listaTransporte.size()>1){
            for (Transporte t:listaTransporte
            ) {
                t.setDescuento(Descuento.descuentoDosReservas());
            }
        }
        double total = calcularTotal();

//        Si hay por lo menos uno de cada uno, descuento por total.
        if (hotel*comida*transporte*boleto>0){
            descuentoCompleto = Descuento.descuentoLocalizador();
            descuentoCompleto.setTotalDescuento(total*descuentoCompleto.getDescuento());
        }
//        Recalculo el descuento de cliente si existe.
        if (descuentoCliente!=null)
            descuentoCliente.setTotalDescuento(total*descuentoCliente.getDescuento());

    }


}
