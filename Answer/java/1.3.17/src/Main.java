import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.Transaction;

import java.util.NoSuchElementException;

//1.3.17 为Transaction 类完成练习1.3.16
//
//1.3.17 DoExercise 1.3.16 for Transaction.

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

    public static Transaction[] readTransaction(String name){
        In in = new In(name);
        Queue<Transaction> a  = new Queue<Transaction>(1);

        while (!in.isEmpty()) {
            String nameStr = in.readString();
            String dateStr = in.readString();
            String feeStr  = in.readString();
            String temp = nameStr + ' ' + dateStr + ' ' + feeStr;

            Transaction b = new Transaction(temp);
            a.enqueue(b);
        }

        int N = a.length();
        Transaction[] b = new Transaction[N];

        for (int i = 0; i < N; i++) {
            b[i] = a.dequeue();
        }

        return b;
    }

    public static void main(String[] args) {
        String file = "/Users/jack/Documents/GitHub/Algorithm-4-th/Answer/java/1.3.17/TransactionCase.txt";
        Transaction[] a = new Transaction[2];
        a = readTransaction(file);

        return;
    }
}
