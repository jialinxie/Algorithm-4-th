package com.company;

import edu.princeton.cs.algs4.In;

public class Main {

    public static void main(String[] args) {
        RandomQueue<Integer> queue = new RandomQueue<Integer>();

        for(int i = 1; i < 52; i++)
            queue.enqueue(i);

        for(Object object : queue){
            System.out.println(object);
        }
    }
}