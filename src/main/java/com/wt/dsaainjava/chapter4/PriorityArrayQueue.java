package com.wt.dsaainjava.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WuTian
 * @date 2018-06-07 17:41
 * @description Priority Queue implements by array , do not support slot extend
 */
public class PriorityArrayQueue<E extends Comparable<E>> implements Queue<E> {
    private static final Logger log = LoggerFactory.getLogger(PriorityArrayQueue.class);

    //data array to store the elements
    private Object[] data;

    //current size of the queue
    private int currSize = 0;

    //default capacity of data array
    private final int defaultCapacity = 10;

    //capacity of data array
    private int capacity;


    /**
     * @param
     * @return
     * @throws
     * @author WuTian
     * @date 2018/6/7 19:29
     * @description initialize the data array using the default capacity
     */
    public PriorityArrayQueue() {
        capacity = defaultCapacity;
        data = new Object[capacity];
    }

    /**
     * @param capacity
     * @return
     * @throws
     * @author WuTian
     * @date 2018/6/7 19:32
     * @description initialize the data array using the capacity given
     */
    public PriorityArrayQueue(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity];
    }

    /**
     * @param e
     * @return true if successfully add element to queue
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:16
     * @description add element to the queue
     */
    @Override
    public boolean offer(E e) {
        if (isFull()) {
            log.error("PriorityArrayQueue is full.Can not offer.");
            return false;
        }
        if (isEmpty()) {
            data[currSize++] = e;
            return true;
        }
        int i;
        for (i = (currSize - 1); i >= 0; i--) {
            if (e.compareTo((E) data[i]) < 0) {
                data[i + 1] = data[i];
            } else {
                break;
            }
        }
        data[i + 1] = e;
        currSize++;
        return true;
    }

    /**
     * @return the element at header of the queue
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:20
     * @description return the element at header of the queue and remove it
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            log.error("PriorityArrayQueue is empty.Can not poll.");
            return null;
        }
        return (E) data[--currSize];
    }

    /**
     * @return the element at header of the queue
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:21
     * @description return the element at header of the queue and do not remove it
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            log.error("PriorityArrayQueue is empty.");
            return null;
        }
        return (E) data[currSize - 1];
    }

    /**
     * @return true if the queue if full
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:23
     * @description if the queue is full, return true
     */
    @Override
    public boolean isFull() {
        return currSize == capacity;
    }

    /***
     * @author WuTian
     * @date 2018/6/7 15:25
     * @return true if the queue if empty
     * @throws
     * @description if the queue is empty, return true
     */
    @Override
    public boolean isEmpty() {
        return currSize == 0;
    }

    public static void main(String[] args) {
        Queue<Integer> quque = new PriorityArrayQueue<>();
        quque.offer(2);
        quque.offer(1);
        quque.offer(3);
        quque.offer(4);
        while (!quque.isEmpty()) {
            System.out.println(quque.poll());
        }
    }
}
