package com.company;

/*1.2.16    Rational numbers. Implement an immutable data type Rational for rational numbers
 that supports addition, subtraction, multiplication, and division.

 1.2.16 有理数。为有理数实现一个不可变数据类型Rational，支持加减乘除操作。无需测试溢出（请见练习1.2.17），
 只需使用两个long型实例变量表示分子和分母来控制溢出的可能性。使用欧几里得算法来保证分子和分母没有公因子。
 编写一个测试用例检测你实现的所有方法。
*/

public class Main{
    public static class Rational{
        private int nume;
        private int deno;

        public Rational(int numerictor, int denominator){
            int rem = gcd(numerictor, denominator);
            if(rem < 0)
                rem = -rem;

            this.nume = numerictor  / rem;
            this.deno = denominator / rem;
        }

        //return max common divisor
        public static int gcd(int m, int n){
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
            int numerictor = this.nume * that.deno + that.nume * this.deno;
            int denominator = this.deno * that.deno;

            Rational rat = new Rational(numerictor, denominator);

            return rat;
        }

        Rational minus(Rational that){
            int numerictor = this.nume * that.deno - that.nume * this.deno;
            int denominator  = this.deno * that.deno;

            Rational rat = new Rational(numerictor, denominator);

            return rat;

        }

        Rational times(Rational that){
            int numerictor = this.nume * that.nume;
            int denominator = this.deno * that.deno;

            Rational rat = new Rational(numerictor, denominator);

            return rat;
        }

        Rational devides(Rational that){
            int numerictor = this.nume * that.deno;
            int denominator = this.deno * that.nume;

            Rational rat = new Rational(numerictor, denominator);

            return rat;
        }

        public boolean equal(Rational that){
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
        Rational rational1 = new Rational(3,4);
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
