package com.company;

public class Main {
    public static void main(String[] args){
        ResizingArrayDeque1<String> a = new ResizingArrayDeque1<String>();
        a.pushRight("a");
        a.pushRight("b");
        a.pushRight("c");
        System.out.println("after pushRight, a:");
        for(String str : a){
            System.out.println(str);
        }
        a.pushLeft("d");
        a.pushLeft("e");
        a.pushLeft("f");
        System.out.println("after pushLeft, a:");
        for(String str : a){
            System.out.println(str);
        }

        a.popLeft();
        a.popLeft();
        a.popLeft();
        System.out.println("after popLeft, a:");
        for(String str : a){
            System.out.println(str);
        }

        a.popRight();
        a.popRight();
        System.out.println("after popRight, a:");
        for(String str : a){
            System.out.println(str);
        }

    }
}
