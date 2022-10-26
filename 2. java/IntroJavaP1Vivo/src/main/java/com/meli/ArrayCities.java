package com.meli;

/**
 * Class used to control city data
 *
 * @author: Juan Pablo Agudelo Florez
 */
public class ArrayCities {

    //City data
    private static String DATA[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};

    /**
     * Method used to return the city with respect to its index
     *
     * @return String - example: "Londres"
     */
    public String GetCity(int row) {
        return DATA[row];
    }
}
