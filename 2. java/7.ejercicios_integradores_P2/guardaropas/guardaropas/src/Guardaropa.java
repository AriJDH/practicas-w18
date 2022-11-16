import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Guardaropa {
    Integer id;
    HashMap<Integer, List<Prenda>> diccionario;

    public Guardaropa() {
    }

    public Guardaropa(Integer id, HashMap<Integer, List<Prenda>> diccionario) {
        this.id = id;
        this.diccionario = diccionario;
    }


   /* - Crear el método public Integer guardarPrendas(List<Prenda> listaDePrenda),
    en la Clase GuardaRopa, que recibe una lista de prendas y devuelve el número identificador
    en donde quedaron asignadas las prendas, es decir la clave del diccionario en donde guardamos las mismas.*/

    public Integer guardarPrendas(List<Prenda> listaDePrendas){
        Integer key = getId()+1;
        diccionario.put(key, listaDePrendas);


        return key;
    }

    /*- Crear el método public void mostrarPrendas() en la Clase GuardaRopa que imprime por pantalla
  todas las prendas que quedan en el guardarropas junto con el número que les corresponde.*/

    public void mostrarPrendas(){
        for (Integer i : diccionario.keySet()) {
            System.out.println("key: " + i + " value: " + diccionario.get(i));
        }
    }
    /*- Crear el método public List<Prenda> devolverPrendas(Integer numero),
  en la Clase GuardaRopa que devuelve la lista de prendas que están guardadas bajo ese número.*/

    public List<Prenda> devolverPrenda(Integer numero){
        List<Prenda> prendasEncontradas = diccionario.get(numero);

        return prendasEncontradas;
    }




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public HashMap<Integer, List<Prenda>> getDiccionario() {
        return diccionario;
    }

    public void setDiccionario(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }
}
