package com.company;

import static java.lang.Math.abs;

//1.1.24  Give the sequence of values of p and q that are computed when Euclid’s
//        algo- rithm is used to compute the greatest common divisor of 105 and 24.
//        Extend the code given on page 4 to develop a program  Euclid that takes
//        two integers from the command line and computes their greatest common divisor,
//        printing out the two arguments for each call on the recursive method.
//        Use your program to compute the greatest common divisor or 1111111 and 1234567.

public class Main {
//
//    public static long euclid(long a, long b){
//        if((a < 0) || (b < 0))
//            return -1;
//
//        if(b > a) { //sort a and b. make a >= b
//            long c = b;
//            b = a;
//            a = c;
//        }
//
//        if(b == 0)
//            return a;
//
//        a -= b;
//
//        System.out.println("a = " + a + "  b = " + b);
//
//        return euclid(a,b);
//    }

    public static long euclid(long a, long b){
        if((a < 0) || (b < 0))
            return -1;

        if(b == 0)
            return a;

        return euclid(b,a % b);
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println("euclid return = [" + euclid(105,24) + "]");
    }
}
