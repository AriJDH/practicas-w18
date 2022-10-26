package practice;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMain {
    public static void main(String[] args) {
        List<String> listColours = new ArrayList<>();

        System.out.println("--| COLOURS:");
        listColours.add("blue");
        listColours.add("green");
        listColours.add("yellow");
        listColours.add("red");
        listColours.add("green");
        listColours.add("white");
        for (String color : listColours) {
            System.out.println(color);
        }

        System.out.println("--| COLOURS:");
        listColours.remove("green");
        listColours.remove("2");
        for (String color : listColours) {
            System.out.println(color);
        }
    }
}
