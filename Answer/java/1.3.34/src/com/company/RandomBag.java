package com.company;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomBag<Item> implements Iterable<Item> {
    private Item[] a = (Item[]) new Object[1];
    private int N = 0;

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N;
    }

    public void add(Item x){
        if(N == a.length)
            resize(2 * a.length);

        a[N ++] = x;
    }

    private void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0; i < N; i++){
            temp[i] = a[i];
        }
        a = temp;
    }

    public Iterator<Item> iterator(){
        return new RandomBagIterator();
    }

    private class RandomBagIterator implements Iterator<Item>{
        private int[] seq = new int[N];
        private int index = 0;

        public RandomBagIterator(){
            for(int i = 0; i < seq.length; i++)
                seq[i] = i;
            StdRandom.shuffle(seq);
        }

        public boolean hasNext(){
            return index < N;
        }

        public Item next(){
            return a[seq[index++]];
        }

        public void remove(){

        }
    }
}