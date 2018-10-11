package com.company;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;

import java.util.Arrays;
import java.util.Random;

/*
1.1.32 直方图。假设标准输入流中含有一系列 double 值。编写一段程序，从命令行接受一个整数 N 和 两个 double 值 l 和 r,
将 (l，r) 分为 N 段并使用 StdDraw 画出输入流中的值落入每段的数量的直方图。

1.1.32 Histogram. Suppose that the standard input stream is a sequence of double values.
Write a program that takes an integer N and two double values l and r from the command
line and uses StdDraw to plot a histogram of the count of the numbers in the standard
input stream that fall in each of the N intervals defined by dividing (l , r) into N equal-sized intervals.
*/
public class Main{
    public static void main(String[] args){
        double[] a = {1.12, 1.22, 5.666, 9.0908, 8.902, 3.892, 10.782, 10.9, 10.19, 10.29, 20.1};
        int N = 10;
        double l = 1.0, r = 21.0;

        double tempInterval = (r - l) / N;  //柱状图组距
        double graphWidth = 1 * 1.0 / N;    //柱状图宽度

        for(int i = 0; i < N; i++){
            //每组数据的左值和右值
            double tempLeft =   l + tempInterval * i;
            double tempRight =  l + tempInterval * (i + 1);

            //每组数据的左值对应到直方图的左值
            double templeftGraph = graphWidth * i;

            int count = 0;
            for(int j = 0; j < a.length; j++){
                if(a[j] > tempLeft && a[j] < tempRight)
                    count ++;
            }

            //每组数据的频率
            double height = count * 1.0 / N * 2;

            StdDraw.filledRectangle(templeftGraph, height, graphWidth, height);
        }


    }
}