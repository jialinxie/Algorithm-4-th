package com.company;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Main
{
    public static void main(String[] args)
    {
        int m = 3;
        int N = 6;

        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < N; i++)
            queue.enqueue(i);

        while (!queue.isEmpty()) {
            for (int i = 0; i < m - 1; i++)
                queue.enqueue(queue.dequeue());
            StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println();
    }
}