package com.qwk.datastructre.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;//队列中的元素
    private int front,tail;//队首队尾的索引
    private int size;//队列的大小

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity+1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }
    @Override
    public void enqueue(E e) {
        if((tail + 1) % data.length == front)//代表队列满了需要扩容
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail+1) % data.length;
        size ++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity+1];
        for (int i = 0;i<size;i++)
            newData[i] = data[(front + i) % data.length];//

        data = newData;
        front = 0;//因为队列扩容，从索引0重新开始扩容
        tail = size;//因为队列扩容，扩容成功后size则为tail
    }
    private void resize2(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity+1];
        for (int i = front,j = 0; j<newData.length; i = (i + 1) % data.length,j++)
            newData[j] = data[i];

        data = newData;
        front = 0;//因为队列扩容，从索引0重新开始扩容
        tail = size;//因为队列扩容，扩容成功后size则为tail
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        E ret = data[front];
        data[front] = null;
        front = (front+1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Queue: size = %d , capacity = %d\n",size,getCapacity()));
        sb.append("front:[");
        for (int i = front;i != tail;i = (i + 1) % data.length) {//
            if((i + 1) % data.length != tail)
                sb.append(data[i]+",");
            else
                sb.append(data[i]+"] tail");

        }
        return sb.toString();
    }
}
