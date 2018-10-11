package com.company;

public class Main {

    static int M = 2;
    static int N = 4;

    public static int[][] reverse(int[][] A){

        return A;
    }

    public static void main(String[] args) {
	// write your code here
        int[][] A  = {
                {1,2,3,4},
                {5,6,7,8}
        };
        int[][] At = new int[N][M];

        System.out.println("A = ");

        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++) {
                At[j][i] = A[i][j];

                System.out.print(A[i][j]);
                System.out.print(' ');
            }
            System.out.println(' ');
        }
        System.out.println(" ");
        System.out.println("A' = ");
        for(int j = 0; j < N; j++){
            for(int i = 0; i < M; i++) {
                System.out.print(At[j][i]);
                System.out.print(' ');
            }

            System.out.println(' ');
        }

    }
}
