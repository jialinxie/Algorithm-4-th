package com.company;
//
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

import java.util.Arrays;

public class Main {
    public static int rank(int key, int[] a) {    //array must be sorted
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {    //key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid])
                hi = mid - 1;
            else if (key > a[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {

        //int[] whitelist = In.readInts(args[0]);
        int[] whitelist = new int[]{13,11,1,22,24,25,36,18,37,82,42,56,32};
        char dir = '-';
        Arrays.sort(whitelist);

        for (int i = 0; i < whitelist.length; i++){
            System.out.print(whitelist[i]);
            System.out.print(" ");
        }
        while (!StdIn.isEmpty()) {    //read key, print if not in whitelist.
            int key = StdIn.readInt();

                if (rank(key, whitelist) < 0){
                    if(dir == '+')
                        StdOut.println(key);
                }else {
                    if(dir == '-')
                        System.out.println(key);
                }


        }
    }
}