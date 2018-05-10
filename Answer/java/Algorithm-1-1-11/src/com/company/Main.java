package com.company;

import java.util.Random;

public class Main {
    final static Random random = new Random();

    static boolean[][] array = new boolean[10][10];

    static void showArray(boolean[][] array) {
        System.out.println("Start");
        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                if(array[i][j])
                    System.out.println("*");
                else
                    System.out.println(" ");
            }
            System.out.println("End.");
        }
    }

    public static void main(String[] args) {

        for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                array[i][j] = random.nextBoolean();
            }
        }

        showArray(array);
    }

}
