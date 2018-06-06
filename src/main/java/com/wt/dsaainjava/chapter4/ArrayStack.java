package com.wt.dsaainjava.chapter4;

/**
 * @author WuTian
 * @date 2018-06-06 15:55
 * @description 栈数据结构，使用数组实现
 */
public class ArrayStack<E> implements Stack<E> {

    //数据数组
    private E[] data;
    //当前指针位置
    private int position;
    //数据数组大小
    private int size;

    /*
     * @author  WuTian
     * @date 2018/6/6 17:36
     * @param e
     * @return void
     * @throws
     * @description 将元素入栈
     */
    @Override
    public void push(E e) {

    }

    private boolean isEmpty() {
        return false;
    }

    private boolean isFull() {
        return false;
    }


    /*
     * @author  WuTian
     * @date 2018/6/6 17:37
     * @param
     * @return E
     * @throws
     * @description 将栈顶元素出栈
     */
    @Override
    public E pop() {
        return null;
    }

    /*
     * @author  WuTian
     * @date 2018/6/6 17:39
     * @param
     * @return E
     * @throws
     * @description 返回栈顶元素
     */
    @Override
    public E peek() {
        return null;
    }

}
