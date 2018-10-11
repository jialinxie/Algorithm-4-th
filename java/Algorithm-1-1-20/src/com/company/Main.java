package com.company;

import edu.princeton.cs.introcs.StdOut;

import static java.lang.Math.log;

public class Main {

        private static double lnPro(int N){
            if (N == 1) return 0;
            return log(N) + lnPro(N-1);
        }

        public static void main(String[] args){
            //int N = Integer.parseInt(args[0]);
            int N = 1024;
            double value = lnPro(N);
            StdOut.print(value);
        }
}
