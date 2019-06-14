package com.qwk.datastructre.stack;

public interface Stack<E> {
    void push(E e);//入栈

    E pop();//取出栈顶的元素

    E peek();//查看栈顶的元素

    int getSize();//查看栈里有多少元素

    boolean isEmpty();//栈是否为空
}
