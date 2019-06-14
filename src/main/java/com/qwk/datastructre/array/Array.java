package com.qwk.datastructre.array;

public class Array<E> {
    private E[] data;//数组元素
    private int size;//数字元素个数
    private static final int DEFAULT_CAPACITY = 10;//数组默认容量
    //指定容量大小的数组
    public Array(int capacity) {
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(DEFAULT_CAPACITY);
    }

    //获取数组元素数量
    public int getSize() {
        return size;
    }

    //获取数组容量
    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void addFirst(E e) {
        add(0,e);
    }
    //向末尾添加元素
    public void addLast(E e) {
        add(size,e);
    }

    //向指定位置添加元素
    public void add(int index,E e) {
        if(size == data.length) {
//            throw new IllegalArgumentException("数组容量不足");
            resize(2 * data.length);
        }

        for (int i=size-1;i>=index;i--) {
            data[i+1] = data[i];
        }
        size++;
        data[index] = e;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for (int i=0;i<size;i++) {//遍历原始数组对象中的元素并放进新的数组对象
            newData[i] = data[i];
        }
        data = newData;//data引用指向新的数组对象
    }

    //获取指定位置的元素
    public E get(int index) {
        if(index <0 || index >= size)
            throw new IllegalArgumentException("参数异常，索引越界");
        return data[index];
    }

    //修改指定位置元素
    public void set(int index,E e) {
        if(index < 0|| index >= size)
            throw new IllegalArgumentException("参数异常，索引越界");
        data[index] = e;
    }

    // 查找数组中是否有元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if(data[i].equals(e))
                return true;
        }
        return false;
    }

    // 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
    public int find(int e) {
        for (int i=0;i<size;i++) {
            if(data[i].equals(e))
                return i;
        }
        return -1;
    }

    // 删除指定位置元素
    public E remove(int index) {
        if(index <0 || index >= size)
            throw new IllegalArgumentException("参数异常，索引越界");
        E ret = data[index];
        for (int i = index+1;i<size;i++) {
            data[i-1] = data[i];
        }
        data[size-1] = null;
        size--;
        if(size == data.length /4 && data.length != 0) {//lazy缩容策略，防止复杂度震荡，判断是否为0是为了防止数组长度为1时data.length/2为0
            resize(data.length /2);
        }
        return ret;
    }

    //删除第一个元素并返回删掉的元素
    public E removeFirst() {
        return remove(0);
    }

    //删除最后一个元素并返回删掉的元素
    public E removeLast() {
        return remove(size-1);
    }

    // 删除元素
    public void removeElement(int e) {
        int index = find(e);
        if(index != -1)
            remove(index);
    }
    
    public E getLast() {
        return get(size-1);
    }

    public E getFirst() {
        return get(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Array size = "+getSize()+" capacity = "+getCapacity()+":[");
        for (int i = 0;i<getSize();i++) {
            if(i == getSize() -1) {
                sb.append(data[i]+"]");
            } else {
                sb.append(data[i]+",");
            }
        }
        return sb.toString();
    }
}
