package com.company;

import java.util.Arrays;
//
//1.1.22  Write a version of BinarySearch that uses the recursive rank() given on
//        page 25 and traces the method calls. Each time the recursive method is called,
//        print the argu- ment values lo and hi, indented by the depth of the recursion.
//        Hint: Add an argument to the recursive method that keeps track of the depth.

public class Main {

    public static int rank(int key, int[] a){
        return rank(key, a, 0, a.length - 1, 0);
    }

    public static int rank(int key, int[] a, int lo, int hi, int count)
    {   //array must be sorted
        //static int count = 0;

        int mid = lo + ((hi - lo + 1)) / 2;
        if(lo <= hi){
            count ++;
            for(int i = 0; i < count; i++)
                System.out.print(' ');
            System.out.println("lo = " + lo + " hi = " + hi);

            if(key < a[mid]){
                hi = mid - 1;
                return rank(key, a, lo, hi, count);
            }else
                if(key > a[mid]){
                    lo = mid + 1;
                    return rank(key, a, lo, hi, count);
                }else
                    return mid;
        }else
            return -1;
    }

    public static void main(String[] args) {
	// write your code here
        int[] array = {2,3,4,5,7,6,5,4,3,2,8,6,5,4,2,21,23,34,32,54,45,65,34,233,234,2,123,453};

//        for(int i = 0; i < array.length; i++)
//            System.out.print(array[i]);
//        System.out.println(' ');
        Arrays.sort(array);
//        for(int i = 0; i < array.length; i++)
//            System.out.print(array[i]);

        int a = rank(21, array);
        System.out.println("result = " + a);
    }
}
