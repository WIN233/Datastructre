package com.qwk.datastructre.array.test;

import com.qwk.datastructre.array.Array;
import org.junit.Test;

public class TestArray {
    @Test
    public void test() {
        Array array = new Array(5);
        array.addLast(1);
        array.addLast(2);
        array.addLast(3);
        array.addLast(4);
        System.out.println(array);
        array.addLast(1232);
        System.out.println(array);
        array.addLast(123);
        System.out.println(array);
        array.remove(0);
        System.out.println(array);
        array.addLast(12321);
        System.out.println(array);

    }


    @Test
    public void test2() {
        System.out.println(3%2);


    }



}
