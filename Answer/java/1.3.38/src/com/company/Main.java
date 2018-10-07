package com.company;

public class Main {
    public static void main(String[] args) {
        GeneralizedQueue<Integer> a = new GeneralizedQueue<Integer>();
        a.insert(1);
        a.insert(2);
        a.insert(3);
        a.insert(4);
        a.insert(5);

        for(int temp : a)
            System.out.println(temp);

        int k  = 3;
        a.delete(k);
        System.out.println("after delete K = " + k);
        for(int temp : a)
            System.out.println(temp);
    }
}
