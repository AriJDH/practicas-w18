package meli.bootcamp.clases;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Consultas {
    private ArrayList<Cliente> clientes;

    public Consultas() {
        clientes = new ArrayList<>();
    }

    public void addCliente(Cliente c)
    {
        clientes.add(c);
    }
    public int getCantidadLocalizadores(){
        int ctdTotal = 0;
        for (Cliente c :
                clientes) {
            ctdTotal += c.getLocalizadores().size();
        }
        return ctdTotal;
    }

    public int getCantitadReservas(){
        int ctdTotal = 0;
        for (Cliente c :
                clientes) {
            for (Localizador l :
                    c.getLocalizadores()) {
                ctdTotal += l.getReserva().size();
            }
        }
        return ctdTotal;
    }
    /*
    public Map<String, Reserva> getDiccionario()
    {
        Map<String, ArrayList<Reserva>> diccionario = new HashMap<>();
        for (Cliente c :
                clientes) {
            for (Localizador l :
                    c.getLocalizadores()) {

            }
        }
    }

     */
    public double getTotalVentas()
    {
        double ventasTotal = 0;
        for (Cliente c :
                clientes) {
            for (Localizador l :
                    c.getLocalizadores()) {
                ventasTotal += l.getPrecio();
            }
        }
        return ventasTotal;
    }

    public double getPromedioVentas()
    {
        return this.getTotalVentas() / this.getCantidadLocalizadores();
    }
}
