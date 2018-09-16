import java.util.NoSuchElementException;
//1.3.24 编写一个方法removeAfter()，接受一个链表结点作为参数并删除该结点的后续结点(如果参数结点或参数结点的后续结点为空则什么也不做)
//
//1.3.24 Write a method removeAfter() that takes a linked-list Node as argument and removes the node following the
//        given one (and does nothing if the argument or the next field in the argument node is null).

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

        public Node<Item> removeAfter(Node<Item> nodeDel){
            if(nodeDel == null || nodeDel.next == null)
                return null;

            while(nodeDel.next != null) {
                    String temp = (String)nodeDel.item;
                    nodeDel.next = nodeDel.next.next;
            }

            return nodeDel;
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

            ss = linkedList.removeAfter(second);

            for(Node<String> temp = first; temp != null; temp = temp.next)
                System.out.println(temp.item.toString());
        }
    }
}
