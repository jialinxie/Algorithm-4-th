package com.company;

import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String string1 = "hello";
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1);
        StdOut.println(string2);
    }
}
