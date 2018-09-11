package com.company;

import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

/*
1.3.15 编写一个Queue的用例，接受一个命令行参数k并打印出标准输入中的倒数第k个字符串（假设标准输入中至少有k个字符串）。

1.3.15 Write a Queue client that takes a command-line argument k and prints the kth from the last string
 found on standard input (assuming that standard input has k or more strings).
*/
public class Main {
    public static class Queue<Item>{
        private Item[] a;
        private int head;
        private int tail;

        public Queue(int cap){
            a = (Item[]) new Object[cap];
            head = 0;
            tail = 0;
        }

        public void resize(int max){
            Item[] temp = (Item[]) new Object[max];
            for(int i = 0; i < a.length; i++)
                temp[i] = a[i];
            a = temp;
            tail = tail - head;
            head = 0;
        }

        public void enqueue(Item x){
            if((tail - head) == a.length)
                resize(a.length * 2);
            a[tail++] = x;
        }

        public Item dequeue(){
            if(isEmpty())
                throw new NoSuchElementException("Queue underflow");

            if((tail - head) < a.length / 4)
                resize(a.length / 2);

            Item temp = a[--tail];
            a[tail] = null;
            return temp;
        }

        public boolean isEmpty(){
            return (tail-head) == 0;
        }

        public int length(){
            return tail - head;
        }
    }


    public static void main(String[] args) {
	// write your code here

        int k = StdIn.readInt();

        Queue a = new Queue<String>(k+1);

        System.out.println("K = " + k);

        while(!StdIn.isEmpty()) {
            String temp = StdIn.readString();
            if(temp.equals("="))
                break;

            a.enqueue(temp);
        }

        for(int i = 0; i < a.length(); i++) {

            if(i == (k-1))
                System.out.println(a.dequeue().toString());
            else
                a.dequeue();
        }

    }
}
