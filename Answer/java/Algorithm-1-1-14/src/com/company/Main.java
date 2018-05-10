package com.company;

public class Main {
    public static int sum = 0;

    public static int lg(int n){

        if(n == 0){
            sum = -1;
            return sum;
        }

        if(n == 1)
            return 0;
        else{
            sum++;
            lg(n / 2);
            return sum;
        }
    }

    public static void main(String[] args) {
	// write your code here
        //int a =
        lg(1025);
        System.out.println("the max lgn = " + sum);

        return;
    }
}
