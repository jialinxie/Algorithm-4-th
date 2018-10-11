package com.company;

import edu.princeton.cs.algs4.StdIn;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.lang.String;
public class Main {
    public static class ResizingArrayStack<Item> implements Iterable<Item>{
        private Item[] a = (Item[]) new Object[1];
        private int N = 0;
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

        public Iterator<Item> iterator(){
            return new ReverseArrayIterator();
        }

        private class ReverseArrayIterator implements Iterator<Item>{
            private int i = N;
            public boolean hasNext()    {   return i > 0;   }
            public Item     next()      {   return a[--i];  }
            public void     remove()    {                   }
        }
    }

    public static void main(String[] args) {
	// write your code here
        ResizingArrayStack<String> ops = new ResizingArrayStack<String>();
        ResizingArrayStack<String> vals = new ResizingArrayStack<String>();

        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.compareTo("=") == 0)
                break;

            //check full, then push
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
                ops.push(s);
            else
                if(s.equals(")")){
                    String numA = vals.pop();
                    String sign = ops.pop();
                    String numB = vals.pop();

                    vals.push(numB + numA + sign")");
                }else
                    vals.push(s);

        }

        for(String node : vals)
            System.out.println(node);
    }

}
