package com.anan.queue;

import org.junit.Test;

/**
 * @author don
 * @create 2020-06-06 21:00
 */
public class TestArrayQueue {

    @Test
    public void test(){
        ArrayQueue<String> stringArrayQueue = new ArrayQueue<>();
        try {
            String queue = stringArrayQueue.getQueue();
            System.out.println(queue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
