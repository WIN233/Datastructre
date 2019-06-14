package com.qwk.datastructre.stack.test;

import com.qwk.datastructre.stack.ArrayStack;
import com.qwk.datastructre.stack.Stack;
import org.junit.Test;

import java.net.URL;

public class TestStack {

    @Test
    public void  test() {

        Stack<String> stack = new ArrayStack<>();
        stack.push("1111");
        stack.push("2222222");
        stack.push("3333");
        System.out.println(stack);
        String peek = stack.peek();
        System.out.println(peek);
        System.out.println(((ArrayStack<String>) stack).getCapacity());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack);




    }



}
