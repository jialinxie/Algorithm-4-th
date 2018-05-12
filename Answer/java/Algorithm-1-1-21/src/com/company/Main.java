package com.company;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Out;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.io.StringReader;
import java.text.DecimalFormat;


public class Main {
    public static void main(String[] args) {
	// write your code here

        String name = StdIn.readString();
        int a = StdIn.readInt();
        int b = StdIn.readInt();
        double c = 0.0;
        DecimalFormat df = new DecimalFormat("0.001");
        System.out.println("name" + '\t' + "int a" + '\t' + "int b" + '\t' + "a/b");
        c = a*1000/b*0.001;
        System.out.println(name + '\t' + a + '\t' + '\t' + b + '\t' + '\t' + df.format(c));
    }
}
