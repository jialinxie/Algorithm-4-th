package com.company;
import java.util.Iterator;

public class MoveToFront{

    private class Node{
        Node next = null;
        String data;
    }

    private Node head = null;

    public boolean isArise(String s){

        if(head == null)
            return false;

        Node current = head;
        while(current.next != null){
            if(current.next.data.equals(s)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void MoveToFront(){
        String[] a = {"1","2","3","4","1","3","4","5"};
        for (int i = 0; i < a.length; ++i)
        {
            String s = a[i];
            isArise(s);
            if (head == null)
            {
                head = new Node();
                head.data = s;
            }
            else
            {
                Node current = new Node();
                current.data = s;
                current.next = head;
                head = current;
            }
        }

        Node temp = head;
        while(temp.next != null){
            System.out.println("temp.data = " + temp.data);
            temp = temp.next;
        }
    }
}
