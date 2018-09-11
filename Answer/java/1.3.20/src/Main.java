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

//        public Node<Item> deleteLastNode(Node<Item> first) {
//            Node<Item> currentNode = first;
//            Node<Item> SecondLastNode = first;
//
//            if (first == null)
//                return first;
//
//            if (currentNode.next == null) {
//                first = null;
//                return first;
//            }
//
//            while (currentNode.next != null) {
//                SecondLastNode = currentNode;
//                currentNode = currentNode.next;
//            }
//
//            SecondLastNode.next = null;
//            return first;
//        }

        public Node<Item> deleteIndexNode(Node<Item> first, int index) {
            int listLength = 0;

            if(first == null || index < 0)
                return null;

            if(index == 0) {
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
//            for (Node x0 = first; x0 != null; x0 = x0.next)
//                listLength++;
//            if (listLength < index)
//                return first;
//            listLength = 0;
//            for (Node x = first; x != null; x = x.next) {
//                listLength ++;
//                if (listLength == index) {
//                    if(x.next != null) {
//                        x.item = x.next.item;
//                        x.next = x.next.next;
//                    }else{
//                        x.item = null;
//                        x.next = null;
//                    }
//                    break;
//                }
//            }
//            return first;
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

            linkedList.deleteIndexNode(first, 0);
            //linkedList.deleteIndexNode(first, 10);

            for(Node x = first; x != null; x = x.next)
                System.out.println(x.item.toString());
        }
    }
}
