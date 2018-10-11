import java.util.NoSuchElementException;

//1.3.26 编写一个方法remove()，接受一个链表和一个字符串key作为参数，删除链表中所有item域为key的结点。
//
//1.3.26 Write a method remove() that takes a linkedlist and a string key as arguments and
//        removes all of the nodes in the list that have key as its item field.

public class Main {
    public static class LinkedList<Item> {

        public static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        public Node<Item> deleteIndexNode(Node<Item> first, int index) {
            int listLength = 0;

            if(first == null || index < 0)
                return null;

            if(index == 0) {
                Item temp = first.item;
                first = first.next;
                return first;
            }

            Node<Item> current = first;
            while((current != null) && (--index != 0))
                current  = current.next;

            if(index != 0 || current == null || current.next == null)
                throw new NoSuchElementException("Queue underflow");
            else
                current.next = current.next.next;

            return first;
        }

        public Node<Item> insertAfter(Node<Item> first, Node<Item> second){
            if(first == null || second == null)
                return null;

            second.next = first.next;
            first.next = second;

            return first;
        }

        public Node<Item> remove(Node<Item> first, String key){
            if(first == null || key == null)
                return null;

            Node newFirst = new Node();
            newFirst.next = first;
            Node current = newFirst;
            while(current.next != null){
                if(current.next.item.equals(key))
                    current.next = current.next.next;
                else
                    current = current.next;
            }

            return first;
        }

        public static void main(String[] args) {
            // write your code here
            Node<String> first = new Node<>();
            Node<String> ss = new Node<>();
            first.item = "to";

            Node<String> second = new Node<>();
            second.item = "be";

            Node<String> three = new Node<>();
            three.item = "or";

            Node<String> four = new Node<>();
            four.item = "not";

            Node<String> five = new Node<>();
            five.item = "to";

            Node<String> six = new Node<>();
            six.item = "SKY";

            first.next  = second;
            second.next = three;
            three.next  = four;
            four.next = five;

            LinkedList<String> linkedList = new LinkedList<String>();

            ss  =linkedList.remove(first, "not");

            //for(Node x = ss; x != null; x = x.next)
            //    System.out.println(x.item.toString());
        }
    }
}