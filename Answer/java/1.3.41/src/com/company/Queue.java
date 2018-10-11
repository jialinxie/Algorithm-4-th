package com.company;

import com.sun.org.apache.bcel.internal.generic.LASTORE;

import java.util.Iterator;
import java.util.NoSuchElementException;
//范型队列
public class Queue<Item> implements Iterable<Item> {
    private Node first; //指向最早添加的节点的链接
    private Node last;  //指向最近添加的节点的链接
    private int N;

    private class Node{ //定义了节点的嵌套类
        Item item;
        Node next;
    }

    public Queue(Queue<Item> q) {
        Queue<Item> result = new Queue<Item>();

        int size = q.size();
        for(int i = 0; i < size; i++) {
            Item item= q.dequeue();
            q.enqueue(item);
            result.enqueue(item);
        }
        this.first = result.first;
        this.last = result.last;
        this.N = result.size();
    }

    public boolean isEmpty(){
        return first == null;   //N == 0
    }

    public int size(){
        return N;
    }

    public void enqueue(Item item){
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty())
            first = last;
        else
            oldlast.next = last;
        N++;
    }

    public Item dequeue(){
        Item item = first.item;
        first = first.next;
        if(isEmpty())
            last = null;
        N--;
        return item;
    }

    public Iterator<Item> iterator(){
        return new QueueIterator();
    }

    public class QueueIterator implements Iterator<Item>{
        private Item[] temp;
        private int index ;

        public QueueIterator(){
            temp = (Item[])new Object[N];
            for (int i = 0; i < N; i++) {
                temp[i] = first.item;
                first = first.next;
            }

            index = 0;
        }
        public boolean hasNext() {
            return index < N;
        }

        public Item next() {
            return temp[index++];
        }

        public void remove() {

        }
    }
//
//    public void resize(int max){
//        Item[] temp = (Item[]) new Object[max];
//        for(int i = 0; i < a.length; i++)
//            temp[i] = a[i];
//        a = temp;
//        last = last - first;
//        first = 0;
//    }
}
