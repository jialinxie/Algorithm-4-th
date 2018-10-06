package com.company;

public class Main {

    public static void main(String[] args) {
        RandomBag<String> randomBag = new RandomBag<String>();
        randomBag.add("a");
        randomBag.add("b");
        randomBag.add("c");
        randomBag.add("d");
        randomBag.add("e");
        randomBag.add("f");

        for(String str : randomBag){
            System.out.println(str);
        }
    }
}
