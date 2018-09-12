import java.util.NoSuchElementException;

//1.3.20 编写一个方法delete()，接受一个int参数k，删除链表的第k个元素（如果它存在的话
//1.3.20 Write a method delete() that takes an int argument k and deletes the
// kth element in a linked list, if it exists.
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

            ss = linkedList.deleteIndexNode(first, 0);

            for(Node x = ss; x != null; x = x.next)
                System.out.println(x.item.toString());
        }
    }
}
