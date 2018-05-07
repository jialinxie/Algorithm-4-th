package com.company;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;
public class Main {

    public static int mystery(int a, int b) {
        if (b == 0)     return 0;
        if (b % 2 == 0) return mystery(a+a, b/2);
        return mystery(a+a, b/2) + a;
    }

    public static int mystery1(int a, int b) {
        if (b == 0)     return 1;
        if (b % 2 == 0) return mystery(a*a, b/2);
        return mystery(a*a, b/2) * a;
    }

    public static void main(String[] args) {
	// write your code here
    while(true) {
        System.out.println(mystery1(StdIn.readInt(), StdIn.readInt()));
    }

    }
}
