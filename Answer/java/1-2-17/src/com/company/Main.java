package com.company;

/*
1.2.17 有理数实现的健壮性。在Rational（请见练习1.2.16）的开发中使用断言来防止溢出。
1.2.17 Robust implementation of rational numbers. Use assertions to develop
an implementation of Rational (see Exercise 1.2.16) that is immune to overflow.*/

public class Main{
    public static class Rational{
        private int nume;
        private int deno;

        public Rational(int numerictor, int denominator){
            int rem = gcd(numerictor, denominator);

            if(denominator == 0)
                throw new RuntimeException("denominator is Zero!");

            if(rem < 0)
                rem = -rem;

            this.nume = numerictor  / rem;
            this.deno = denominator / rem;
        }

        //return max common divisor
        public static int gcd(int m, int n){
            if(m < 0)
                m = -m;
            if(n < 0)
                n = -n;

            if(m < n){
                int temp = m;
                m = n;
                n = temp;
            }

            int rem = m % n;
            if(rem == 0)
                return n;
            return gcd(n, rem);
        }

        Rational plus(Rational that){

            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(that.deno < Integer.MAX_VALUE && that.deno > Integer.MIN_VALUE);

            int numerictor = this.nume * that.deno + that.nume * this.deno;
            int denominator = this.deno * that.deno;

            Rational rat = new Rational(numerictor, denominator);

            return rat;
        }

        Rational minus(Rational that){
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(that.deno < Integer.MAX_VALUE && that.deno > Integer.MIN_VALUE);

            int numerictor = this.nume * that.deno - that.nume * this.deno;
            int denominator  = this.deno * that.deno;

            Rational rat = new Rational(numerictor, denominator);

            return rat;

        }

        Rational times(Rational that){
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(that.deno < Integer.MAX_VALUE && that.deno > Integer.MIN_VALUE);

            int numerictor = this.nume * that.nume;
            int denominator = this.deno * that.deno;

            Rational rat = new Rational(numerictor, denominator);

            return rat;
        }

        Rational devides(Rational that){
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(that.deno < Integer.MAX_VALUE && that.deno > Integer.MIN_VALUE);

            int numerictor = this.nume * that.deno;
            int denominator = this.deno * that.nume;

            Rational rat = new Rational(numerictor, denominator);

            return rat;
        }

        public boolean equal(Rational that){
            assert(deno < Integer.MAX_VALUE && deno > Integer.MIN_VALUE);
            assert(that.deno < Integer.MAX_VALUE && that.deno > Integer.MIN_VALUE);

            if(this == that)
                return true;
            if(that == null)
                return false;
            if(this.getClass() != that.getClass())
                return false;
            return (nume == that.nume && deno == that.deno);
        }

        public String toString(){
            return this.nume + "/" + this.deno;
        }
    }

    public static void main(String[] args){
        Rational rational1 = new Rational(3,66);
        Rational rational2 = new Rational(5,6);
        Rational result1 = rational1.plus(rational2);
        Rational result2 = rational1.minus(rational2);
        Rational result3 = rational1.times(rational2);
        Rational result4 = rational1.devides(rational2);
        System.out.println("plus:"+result1);
        System.out.println("minus:"+result2);
        System.out.println("times:"+result3);
        System.out.println("devides:"+result4);
    }
}
