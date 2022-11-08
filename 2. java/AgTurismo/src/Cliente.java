import java.util.ArrayList;

public class Cliente {
    private ArrayList<Localizador> listaLocalizadores = new ArrayList<Localizador>();
    private int id;
    private String Nombre;

    public Cliente(int id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }

    public Cliente(ArrayList<Localizador> listaLocalizadores, int id, String nombre) {
        this.listaLocalizadores = listaLocalizadores;
        this.id = id;
        Nombre = nombre;
    }

    public ArrayList<Localizador> getListaLocalizadores() {
        return listaLocalizadores;
    }

    public void setListaLocalizadores(ArrayList<Localizador> listaLocalizadores) {
        this.listaLocalizadores = listaLocalizadores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int descuento(){
        return 0;
    }

    public void agregarLocalizador(Localizador l){
        if (listaLocalizadores.size()>2){
            l.setDescuentoCliente();
        }
        listaLocalizadores.add(l);
    }

    @Override
    public String toString() {
        String retorno= "Cliente id=" + id +" Nombre='" + Nombre + '\n' ;
        for (Localizador l: listaLocalizadores
             ) {
            retorno+= "Localizador "+l.toString() +"\n";
        }
        return retorno;
    }
}
