package GuardaRopa;

import java.util.HashMap;
import java.util.List;

public class Guardarropa {

        private HashMap<Integer, List<Prenda>> diccionario = new HashMap<Integer, List<Prenda>>();
        private int contador;

        public Integer guardarPrendas(List<Prenda> listaDePrendas){
            contador++;
            diccionario.put(contador, listaDePrendas);
            return contador;
        }

        public Guardarropa() {
        }

        public Guardarropa(HashMap<Integer, List<Prenda>> diccionario) {
            this.diccionario = diccionario;
        }

        @Override
        public String toString() {
            return "GuardaRopa{" +
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
                System.out.println("No se encontro la lista con el numero");
                return null;
            }
        }
}

