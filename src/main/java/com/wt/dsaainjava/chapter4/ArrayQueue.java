package com.wt.dsaainjava.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WuTian
 * @date 2018-06-07 15:26
 * @description Queue implements by array , do not support slot extend
 */
public class ArrayQueue<E> implements Queue<E> {
    private static final Logger log = LoggerFactory.getLogger(ArrayQueue.class);

    //data array to store the elements
    private Object[] data;

    //a pointer indicates the header position of the queue
    private int head = 0;

    //a pointer indicates the tail position of the queue
    private int tail = -1;

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
     * @date 2018/6/7 15:36
     * @description initialize the data array using the default capacity
     */
    public ArrayQueue() {
        capacity = defaultCapacity;
        data = new Object[capacity];
    }

    /**
     * @param
     * @return
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:36
     * @description initialize the data array using the capacity given
     */
    public ArrayQueue(int capacity) {
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
            log.error("ArrayQueue is full.Can not offer.");
            return false;
        }
        if (tail == (capacity - 1)) {
            tail = -1;
        }
        data[++tail] = e;
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
            log.error("ArrayQueue is empty.Can not poll.");
            return null;
        }
        E item = (E) data[head++];
        if (head == capacity) {
            head = 0;
        }
        currSize--;
        return item;
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
            log.error("ArrayQueue is empty.");
            return null;
        }
        return (E) data[head];
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
        Queue<Integer> quque = new ArrayQueue<>();
        quque.offer(1);
        quque.offer(2);
        quque.offer(3);
        quque.offer(4);
        while (!quque.isEmpty()) {
            System.out.println(quque.poll());
        }
    }
}
