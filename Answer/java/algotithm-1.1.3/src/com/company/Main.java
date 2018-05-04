package com.company;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] numbers = new int[3];
        Scanner input = new Scanner(System.in);
        System.out.print("Enter three integer: ");
        numbers[0] = input.nextInt();
        numbers[1] = input.nextInt();
        numbers[2] = input.nextInt();
        System.out.print("enter integers are: ");

        for(int number: numbers)
        {
            System.out.print(number + " ");
        }

        System.out.print("\n");

        if((numbers[0] == numbers[1]) && (numbers[1] == numbers[2]))
            System.out.print("three integers are equal!\n");
        else
            System.out.print("not equal!");
        //int[] whitelist = In.readInts(args[0]);
        //System.out.print(" whitelist[0] = " + whitelist[0]);
//
//        if (3 == n)
//            if((args[0] == args[1]) && (args[1] == args[2]))
//                System.out.print("equal");
//            else
//                System.out.print("not equal");
    }
}
