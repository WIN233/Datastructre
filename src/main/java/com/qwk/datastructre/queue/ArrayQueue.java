package com.qwk.datastructre.queue;

import com.qwk.datastructre.array.Array;

public class ArrayQueue<E> implements Queue<E> {
    Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }
    //入队
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }
    //出队
    @Override
    public E dequeue() {
        return array.removeFirst();
    }
    //获取队首
    @Override
    public E getFront() {
        return array.getFirst();
    }
    //获取队列大小
    @Override
    public int getSize() {
        return array.getSize();
    }
    //队列是否为空
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Queue:");
        sb.append("front [");
        for (int i=0;i<array.getSize();i++) {
            sb.append(array.get(i));
            if(i != array.getSize() -1) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }
}
