package com.company;

import edu.princeton.cs.introcs.StdOut;
//  doesn't konw which N is max when calculate in 1 hour

public class Main{
    public static long F(int N){
        long[] fn = new long[N+1];

        fn[0] = 0;
        fn[1] = 1;

        for(int i = 2; i <= N; i++)
            fn[i] = fn[i - 1] + fn[i - 2];

        return fn[N];
    }

    public static long Fold(int N)    {
            if (N == 0) return 0;
            if (N == 1) return 1;
            return Fold(N-1) + Fold(N-2);
    }

    public static void main(String[] args){

        long a = F(100);
        System.out.println("a = " + a);

        long b = Fold(50);
        System.out.println("b = " + b);
        return;
    }
}
