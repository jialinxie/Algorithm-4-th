package com.company;

import java.util.Iterator;
//1.3.40    Move-to-front. Read in a sequence of characters from standard input and
//        maintain the characters in a linked list with no duplicates. When you read
//        in a previ- ously unseen character, insert it at the front of the list.
//        When you read in a duplicate character, delete it from the list and reinsert
//        it at the beginning. Name your program MoveToFront: it implements the well-known
//        move-to-front strategy, which is useful for caching, data compression, and many
//        other applications where items that have been recently accessed are more likely
//        to be reaccessed.

import edu.princeton.cs.algs4.StdIn;

public class Main {

    public static void main(String[] args) {
        MoveToFront a = new MoveToFront();

        a.MoveToFront();
    }
}
