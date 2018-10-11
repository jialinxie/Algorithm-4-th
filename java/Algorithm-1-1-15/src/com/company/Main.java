package com.company;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
import java.util.Arrays;
import java.util.Random;

/*
 *  Write a static method histogram() that takes an array a[] of int values and
    an integer M as arguments and returns an array of length M whose ith entry is the num-
    ber of times the integer i appeared in the argument array. If the values in a[] are all
    between  0  and  M�1,  the  sum  of  the  values  in  the  returned  array  should  be  equal  to
    a.length.
 */
public class Main {

    public static int histogram(int[] array, int M) {
        int[] Array = new int[M];
        for (int i = 0; i < M; i++)
            Array[i] = 0;

        for (int j = 0; j < array.length; j++)
            Array[array[j]]++;


        int sum = 0;
        for (int k = 0; k < M; k++) {
            System.out.print(Array[k]);
            System.out.print(" ");
            sum += Array[k];
        }

        System.out.println("sum = " + sum + " length = " + array.length);

        return sum;
    }

    public static void main(String[] args) {
        int x = StdIn.readInt();
        int M = 10;
        int[] arr = new int[x];
        Random rand = new Random(10);

        System.out.println(x + " random number boundary with " + (M - 1) + " is ");
        for (int i = 0; i < x; i++) {
            arr[i] = rand.nextInt(M - 1);
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");

        histogram(arr, M);

    }

}