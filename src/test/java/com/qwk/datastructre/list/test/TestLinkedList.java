package com.qwk.datastructre.list.test;

        import com.qwk.datastructre.array.linkedlist.LinkedList;
        import org.junit.Test;

public class TestLinkedList {



    @Test
    public void test() {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0;i < 5;i ++) {
            list.addFirst(i);
        }
        System.out.println(list);
        list.add(3,555);
        System.out.println(list);
    }






}
