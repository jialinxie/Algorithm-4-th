package com.company;

/*
* 1.3.1 Add a method isFull() to FixedCapacityStackOfStrings*/

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Main {

    public static class FixedCapacityStackOfStrings{
        private String[] a; //stack entries
        private int N;      //size
        public FixedCapacityStackOfStrings(int cap){
            a = new String[cap];
        }
        public boolean isEmpty(){
            return N == 0;
        }

        public int size(){
            return N;
        }

        public boolean isFull(){
            return N == a.length;
        }

        public void push(String item){
            if(isFull())
                return;
            a[N++] = item;
        }
        public String pop(){
            if(isEmpty())
                return null;
            return a[--N];
        }
    }

    public static void main(String[] args) {
	// write your code here
        FixedCapacityStackOfStrings s;
        s = new FixedCapacityStackOfStrings(100);
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            if(item.compareTo("stop") == 0)
                break;
            if (!item.equals("-"))
                s.push(item);
            else
                if (!s.isEmpty())
                    StdOut.print(s.pop() + " ");
                else
                    System.out.println("isEmpty!");
        }
        System.out.println("(" + s.size() + " left on stack)");
    }
}
