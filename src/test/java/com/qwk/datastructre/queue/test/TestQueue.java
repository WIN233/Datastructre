package com.qwk.datastructre.queue.test;

import com.qwk.datastructre.queue.ArrayQueue;
import com.qwk.datastructre.queue.LoopQueue;
import com.qwk.datastructre.queue.Queue;
import org.junit.Test;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Random;

public class TestQueue {




    @Test
    public void testArrayQueue() {
        Queue<String> queue = new ArrayQueue<>();
        queue.enqueue("111111111");
        queue.enqueue("22222222");
        queue.enqueue("3333333333");
        System.out.println(queue);
        queue.dequeue();
        System.out.println(queue);
        System.out.println(queue.getSize());
        System.out.println(queue.getFront());
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        queue.dequeue();
        System.out.println(queue.getSize());
    }



    @Test
    public void testLoopQueue() {
        Queue<String> queue = new LoopQueue<>(4);
        queue.enqueue("1111");
        queue.dequeue();
        queue.enqueue("111111");
        System.out.println(queue);
        queue.enqueue("1111111");
        queue.enqueue("22222");
        queue.enqueue("3333333");
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue);

    }


    public static void getTail(Object o) {
        try {
            Field field = LoopQueue.class.getDeclaredField("tail");
            field.setAccessible(true);
            System.out.println("tail = "+field.getInt(o));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static double testQueue(Queue<Integer> queue,int opConunt) {
        long startTime = System.nanoTime();
        Random r = new Random();
        for (int i = 0;i < opConunt; i++) {
            queue.enqueue(r.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0;i < opConunt; i++) {
            queue.dequeue();
        }

        long endTime = System.nanoTime();


        return (endTime - startTime) / 100000000.0;

    }



    @Test
    public void queueTimeCompare() {
        Queue<Integer> arrayQueue = new ArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue, 100000);
        System.out.println("ArrayQueue spend time "+arrayQueueTime);

        Queue<Integer> loopQueue = new LoopQueue<>();
        double loopQueueTime = testQueue(loopQueue, 100000);
        System.out.println("loopQueue spend time "+loopQueueTime);
        System.out.println(loopQueue);
        System.out.println(arrayQueue);

    }

    @Test
    public void test() {

        System.out.println(0.1+4.1);

        BigDecimal decimal = new BigDecimal(new Float(0.1).toString());

        System.out.println(decimal.add(new BigDecimal("4.1")));
    }


}
