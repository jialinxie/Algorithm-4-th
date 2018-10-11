package com.company;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stack;
/*
* 1.3.19 给出一段代码，删除链表的尾结点，其中链表的首结点为first。
1.3.19 Give a code fragment that removes the last node in a linked list whose
first node is first.
*
* */
public class Main {


    public static class LinkedList<Item> {

        public static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        public Node<Item> deleteLastNode(Node<Item> first) {
            Node<Item> currentNode = first;
            Node<Item> SecondLastNode = first;

            if (first == null)
                return first;

            if (currentNode.next == null) {
                first = null;
                return first;
            }

            while (currentNode.next != null) {
                SecondLastNode = currentNode;
                currentNode = currentNode.next;
            }

            SecondLastNode.next = null;
            return first;
        }


        public static void main(String[] args) {
            // write your code here
            Node<String> first = new Node<>();
            first.item = "hello";

            Node<String> second = new Node<>();
            second.item = "hello1";

            Node<String> three = new Node<>();
            three.item = "hello2";

            Node<String> four = new Node<>();
            four.item = "hello3";

            first.next  = second;
            second.next = three;
            three.next  = four;

            LinkedList<String> linkedList = new LinkedList<String>();

            linkedList.deleteLastNode(first);
            for(Node x = first; x != null; x = x.next)
                System.out.println(x.item.toString());
        }
    }
}
