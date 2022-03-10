package com.company;

public class Main {

    public static void main(String[] args) {
        String[] cities = {"Londres", "Madrid", "Nova York", "Buenos Aires", "Asuncion", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        Integer[][] temperatures = { {-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        String minCity = "";
        int minTemp = Integer.MAX_VALUE;

        String maxCity = "";
        int maxTemp = Integer.MIN_VALUE;

        for(int i = 0; i < 10; i++) {
            if(minTemp > temperatures[i][0]) {
                minTemp = temperatures[i][0];
                minCity = cities[i];
            }

            if(maxTemp < temperatures[i][1]) {
                maxTemp = temperatures[i][1];
                maxCity = cities[i];
            }
        }

        System.out.println("A cidade com a menor temperatura é "  + minCity + " com " + minTemp + " graus celsius.");
        System.out.println("A cidade com a maior temperatura é " + maxCity+ " com " + maxTemp + " graus celsius.");


    }
}
