package com.company;

import java.util.Iterator;

public class Main {
    public static class Stack<Item> implements Iterable<Item>{
        private Item[] a = (Item[]) new Object[1];
        private int N = 0;
        public Stack(int cap){
            a = (Item[]) new Object[cap];
        }
        public boolean isEmpty()    {   return N == 0;  }
        public int size()           {   return N;       }
        private void resize(int max){
            if(max < 1)
                return;
            Item[] temp = (Item[]) new Object[max];
            for(int i = 0; i < N; i++)
                temp[i] = a[i];
            a = temp;
        }

        public void push(Item item){
            if(N == a.length)
                resize(N * 2);

            a[N++] = item;
        }

        public Item pop(){
            Item temp = a[--N];
            a[N] = null;

            if(N > 0 && N == a.length / 4)
                resize(N / 2);

            return temp;
        }

        public StackIterator iterator(){
            return new StackIterator();
        }

        private class StackIterator implements Iterator<Item>{
            private int i = N;
            public boolean hasNext()    {   return i > 0;   }
            public Item     next()      {   return a[--i];  }
            public void     remove()    {                   }
        }

        public static Stack<String> copy(Stack<String> x){
            Stack<String> xx = new Stack<String>(1);
            Stack<String> yy = new Stack<String>(1);

            Stack<String>.StackIterator xit = x.iterator();

            while(xit.hasNext())
                xx.push(xit.next());

            Stack<String>.StackIterator xxit = xx.iterator();
            while(xxit.hasNext())
                yy.push(xxit.next());

            return yy;
        }
    }

        public static void main(String[] args) {

        Stack<String> in = new Stack<String>(1);
        in.push("1");
        in.push("2");
        in.push("3");

        Stack<String> output = new Stack<String>(1);
        output = Stack.copy(in);
        for(String node:output)
            System.out.println(node);
    }
}
