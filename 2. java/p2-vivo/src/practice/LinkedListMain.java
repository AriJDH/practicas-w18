package practice;

import java.util.LinkedList;

public class LinkedListMain {
    public static void print(LinkedList<String> list) {
        for (String element : list) {
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        LinkedList<String> elementList = new LinkedList<>();
        elementList.add("Fire");
        elementList.add("Water");
        elementList.add("Earth");
        elementList.add("Air");

        System.out.println("List of elements:");
        print(elementList);

    }
}
