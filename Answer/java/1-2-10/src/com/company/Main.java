package com.company;
/*
*
* 1.2.10 编写一个类 VisualCounter，支持加一和减一操作。它的构造函数接受两个参数 N 和 max，
* 其中 N 指定了操作的最大次数， max 指定了计数器的最大绝对值。作为副作用，用图像显示每次计数器变
* 化后的值。
1.2.10 Develop a class VisualCounter that allows both increment and decrement
 operations. Take two arguments N and max in the constructor, where N specifies
  the maximum number of operations and max specifies the maximum absolute value
  for the counter. As a side effect, create a plot showing the value of the
  counter each time its tally changes.
* */

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Main {
    public static class VisualCounter {
        private int N;
        private double total;

        public VisualCounter(long N, double max) {
            StdDraw.setXscale(0, N);
            StdDraw.setYscale(-max, max);
            StdDraw.setPenRadius(.005f);
        }

        public void increment() {
            N++;
            total++;
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.point(N, total);
            return;
        }

        public void decrement() {
            N++;
            total--;
            StdDraw.setPenColor(StdDraw.DARK_GRAY);
            StdDraw.point(N, total);
            return;
        }
    }

    public static void main(String[] args){
        VisualCounter counter = new VisualCounter(6000, 300);
        for (int i = 0; i < 10000; i++)
            if (StdRandom.random() > 0.5) {
                counter.increment();
            }else {
                counter.decrement();
            }
        StdOut.println(counter);
    }
}
