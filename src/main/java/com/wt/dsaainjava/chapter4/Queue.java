package com.wt.dsaainjava.chapter4;

/**
 * @author WuTian
 * @date 2018/6/7 14:03
 * @description top level interface of Queue
 */
public interface Queue<E> {

    /**
     * @param e
     * @return true if successfully add element to queue
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:16
     * @description add element to the queue
     */
    boolean offer(E e);

    /**
     * @param
     * @return the element at header of the queue
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:20
     * @description return the element at header of the queue and remove it
     */
    E poll();

    /**
     * @param
     * @return the element at header of the queue
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:21
     * @description return the element at header of the queue and do not remove it
     */
    E peek();

    /**
     * @param
     * @return true if the queue if full
     * @throws
     * @author WuTian
     * @date 2018/6/7 15:23
     * @description if the queue is full, return true
     */
    boolean isFull();

    /***
     * @author WuTian
     * @date 2018/6/7 15:25
     * @param
     * @return true if the queue if empty
     * @throws
     * @description if the queue is empty, return true
     */
    boolean isEmpty();

}
