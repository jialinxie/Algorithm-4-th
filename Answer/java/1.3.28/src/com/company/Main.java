import java.util.NoSuchElementException;

//1.3.28 Develop a recursive solution to the previous question.
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

//        public Integer max(Node<Integer> first){
//            Integer ret = 0;
//            if(first == null)
//                return ret;
//            Node temp = new Node();
//            temp.next = first;
//            Node current = temp;
//            while(current.next != null){
//                Integer curValue = Integer.parseInt(current.next.item.toString());
//                if(ret < curValue)
//                    ret = curValue;
//                current.next = current.next.next;
//            }
//
//            return ret;
//        }

        public  Integer max(Node<Integer> first, Integer ret){
            if(first == null)
                return ret;

            if(ret < Integer.parseInt(first.item.toString())){
                ret = Integer.parseInt(first.item.toString());
            }

            return max(first.next, ret);
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
            six.item = 56;

            first.next  = second;
            second.next = three;
            three.next  = four;
            four.next = five;
            five.next = six;

            LinkedList<Integer> linkedList = new LinkedList<Integer>();

            Integer ss  =linkedList.max(first, 0);

            System.out.println("max = " + ss);
        }
    }
}