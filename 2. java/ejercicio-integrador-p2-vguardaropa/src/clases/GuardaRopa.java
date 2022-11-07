package clases;

import java.util.HashMap;
import java.util.List;

public class GuardaRopa {
    private HashMap<Integer, List<Prenda>> diccionario = new HashMap<Integer, List<Prenda>>();
    private int contador;

    public Integer guardarPrendas(List<Prenda> listPrendas){
        contador++;
        diccionario.put(contador,listPrendas);
        return contador;
    }

    public GuardaRopa() {
    }

    public GuardaRopa(HashMap<Integer, List<Prenda>> diccionario) {
        this.diccionario = diccionario;
    }

    @Override
    public String toString() {
        return "Guardaropa{" +
                "diccionario=" + diccionario +
                ", contador=" + contador +
                '}';
    }

    public void mostrarPrendas(){
        System.out.println(diccionario.toString());
    }

    public List<Prenda> devolverPrendas(Integer numero){
        try{
            diccionario.get(numero);
            return diccionario.get(numero);
        }catch (Exception e){
            System.out.println("No se encontro la lista ed prendas con el numero "+numero);
            return null;
        }
    }
}
