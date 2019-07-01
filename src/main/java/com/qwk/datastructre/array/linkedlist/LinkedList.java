package com.qwk.datastructre.array.linkedlist;

public class LinkedList<E> {

    private class Node {
        private E e;
        private Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e,null);
        }

        public Node() {
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }


    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead = new Node(null,null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0,e);
    }


    public void add(int index, E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        Node prev = dummyHead;
        for(int i = 0;i < index; i ++) {//遍历元素，找到index位置的元素，也就是prev
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e,prev.next);
        size++;
    }

    public void addLast(E e) {
        add(size,e);
    }


    //获得链表的第index（0-based）位置元素
    public E get(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Get failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i = 0;i < index;i++)
            cur = cur.next;
        return cur.e;
    }

    //获得链表的第一个元素
    public E getFirst() {
        return get(0);
    }

    //获得链表的最后一个元素
    public E getLast() {
        return get(size-1);
    }

    //修改链表上第index位置上的元素
    public void set(int index,E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        Node cur = dummyHead.next;
        for (int i =0;i< index;i++)
            cur = cur.next;
        cur.e = e;
    }

    // 查找链表中是否存在元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur.next != null) {
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }

    // 从链表中删除元素
    public E remove(int index) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        Node prev = dummyHead;
        for (int i = 0;i < index;i ++)
            prev = prev.next;
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    // 从链表中删除第一个元素，返回删除元素
    public E removeFirst() {
        return remove(0);
    }

    // 从链表中删除最后元素，返回删除元素
    public E removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur+"->");
            cur = cur.next;
        }
        sb.append("NULL");
        return sb.toString();
    }
}
