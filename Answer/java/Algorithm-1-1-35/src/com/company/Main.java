package com.company;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import edu.princeton.cs.algs4.StdRandom;

public class Main {

/*
    1.1.35 模拟掷骰子。以下代码能够计算每种两个骰子之和的准确概率分布：

    int SIDES = 6;
    double[] dist = new double[2 * SIDES + 1];
    for(int i = 1; i <= SIDES; i++)
            for(int j = 1; j <= SIDES; j++)
                dist[i+j] += 1.0;
    for (int k = 2; k <= 2*SIDES; k++)
        dist[k] /= 36.0;
    dist[i] 的值就是两个骰子之和为i 的概率。用实验模拟N 次掷骰子，并在计算
    两个1 到 6 之间的随机整数之和时记录每个值的出现频率以验证它们的概率。
    N 要多大才能够保证你的经验数据和准确数据的吻合程度达到小数点后三位？

    1.1.35 Dice simulation. The following code computes the exact probability distribution for the sum of two dice:

    int SIDES = 6;
    double[] dist = new double[2*SIDES+1];
    for (int i = 1; i <= SIDES; i++)
        for (int j = 1; j <= SIDES; j++)
            dist[i+j] += 1.0;
    for (int k = 2; k <= 2*SIDES; k++)
        dist[k] /= 36.0;
    The value dist[i] is the probability that the dice sum to k. Run experiments to validate this calculation
    simulating N dice throws, keeping track of the frequencies of occurrence of each value when you compute
    the sum of two random integers between 1 and 6. How large does N have to be before your empirical results
    match the exact results to three decimal places?
*/
    static int SIDES = 6;

    public static double[] getTheoryValue(){
        double[] dist = new double[2 * SIDES + 1];
        for(int i = 1; i <= SIDES; i++)
            for(int j =  1; j <= SIDES; j ++)
                dist[i + j] += 1.0;

        for(int i = 2; i <= SIDES * 2; i ++) {
            dist[i] /= 36;
            //System.out.println("a1[i = " + i + "]: " + dist[i]);
        }
        return dist;
    }

    public static double[] getImplementValue(long N){
        double[] dist = new double[2 * SIDES + 1];
        System.out.println("getImplementValue N = " + N);

        for(int i = 1; i <= N; i++) {
            int b1 = StdRandom.uniform(1, 7);    //input: [a,b)
            int b2 = StdRandom.uniform(1, 7);
            dist[b1 + b2] += 1.0;
        }

        for(int i = 2; i <= SIDES * 2; i++) {
            dist[i] /= Math.pow(N, 2);
            //System.out.println("a2[" + i + "] = " + dist[i]);
        }

        return dist;
    }

    public static boolean isMatch(double[] dist0, double[] dist1){
        for(int i = 2; i <= 12; i++)
            if(Math.abs(dist0[i] - dist1[i]) > 0.001)
                return false;
        System.out.println("< 0.001!!!!!!");
        return true;
    }

    public static long getMinN(long N){
        double[] a1 = new double[SIDES * 2 + 1];
        double[] a2 = new double[SIDES * 2 + 1];

        a1 = getTheoryValue();
        a2 = getImplementValue(N);

        while(!isMatch(a1, a2)){
            N *= 10;
            a2 = getImplementValue(N);
        }
        return N;
    }

    public static void main(String[] args) {
	// write your code here

        System.out.println("next line is answer of N:");
        long N = getMinN(1000000);
        System.out.println("N = " + N);
    }
}
