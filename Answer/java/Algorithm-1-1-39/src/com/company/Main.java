package com.company;

/*
*
* 1.1.39 随机匹配。编写一个使用BinarySearch 的程序，它从命令行接受一个整型参数T，并会分别针对
* N=10^3、10^4、10^5 和10^6 将以下实验运行 T 遍：生成两个大小为N 的随机6 位正整数数组并找出
* 同时存在于两个数组中的整数的数量。打印一个表格，对于每个N，给出T 次实验中该数量的平均值。
1.1.39 Random matches. Write a BinarySearch client that takes an int value T as
command-line argument and runs T trials of the following experiment for N = 103,
104, 105, and 106: generate two arrays of N randomly generated positive six-digit
int values, and find the number of values that appear in both arrays. Print a
table giving the average value of this quantity over the T trials for each value
of N.
*
* */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        System.out.println("Input T:");
        int T = StdIn.readInt();
        int sum = 0;

        System.out.println("Input pow:");
        int POW = StdIn.readInt();

        for(int i = 0; i < T; i++) {
            int[] sortedA = ramdomArray(POW);
            int[] sortedB = ramdomArray(POW);
            sum += sameNum(sortedA, sortedB);
        }

        System.out.println("average same number = " + sum * 1.0 / T);

    }

    public static int[] ramdomArray(int p) {
        int N = (int)Math.pow(10, p);
        int[] a = new int[N];

        for(int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(999999);
            //System.out.println(a[i]);
        }

        Arrays.sort(a);
        return a;
    }

    public static int sameNum(int[] a, int[] b){
        int count = 0;
        for(int i = 0; i < a.length; i++){
            if(rank(a, b[i]) != -1){
                count ++;
            }
        }

        return count;
    }

    public static int rank(int[] a, int key){
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi){
            int mid = (lo + hi) / 2;
            if (key < a[mid]){
                hi = mid - 1;
            } else if (key > a[mid]){
                lo = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;
    }
}
