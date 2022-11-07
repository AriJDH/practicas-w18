import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Item implements Icrud<Item>{
    int codigo;
    String Nombre;
    int cantidad;
    double costoUnitario;

    public Item(int codigo, String nombre, int cantidad, double costoUnitario) {
        this.codigo = codigo;
        Nombre = nombre;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(double costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    @Override
    public String toString() {
        return "Item{" +
                "codigo=" + codigo +
                ", Nombre='" + Nombre + '\'' +
                ", cantidad=" + cantidad +
                ", costoUnitario=" + costoUnitario +
                '}';
    }

    @Override
    public void guardar(Item obj, List<Item> lista) {
        lista.add(obj);
    }

    @Override
    public void borrar(Item obj, List<Item> lista) {
        List<Item> aux = new ArrayList<Item>();
        aux.addAll(lista);
        for(int i=0; i< aux.size(); i++){
            if(aux.get(i).codigo == obj.getCodigo())
                lista.remove(aux.get(i));
        }
    }

    @Override
    public boolean buscar(int id, List<Item> lista) {
        int band =0;
        for(Item c: lista){
            if(c.codigo == id){
                band=1;
                System.out.println(c.toString());
                return true;
            }
        }
        if(band ==0)
            System.out.println("No existe un item con el còdigo ingresado");
        return false;

    }

    public double calcularTotal(List<Item> items){
        double total = 0;
        if(!items.isEmpty()){
            for(Item i: items){
                total+= i.cantidad*i.costoUnitario;
            }
        }
        return total;
    }
}
