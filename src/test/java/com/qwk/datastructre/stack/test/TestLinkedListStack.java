package com.qwk.datastructre.stack.test;

import com.qwk.datastructre.stack.LinkedListStack;
import com.qwk.datastructre.stack.Stack;
import org.junit.Test;

public class TestLinkedListStack {

    @Test
    public void test() {
        Stack<Integer> stack = new LinkedListStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());


    }

}
