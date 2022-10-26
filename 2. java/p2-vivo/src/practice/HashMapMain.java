package practice;

import java.util.HashMap;
import java.util.Map;

public class HashMapMain {
    public static void main(String[] args) {
        HashMap<Integer, String> peopleMap = new HashMap<>();
        peopleMap.put(374, "Gabriel");
        peopleMap.put(932, "Nicolas");
        peopleMap.put(193, "Esteban");
        peopleMap.put(643, "Johana");
        System.out.println("People map:");
        System.out.println(peopleMap);
        System.out.println("Get one person with key:");
        System.out.println(peopleMap.get(193));
        System.out.println("Entry set:");
        System.out.println(peopleMap.entrySet());
        System.out.println("pareja?:");
        for (Map.Entry<Integer, String> pareja : peopleMap.entrySet()) {
            System.out.println(pareja.getKey());
            System.out.println(pareja.getValue());
        }

    }
}
