package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        double[] numbers = new double[2];
        Scanner input = new Scanner(System.in);

        numbers[0] = input.nextDouble();
        numbers[1] = input.nextDouble();

        if((numbers[0] > 0.0) && (numbers[0] < 1.0))
            if((numbers[1] > 0.0) && (numbers[1] < 1.0)) {
                System.out.print("True\n");
                return;
            }
            System.out.print("False\n");

    }
}
