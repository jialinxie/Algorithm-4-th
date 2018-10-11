package com.company;

import java.util.Iterator;

/*
*
*1.3.33 Deque。一个双向队列(或者称为deque)和栈或队列类似，但它同时支持在两端添加或删除元素。Deque能够存储一组元素并支持如下API
*编写一个使用双向链表实现这份API的Deque类。以及一个使用动态数据组调整实现这份API的ResizingArrayDeque类。
*
*1.3.33 Deque. A double-ended queue or deque (pronounced “deck”) is like a stack or a queue but supports adding
* and removing items at both ends. A deque stores a collec- tion of items and supports the following API: Write
* a class Deque that uses a doubly-linked list to implement this API and a class ResizingArrayDeque that uses
* a resizing array.
*
* */
/**
 * -----------------------------------------------------
 * public class Deque<Item> implements Iterable<Item>
 * -----------------------------------------------------
 *       Deque()
 *       boolean isEmpty()
 *       size()
 *       void pushLeft(Item e)        add an item to the left end
 *       void pushRight(Item e)       add an item to the right end
 *       Item popLeft()               remove an item from the left end
 *       Item popRight()              remove an item from the right end
 * -----------------------------------------------------
 **/
public class ResizingArrayDeque1<Item> implements Iterable<Item>{

    private Item[] a;
    private int N;

    public boolean isEmpty(){
        return N == 0;
    }

    public ResizingArrayDeque1(){
        a = (Item[]) (new Object[1]);
    }

    public int size(){
        return N;
    }

    public void pushLeft(Item item){
        Item[] temp = (Item[]) (new Object[N + 1]);
        temp[0] = item;
        for(int i = 0; i < N; i++){
            temp[i + 1] = a[i];
        }
        a = temp;
        N++;
    }

    public void resize(int max){
        Item[] temp = (Item[]) (new Object[max]);
        for(int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public void pushRight(Item item){
        if(N == a.length){
            resize(N * 2);
        }
        a[N++] = item;
    }

    public Item popLeft(){
        Item[] temp = (Item[]) (new Object[N + 1]);
        Item popedItem = a[0];
        for(int i = 0; i < N - 1; i++){
            temp[i] = a[i + 1];
        }
        a = temp;
        N --;
        return popedItem;
    }

    public Item popRight(){
        Item popedItem = a[--N];
        a[N] = null;
        if(a.length == 4 * N){
            resize(a.length / 2);
        }
        return popedItem;
    }

    public Iterator<Item> iterator(){
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item>{
        int index = 0;

        public boolean hasNext(){
            return index != N;
        }

        public Item next(){
            return a[index ++];
        }

        public void remove(){

        }
    }
}
