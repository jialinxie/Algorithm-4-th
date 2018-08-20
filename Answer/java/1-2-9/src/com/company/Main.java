package com.company;
import edu.princeton.cs.algs4.Count;
import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;

public class Main {
        public static int rank(int key, int[] a, Counter c)
        {   //array must be sorted

            int lo = 0;
            int hi = a.length - 1;
            while(lo <= hi) {
                c.increment();
                int mid = (hi + lo) / 2;
                if (a[mid] < key)
                    lo = mid + 1;
                else if (a[mid] > key)
                    hi = mid - 1;
                else
                    return mid;
            }
            return -1;
        }

        public static void main(String[] args) {
            Counter c1 = new Counter("searchTimes");
            int[] whitelist = {2,3,4,5,7,6,5,4,3,2,8,6,5,4,2};

            Arrays.sort(whitelist);
            rank(8, whitelist, c1);
            System.out.println("result : " + c1.toString());
        }
}
