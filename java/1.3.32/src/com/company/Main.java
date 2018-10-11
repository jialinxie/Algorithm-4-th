package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        Steque<String> s = new Steque<String>();
        s.enqueue("a");
        s.enqueue("b");
        s.enqueue("c");
        System.out.println("steque is :");
        Iterator<String> it = s.iterator();
        while(it.hasNext())
            System.out.println(((Iterator) it).next());

        s.push("d");
        System.out.println("after push d, steque is :");
        Iterator<String> ita = s.iterator();
        while(ita.hasNext())
            System.out.println(((Iterator) ita).next());

        String ret = s.pop();
        System.out.println("after pop, steque is :");
        Iterator<String> itb = s.iterator();
        while(itb.hasNext())
            System.out.println(((Iterator) itb).next());
    }

}
