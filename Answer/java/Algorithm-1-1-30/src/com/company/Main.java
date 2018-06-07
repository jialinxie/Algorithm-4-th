package com.company;

//1.1.30  Array exercise. Write a code fragment that creates an N-by-N boolean array a[][] such that a[i][j] is true if i
//        and j are relatively prime (have no common fac- tors), and false otherwise.

public class Main {

    //i must >= j
    static Boolean primeRelation(int i, int j){
        if(i < j) {
            i = i + j;
            j = i;
            i = i - j;
        }

        if(j == 0)
            return false;

        if(j == 1)
            return true;

        i = i % j;
        return primeRelation(j, i);
    }

    public static void main(String[] args) {
	// write your code here
        int N = 10;
        Boolean[][] a = new Boolean[N][N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < N; j++) {
                if (primeRelation(i, j))
                    a[i][j] = true;
                else
                    a[i][j] = false;
            }

        for(int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(a[i][j] + " ");

            }
            System.out.println();
        }

    }
}
