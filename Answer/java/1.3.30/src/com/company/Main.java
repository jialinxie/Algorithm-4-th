package com.company;
//1.3.30 编写一个函数，接受一条链表的首结点作为参数，（破坏性地）将链表反转并返回结果链表的首结点。

//1.3.30 Write a function that takes the first Node in a linked list as argument and (de- structively)
//        reverses the list, returning the first Node in the result.

/*
我们需要一直保持first指向原链表中所有剩余节点的首节点，second指向原链表中所有剩余结点的第二个结点，reverse指向结果链表中的首节点
*/
public class Main {

    public static class LinkedList<Item> {

        public static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        public Node reverse(Node x){
            Node first = x;
            Node reverse = null;
            while(first != null){
                Node second = first.next;
                first.next = reverse;
                reverse = first;
                first = second;
            }
            return reverse;
        }

        public static void main(String[] args) {
            // write your code here
            Node<String> first = new Node<>();
            first.item = "To";

            Node<String> second = new Node<>();
            second.item = "Be";

            Node<String> third = new Node<>();
            third.item = "or";

            Node<String> forth = new Node<>();
            forth.item = "not";

            Node<String> fifth = new Node<>();
            fifth.item = "to";

            Node<String> sixth = new Node<>();
            sixth.item = "be";

            first.next = second;
            second.next = third;
            third.next = forth;
            forth.next = fifth;
            fifth.next = sixth;


            LinkedList linkedList = new LinkedList();
            Node reset = linkedList.reverse(first);

            for (Node x = reset; x != null; x = x.next) {
                System.out.println(x.item);
            }
        }

    }
}
