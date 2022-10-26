package com.meli;

/**
 * Class used to control temperature data
 *
 * @author: Juan Pablo Agudelo Florez
 */
public class ArrayTemperatures {

    //Temperatures data
    private static int DATA[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};
    //Number of rows
    private static int ROWS = 10;
    //Number of columns
    private static int COLUMNS = 2;

    /**
     * Method used to return the minimum temperature and its corresponding row in the vector
     *
     * @return int[2] - example: [minimum_temperature , row_minimum_temperature]
     */
    public int[] GetMinimumValue() {
        int response[] = {DATA[0][0], 0};
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (DATA[i][j] < response[0]) {
                    response[0] = DATA[i][j];
                    response[1] = i;
                }
            }
        }
        return response;
    }

    /**
     * Method used to return the maximum temperature and its corresponding row in the vector
     *
     * @return int[2] - example: [maximum_temperature , row_maximum_temperature]
     */
    public int[] GetMaximumValue() {
        int response[] = {DATA[0][0], 0};
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if (DATA[i][j] > response[0]) {
                    response[0] = DATA[i][j];
                    response[1] = i;
                }
            }
        }
        return response;
    }
}
