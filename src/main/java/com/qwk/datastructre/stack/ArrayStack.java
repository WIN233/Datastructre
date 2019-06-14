package com.qwk.datastructre.stack;

import com.qwk.datastructre.array.Array;

public class ArrayStack<E> implements Stack<E> {
    Array<E> array;
    public ArrayStack() {
        array = new Array<>();
    }
    //    可以指定capacity
    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }
    //    放入元素
    @Override
    public void push(E e) {
        array.addFirst(e);
    }
    //    取出并删除栈顶的元素
    @Override
    public E pop() {
        return array.removeLast();
    }
    //    查看栈顶元素
    @Override
    public E peek() {
        return array.getLast();
    }
    //    获取栈的大小
    @Override
    public int getSize() {
        return array.getSize();
    }

    //    判断栈是否为空
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }
    //    获取栈的容量
    public int getCapacity() {
        return array.getCapacity();
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Stack:");
        sb.append("[");
        for (int i=0;i<array.getSize();i++) {
            sb.append(array.get(i));
            if(i != array.getSize() -1) {
                sb.append(",");
            }
        }
        sb.append("] TOP");
        return sb.toString();


    }
}
