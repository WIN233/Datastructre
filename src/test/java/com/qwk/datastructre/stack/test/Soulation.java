package com.qwk.datastructre.stack.test;

import com.qwk.datastructre.stack.ArrayStack;
import com.qwk.datastructre.stack.Stack;
import org.junit.Test;


public class Soulation {


    public static void isValid(String s) {
        Stack<String> stack = new ArrayStack<String>();
        String[] strings = s.split("");
        for (int i = 0;i < strings.length; i ++) {
            String str = strings[i];
            if(str.equals("(") || str.equals("{")||str.equals("[")) {
                stack.push(strings[i]);
            } else {
                String peek = stack.peek();
                if(str.equals(")") && peek.equals("("))
                    stack.pop();
                if(str.equals("]") && peek.equals("["))
                    stack.pop();
                if(str.equals("}") && peek.equals("{"))
                    stack.pop();
            }

        }
        System.out.println(stack);

    }


    @Test
    public void test() {
        isValid("([]])");
    }

}
