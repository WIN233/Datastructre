package com.qwk.datastructre.queue;

public interface Queue<E> {

    void enqueue(E e);//入队

    E dequeue();//出队

    E getFront();//获取队首元素

    int getSize();//队列中有多少元素

    boolean isEmpty();//队列是否为空


}
