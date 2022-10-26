package com.meli;

/**
 * Class where the logic of the proposed exercise is executed
 *
 * @author: Juan Pablo Agudelo Florez
 */
public class Main {
    public static void main(String[] args) {
        ArrayCities cities = new ArrayCities();
        ArrayTemperatures temperatures = new ArrayTemperatures();
        int min[] = temperatures.GetMinimumValue();
        int max[] = temperatures.GetMaximumValue();
        System.out.println("Minimum temperature: " + min[0] + " | City: " + cities.GetCity(min[1]));
        System.out.println("Maximum temperature: " + max[0] + " | City: " + cities.GetCity(max[1]));
    }
}