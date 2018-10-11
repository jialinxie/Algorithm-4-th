package com.company;

import java.util.NoSuchElementException;

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

        private void resize(int max){
            Item[] temp = (Item[]) new Object[max];
            for(int i = 0; i < head - tail; i++)
                temp[i] = a[i];
            a = temp;
            tail = tail - head;
            head = 0;
        }

        public void enqueue(Item x){
            if(tail - head == a.length)
                resize(2 * (tail - head));

            a[tail++] = x;
        }

        public boolean isEmpty(){
            return tail - head == 0;
        }

        public Item dequeue(){
            if(isEmpty())
                throw new NoSuchElementException("Queue underflow");

            if(tail - head == a.length / 4)
                resize(a.length / 2);

            Item hd = a[head];
            a[head ++] = null;
            return hd;
        }
    }

    public static void main(String[] args) {
	// write your code here
        Queue a = new Queue<Integer>(10);
        a.enqueue(1);
        a.enqueue(2);
        a.enqueue(3);
        a.enqueue(4);
        a.enqueue(5);
        a.enqueue(6);
        a.enqueue(7);
        a.enqueue(8);
        a.enqueue(9);
        a.enqueue(10);
        a.enqueue(11);
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
        a.dequeue();
    }
}
