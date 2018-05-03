package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //a
        double t = 9.0;
        while (Math.abs(t - 9.0/t) > .001)
            t = (9.0/t + t) / 2.0;

        System.out.print("t = " + t);

        //b
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < i; j++)
                sum ++;
        System.out.print("sum = " + sum);
    }
}
