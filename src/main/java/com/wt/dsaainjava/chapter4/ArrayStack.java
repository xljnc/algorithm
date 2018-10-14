package com.wt.dsaainjava.chapter4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WuTian
 * @date 2018-06-06 15:55
 * @description Stack implements by array , do not support slot extend
 */
public class ArrayStack<E> implements Stack<E> {
    private static final Logger log = LoggerFactory.getLogger(ArrayStack.class);

    //data array to store the elements
    private Object[] data;

    //a pointer indicates the current position of element
    private int position = -1;

    //default capacity of data array
    private final int defaultCapacity = 10;

    //capacity of data array
    private int capacity;

    /**
     * @param
     * @return
     * @throws
     * @author WuTian
     * @date 2018/6/7 10:56
     * @description initialize the data array using the default capacity
     */
    public ArrayStack() {
        capacity = defaultCapacity;
        data = new Object[capacity];
    }

    /**
     * @param capacity
     * @return
     * @throws
     * @author WuTian
     * @date 2018/6/7 12:05
     * @description initialize the data array using the capacity given
     */
    public ArrayStack(int capacity) {
        this.capacity = capacity;
        data = new Object[this.capacity];
    }

    /**
     * @param e
     * @return true if element is successfully pushed to stack
     * @throws
     * @author WuTian
     * @date 2018/6/7 9:36
     * @description push the element to stack
     */
    @Override
    public boolean push(E e) {
        if (isFull()) {
            log.error("Stack is full.Can not push.");
            return false;
        }
        data[++position] = e;
        return true;
    }

    /**
     * @param
     * @return true if no element in current array
     * @throws
     * @author WuTian
     * @date 2018/6/7 10:07
     * @description return true if no element in current array
     */
    @Override
    public boolean isEmpty() {
        return position == -1;
    }

    /**
     * @param
     * @return true if no more slot in current array
     * @throws
     * @author WuTian
     * @date 2018/6/7 10:08
     * @description return true if no more slot in current array
     */
    @Override
    public boolean isFull() {
        return position == (capacity - 1);
    }


    /**
     * @param
     * @return E the element from top of the stack
     * @throws
     * @author WuTian
     * @date 2018/6/6 17:37
     * @description pop the element from top of the stack and remove it
     */
    @Override
    public E pop() {
        if (isEmpty()) {
            log.error("Stack is empty.Can not pop.");
            return null;
        }
        return (E) data[position--];
    }

    /**
     * @param
     * @return the element from top of the stack
     * @throws
     * @author WuTian
     * @date 2018/6/6 17:39
     * @description return the element from top of the stack , will not remove it
     */
    @Override
    public E peek() {
        if (isEmpty()) {
            log.error("Stack is empty.");
            return null;
        }
        return (E) data[position];
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
