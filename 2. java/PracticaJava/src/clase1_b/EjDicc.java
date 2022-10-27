package clase1_b;

import java.util.HashMap;
import java.util.Map;

public class EjDicc {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(924, "Gabriel Guerra");
        map.put(921, "Nicolas Sanchez");
        map.put(700, "Esteban Quito");
        map.put(537, "Johana Santos");
        map.put(605, "Daniel Otero");
        System.out.println("Los elemntos del dicc son : \n " + map);
        System.out.println(map.get(700));
        System.out.println("Todas las entradas del dicc extraidas con entrySet : \n " );
        System.out.println(map.entrySet());
        System.out.println("Todas las entradas del dicc extraidas una a una: \n ");
        for (Map.Entry pareja:map.entrySet()){
            System.out.println(pareja);
        }

        System.out.println("Codigo \tNombre\n--------\t------------ ");
        for(Map.Entry pareja: map.entrySet()) {
            System.out.println(pareja.getKey());
        }
    }
}


