package com.company;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Stack<String> ops = new Stack<String>();
        String lastItem = new String();

        while(!StdIn.isEmpty()){
            String s = StdIn.readString();
            if(s.compareTo("stop") == 0)
                break;

            if(ops.size() == 0)
               lastItem = " ";

            if(s.equals("(") || s.equals("{") || s.equals("[")) {
                ops.push(s);
                System.out.println("push");
                lastItem = s;
            }
            else
                if(s.equals(")")) {
                    if (lastItem.equals("(")) {
                        ops.pop();
                        if(ops.size() > 0) {
                            lastItem = ops.pop();
                            ops.push(lastItem);
                        }
                    }else {
                        System.out.println("false");
                        return;
                    }
                }
            else
                if(s.equals("}")) {
                    if (lastItem.equals("{")) {
                        ops.pop();
                        if(ops.size() > 0) {
                            lastItem = ops.pop();
                            ops.push(lastItem);
                        }
                    }else {
                        System.out.println("false");
                        return;
                    }
                }
            else
                if(s.equals("]")) {
                    if (lastItem.equals("[")) {
                        ops.pop();
                        if(ops.size() > 0){
                            lastItem = ops.pop();
                            ops.push(lastItem);
                        }
                    }else {
                        System.out.println("false");
                        return;
                    }
                }
        }
        if(ops.isEmpty())
            System.out.println("true");
        else
            System.out.println("false");
        return;
    }
}
