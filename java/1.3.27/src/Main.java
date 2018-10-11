import java.util.NoSuchElementException;

//1.3.27 编写一个方法max()，接受一个链表的首结点作为参数，返回链表中键最大的节点的值。假设所有键均为正整数，如果链表为空则返回0。
//
//1.3.27 Write a method max() that takes a reference to the first node in a linkedlist as argument and returns
//        the value of the maximum key in the list. Assume that all keys are positive integers, and return 0 if
//        the list is empty.
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

        public Integer max(Node<Integer> first){
            Integer ret = 0;
            if(first == null)
                return ret;
            Node temp = new Node();
            temp.next = first;
            Node current = temp;
            while(current.next != null){
                Integer curValue = Integer.parseInt(current.next.item.toString());
                if(ret < curValue)
                    ret = curValue;
                current.next = current.next.next;
            }

            return ret;
        }

        public static void main(String[] args) {
            // write your code here
            Node<Integer> first = new Node<>();
//            Node<Integer> ss = new Node<>();
            first.item = 9089;

            Node<Integer> second = new Node<>();
            second.item = 3;

            Node<Integer> three = new Node<>();
            three.item = 999;

            Node<Integer> four = new Node<>();
            four.item = 5;

            Node<Integer> five = new Node<>();
            five.item = 6;

            Node<Integer> six = new Node<>();
            six.item = 565753;

            first.next  = second;
            second.next = three;
            three.next  = four;
            four.next = five;
            five.next = six;

            LinkedList<Integer> linkedList = new LinkedList<Integer>();

            Integer ss  =linkedList.max(first);

            System.out.println("max = " + ss);
            //for(Node x = ss; x != null; x = x.next)
            //    System.out.println(x.item.toString());
        }
    }
}