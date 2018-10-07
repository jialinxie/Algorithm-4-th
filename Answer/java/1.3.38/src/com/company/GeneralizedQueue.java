package com.company;

//1.3.38 删除第 k 个元素,实现一个类并支持下表的 API：
//
//        函数	描述
//        GeneralizeQueue()	    创建一条空队列。
//        bool isEmpty()	    队列是否为空。
//        void Insert(Item x)	添加一个元素。
//        Item delete(int k)	删除并返回最早插入的第 k 个元素。
//        首先用数组实现该数据类型,然后用链表实现该数据类型。

import java.util.Iterator;

public class GeneralizedQueue<Item> implements Iterable<Item> {

    private Item[] a;
    private int N;

    public GeneralizedQueue(){
        N = 0;
        a = (Item[]) new Object[1];
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public void insert(Item x){
        if (N == a.length) {
            resize(N * 2);
        }
        a[N++] = x;
    }

    public Item delete(int k){
        if (k > N || k < 0) {
            return null;
        }

        if (N == a.length / 4) {
            resize(a.length / 2);
        }
        Item target = a[k];
        Item[] temp = (Item[])(new Object[N]);
        for (int i = 0; i < N; i++) {
            if (i < k) {
                temp[i] = a[i];
            }else {
                temp[i] = a[ i+ 1];
            }

        }
        a = temp;
        a[--N] = null;
        return target;
    }

    private void resize(int max){
        Item[] temp = (Item[])(new Object[max]);
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    public Iterator<Item> iterator() {
        return new GeneralizedQueueIterator();
    }

    public class GeneralizedQueueIterator implements Iterator<Item>{

        private Item[] temp;
        private int index ;

        public GeneralizedQueueIterator(){
            temp = (Item[])new Object[N];
            for (int i = 0; i < N; i++)
                temp[i] = a[i];

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
}