package com.company;

import java.util.Arrays;

/*
* 1.1.33矩阵库。编写一个Matrix库并实现以下API
*/
public class Main {

    public static void dot(double[] x, double[] y){

    }

    //矩阵与矩阵之积
    public static double[][] mult(double[][] a, double[][] b){
        int N = a.length;
        double[][] c = new double[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                for(int k = 0; k < N; k++)
                    c[i][j] = a[i][k] * b[k][j];
            }
        }

        return c;
    }

    //转置矩阵
    public static double[][] transpose(double[][] a){
        int N = a.length;       //row
        int M = a[0].length;    //col

        double[][] c = new double[M][N];

        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                c[i][j] = a[j][i];

        return c;
    }

    //矩阵和向量之积
    /*
    * 矩阵乘向量，就是把这个向量旋转，而且向量的大小也会改变，通常情况，没有人关注矩阵与一个向量的乘法，
    * 而是关注整个向量空间，乘了这个矩阵之后，会如何变化，这其实就是向量空间的线性变换，特点是保持加法，保持数乘。
    * 所以几何意义就是线性变换。
    * */
    public static double[] mult(double[][] a, double[] x){
        int N = a.length;
        int M = a[0].length;

        double[] c = new double[N];

        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                c[i] += a[i][j] * x[j];

        return c;
    }

    //向量和矩阵之积
    public static double[] mult(double[] y, double[][] a){
            int N = a.length;
            int M = a[0].length;
            double[] c = new double[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) { // Compute dot product of row i and
                    // column j.
                    c[i] += a[i][j] * y[j];
                }
            }
            return c;
    }


    public static void main(String[] args) {
	// write your code here
        double[][] a= {{20,5},{3,5},{3,3}};
        double[] b = {2, 1};

        int N = a.length;
        double[] c = mult(a,b);
        System.out.println(Arrays.toString(c));

    }
}
