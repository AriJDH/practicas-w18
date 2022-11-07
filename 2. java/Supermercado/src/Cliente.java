import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cliente implements Icrud<Cliente>{
    int dni;
    String nombreyApe;

    public Cliente(int dni, String nombreyApe) {
        this.dni = dni;
        this.nombreyApe = nombreyApe;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreyApe() {
        return nombreyApe;
    }

    public void setNombreyApe(String nombreyApe) {
        this.nombreyApe = nombreyApe;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "dni=" + dni +
                ", nombreyApe='" + nombreyApe + '\'' +
                '}';
    }

    public void eliminarCliente(Cliente o,List<Cliente> list) {

        List<Cliente> aux = new ArrayList<Cliente>();
        aux.addAll(list);


        for(Cliente c: aux){
            if(c.dni == o.getDni())
                list.remove(c);
        }
    }


    public void crearCliente(Cliente o, List<Cliente> list) {

        list.add(o);

    }


    public void actualizarCliente(Cliente o,List<Cliente> list) {
        List<Cliente> aux = new ArrayList<Cliente>();
        aux.addAll(list);

        for(Cliente c: aux){
            if(c.dni == o.getDni())
                c.setNombreyApe(o.getNombreyApe());
        }
    }

  /*  public void buscarCliente(int dni, List<Cliente> clientes){
        int band =0;
        for(Cliente c: clientes){
            if(c.dni == dni){
                band=1;
                System.out.println(c.toString());
            }
        }
        if(band ==0)
            System.out.println("No existe un cliente con el dni ingresado");
    }*/

    @Override
    public void guardar(Cliente obj, List<Cliente> lista) {
       lista.add(obj);
    }

    public Cliente(){}
    @Override
    public void borrar(Cliente obj,List<Cliente> lista ) {
        List<Cliente> aux = new ArrayList<Cliente>();
        aux.addAll(lista);
        for(int i=0; i< aux.size(); i++){
            if(aux.get(i).dni == obj.getDni())
                lista.remove(aux.get(i));
        }

    }

    @Override
    public boolean buscar(int id, List<Cliente> lista ) {
        int band =0;
        for(Cliente c: lista){
            if(c.dni == id){
                band=1;
                System.out.println(c.toString());
                return true;
            }
        }
        if(band ==0)
            System.out.println("No existe un cliente con el dni ingresado");
        return false;
    }

    public Cliente clienteBydni(int dni, List<Cliente> clientes) {
        Cliente cli = new Cliente();
        for (Cliente c : clientes) {
            if (c.dni == dni) {
                return c;
            }
        }
        return cli;
    }

}
