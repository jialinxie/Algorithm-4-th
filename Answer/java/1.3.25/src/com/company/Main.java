import java.util.NoSuchElementException;

//1.3.25 编写一个方法insertAfter()，接受两个链表结点作为参数，将第二结点插入链表并使之成为第一个结点的后续结点
//（如果两个参数为空则什么也不做）。
//
//1.3.25 Write a method insertAfter() that takes two linked-list Node arguments and inserts the
//        second after the first on its list (and does nothing if either argument is null).
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

            ss = linkedList.insertAfter(first, six);

            for(Node x = ss; x != null; x = x.next)
                System.out.println(x.item.toString());
        }
    }
}
