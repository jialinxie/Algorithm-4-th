package com.company;

//1.3.31 实现一个嵌套类DoubleNode用来构造双向链表，其中每个结点都含有一个指向前驱元素的引用和一个指向后续元素的引用（如果不存在则为null）
//        为以下任务实现若干静态方法：在头插入结点、在表尾插入结点、从表头删除结点、从表尾删除结点、在指定结点前插入新结点、在指定结点之后
//        插入新结点、删除指定结点。
//
//1.3.31 Implement a nested class DoubleNode for building doubly-linked lists, where each node contains a reference to
//        the item preceding it and the item following it in the list (null if there is no such item). Then implement
//static methods for the following tasks: insert at the beginning, insert at the end, remove from the beginning, remove
//        from the end, insert before a given node, insert after a given node, and remove a given node.

public class DoubleList<Item> {
    private DoubleNode<Item> first;
    private DoubleNode<Item> last;

    public static class DoubleNode<E> {
        public E item;
        public DoubleNode<E> next;
        public DoubleNode<E> prev;
    }

    public DoubleList() {
        first = null;
        last = null;
    }

    public static <T> void insertAsFirst(DoubleList<T> dl, T e) {
        DoubleNode node = new DoubleNode();
        node.item = e;
        node.prev = null;
        node.next = dl.first;
        if(dl.first == null){
            dl.last = node;
        }else{
            dl.first.prev = node;
        }
        dl.first = node;
    }

    public static <T> void insertAsLast(DoubleList<T> dl, T e) {
        DoubleNode<T> node = new DoubleNode<T>();
        node.item = e;
        node.prev = dl.last;
        node.next = null;
        if (dl.last == null) {
            dl.first = node;
        } else {
            dl.last.next = node;
        }
        dl.last = node;
    }

    public static <T> void deleteFirst(DoubleList<T> dl) {
        if (dl.first == null) {
            return;
        }
        if (dl.first == dl.last) {
            dl.first = null;
            dl.last = null;
        } else {
            dl.first = dl.first.next;
            dl.first.prev.next = null;
            dl.first.prev = null;
        }
    }

    public static <T> void deleteLast(DoubleList<T> dl) {
        if (dl.last == null) {
            return;
        }
        if (dl.last == dl.first) {
            dl.first = null;
            dl.last = null;
        } else {
            dl.last = dl.last.prev;
            dl.last.next.prev = null;
            dl.last.next = null;
        }
    }

    public static <T> void insertBefore(DoubleList<T> dl, DoubleNode<T> node, T e) {
        if (node == null) {
            return;
        }
        if (dl.first == node) {
            insertAsFirst(dl, e);
        } else {
            DoubleNode<T> newNode = new DoubleNode<T>();
            newNode.item = e;
            newNode.prev = node.prev;
            newNode.next = node;
            node.prev.next = newNode;
            node.prev = newNode;
        }
    }

    public static <T> void insertAfter(DoubleList<T> dl, DoubleNode<T> node, T e) {
        if (node == null) {
            return;
        }
        if (dl.last == node) {
            insertAsLast(dl, e);
        } else {
            DoubleNode<T> newNode = new DoubleNode<T>();
            newNode.item = e;
            newNode.prev = node;
            newNode.next = node.next;
            node.next.prev = newNode;
            node.next = newNode;
        }
    }

    public static <T> void deleteNode(DoubleList<T> dl, DoubleNode<T> node) {
        if (node == null) {
            return;
        } else if (node == dl.first) {
            deleteFirst(dl);
        } else if (node == dl.last) {
            deleteLast(dl);
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.prev = null;
            node.next = null;
        }
    }

    public static <T> DoubleNode<T> search(DoubleList<T> dl, T e) {
        DoubleNode<T> node = dl.first;
        while (node != null) {
            if (node.item.equals(e)) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public static <T> void print(DoubleList<T> dl) {
        DoubleNode<T> node = dl.first;
        while (node != null) {
            System.out.println(node.item);
            node = node.next;
        }
    }
}