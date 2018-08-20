package com.company;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

/*
*1.2.3 编写一个Interval2D的用例，从命令行接受参数N、min和max。生成N个随机的2D间隔，其宽度和高均匀地分布在单位正方形中的min和max之间。用
* StdDraw画出它们并打印出相交的间隔对的数量以及有包含关系的间隔对数量。

1.2.3 Write an Interval2D client that takes command-line arguments N,min,and max and
generates N random 2D intervals whose width and height are uniformly distributed between
 min and max in the unit square. Draw them on StdDraw and print the number of pairs of
 intervals that intersect and the number of intervals that are contained in one another.
*
* */
public class  Main{

    public static class Interval2D {
        public Interval1D x;
        public Interval1D y;

        public Interval2D(Interval1D tx, Interval1D ty) {
            this.x = tx;
            this.y = ty;
        }

        /*
         * 包含
         */
        public boolean contains(Point2D p) {
            if (this.x.contains(p.x()) && this.y.contains(p.y())) {
                return true;
            }
            return true;
        }

        /*
         * 宽度
         * */
        public double width() {
            return x.length();
        }

        /*
         * 高度
         * */
        public double height() {
            return y.length();
        }
    }


    /***
     * 生成一个随机2D间隔，该间隔的长和宽都位于min和max之间
     * @param min
     * @param max
     * @return
     */
    public static Interval2D ramdomInterval2D(double min,double max) {
        double xMin = StdRandom.uniform(min, max);
        double xMax = StdRandom.uniform(min, max);
        double yMin = StdRandom.uniform(min, max);
        double yMax = StdRandom.uniform(min, max);

        if(xMin > xMax){
            double temp = xMax;
            xMax = xMin;
            xMin = temp;
        }

        if(yMin > yMax){
            double temp = yMax;
            yMax = yMin;
            yMin = temp;
        }

        Interval1D interval1d1 = new Interval1D(xMin, xMax);
        Interval1D interval1d2 = new Interval1D(yMin, yMax);
        Interval2D interval2d = new Interval2D(interval1d1, interval1d2);
        return interval2d;
    }

    public static void main(String[] args){
        double min = 0.3;
        double max = 0.8;
        int N = 100;
        for (int i = 0; i < N; i++) {
            Interval2D interval2d = ramdomInterval2D(min, max);
            StdDraw.rectangle(interval2d.x.min(), interval2d.y.min(), interval2d.width() / 2, interval2d.height() / 2);
        }
    }

}
