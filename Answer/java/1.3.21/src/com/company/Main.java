import java.util.NoSuchElementException;

/*1.3.21 编写一个方法find()，接受一条链表和一个字符串key作为参数。如果链表中的某个结点的item域的值为key，
则方法返回true，否则返回false。

1.3.21 Write a method find() that takes a linked list and a string key as arguments and returns
true if some node in the list has key as its item field, false otherwise.*/
public class Main {
    public static class LinkedList<Item> {

        public static class Node<Item> {
            Node<Item> next;
            Item item;
        }

        public boolean findNode(Node<Item> first, String key){
            if(first == null)
                return false;

            Node<Item> current = first;
            while(current != null){
                if(current.item.toString().equals(key))
                    return true;
                else
                    current = current.next;
            }

            return false;
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

            first.next  = second;
            second.next = three;
            three.next  = four;
            four.next = five;

            LinkedList<String> linkedList = new LinkedList<String>();

            boolean ret = linkedList.findNode(first, "be");
            System.out.println(ret);
        }
    }
}
