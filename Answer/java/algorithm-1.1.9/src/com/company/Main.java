package com.company;

public class Main {

    static String t = "";

    public static String remainder(int n){

        if(n <= 1)
            t = 1 + t;
        else {
            t = (n % 2) + t;
            remainder(n/2);
        }
        return t;
    }

    public static void main(String[] args) {
	// write your code here

        String s = "";
//        int N  = 16;
//        for (int n = N; n > 0; n /= 2) {
//            System.out.println("s = " + s);
//            s = (n % 2) + s;
//        }

        s = remainder(98765);
        System.out.println("s = " + s);
    }
}
