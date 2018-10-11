package com.company;

//to compute binomial(100, 50). Develop a better implementation
//        that is based on saving computed values in an array.

public class Main {

    static long c = 0;

    public static double binomial2(int N, int k, double p){
        double b[][] = new double[N + 1][k + 1];

        //base case
        for(int i = 0; i <= N; i++)
            b[i][0] = Math.pow((1.0 - p), i);

        b[0][0] = 1.0;

        //recursive case
        for(int i = 1; i <= N; i++)
            for(int j = 1; j <= k ; j++) {
                b[i][j] = (1.0 - p) * b[i - 1][j] + p * b[i - 1][j - 1];
            }

        return b[N][k];
    }

    public static double binomial(int N, int k, double p) {
        c++;

        if (N == 0 && k == 0) {
            return 1.0;
        }

        if(N < 0 || k < 0)
            return 0.0;

        return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1, k-1, p);
    }

    public static void main(String[] args) {
	// write your code here
        binomial(20, 10, 0.25);
        System.out.println("c = " + c);

        double d = binomial2(100, 50, 0.25);
        System.out.println("d = " + d);
    }
}
