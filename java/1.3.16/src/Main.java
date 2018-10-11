import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;

import java.util.NoSuchElementException;

//1.3.16 使用1.3.1.5节中的readInts()作为模板为Date编写一个静态方法readDates()，从标准输入中读取由
//        练习1.2.19的表格所指定的格式的多个日期并返回一个它们的数组。
//
//        1.3.16 Using readInts() on page 126 as a model,write a static method readDates()
//        for Date that reads dates from standard input in the format specified in the table
//        on page 119 and returns an array containing them.
//

public class Main {

    public static class Queue<Item> {
        private Item[] a;
        private int head;
        private int tail;

        public Queue(int cap) {
            a = (Item[]) new Object[cap];
            head = 0;
            tail = 0;
        }

        public void resize(int max) {
            if(isEmpty())
                return;
            Item[] temp = (Item[]) new Object[max];
            for (int i = 0; i < (tail - head); i++)
                temp[i] = a[i];
            a = temp;
            tail = tail - head;
            head = 0;
        }

        public void enqueue(Item x) {
            if ((tail - head) == a.length)
                resize(a.length * 2);
            a[tail++] = x;
        }

        public Item dequeue() {
            if (isEmpty())
                throw new NoSuchElementException("Queue underflow");

            if ((tail - head) < a.length / 4)
                resize(a.length / 2);

            Item temp = a[--tail];
            a[tail] = null;
            return temp;
        }

        public boolean isEmpty() {
            return (tail - head) == 0;
        }

        public int length() {
            return tail - head;
        }
    }

    public static Date[] readDates(String name){
        In in = new In(name);
        Queue<Date> a  = new Queue<Date>(1);

        while (!in.isEmpty()) {
            String temp = in.readString();

            Date b = new Date(temp);
            a.enqueue(b);
        }

        int N = a.length();
        Date[] b = new Date[N];

        for (int i = 0; i < N; i++) {
            b[i] = a.dequeue();
        }

        return b;
    }

    public static void main(String[] args) {
        String file = "/Users/jack/Documents/GitHub/Algorithm-4-th/Answer/java/1.3.16/dateCase.txt";
        Date[] a = new Date[2];
        a = readDates(file);
        return;
    }
}
