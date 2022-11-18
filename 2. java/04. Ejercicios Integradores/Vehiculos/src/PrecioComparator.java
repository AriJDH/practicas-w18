import vehiculos.Vehiculo;

import java.util.Comparator;

public class PrecioComparator implements Comparator<Vehiculo> {
    @Override
    public int compare(Vehiculo o1, Vehiculo o2) {
        return Double.compare(o1.getPrecio(), o2.getPrecio());
    }

}
