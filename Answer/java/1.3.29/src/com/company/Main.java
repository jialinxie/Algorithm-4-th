package com.company;

import edu.princeton.cs.algs4.StdOut;

//1.3.29 用环形链表实现Queue。环形链表也是一条链表，只是没有任何结点链接为空，且只要链表非空则last.next的值就为first。
//        只能使用一个Node类型的实例变量（last）。
//
//1.3.29 Write a Queue implementation that uses a circular linkedlist,which is the same as a linked list
//        except that no links are null and the value of last.next is first whenever the list is not empty.
//        Keep only one Node instance variable (last).
public class Main {
    public static class CircularLinkedListQueue<Item>  {

        public static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        private Node<Item> last;

        public boolean isEmpty() {
            return last == null;
        }

        public void equeue(Item item) {
            Node<Item> a = new Node<>();
            a.item = item;
            if (isEmpty()) {
                a.next = a;
                last = a;
            } else {
                a.next = last.next;
                last.next = a;
            }
        }

        public Item dequeue() {
            Item item = last.item;
            if (last.next == last) {
                last = null;
            } else {
                last.next = last.next.next;
            }
            return item;
        }
        
        public static void main(String[] args) {
            CircularLinkedListQueue<String> queue = new CircularLinkedListQueue();
            queue.equeue("09090909");
            StdOut.println(queue.dequeue());
        }
    }
}