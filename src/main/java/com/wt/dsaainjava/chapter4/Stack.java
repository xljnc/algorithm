package com.wt.dsaainjava.chapter4;

/**
 * @author WuTian
 * @date 2018/6/6 17:37
 * @description Top level interface of Stack
 */
public interface Stack<E> {

    /**
     * @param e
     * @return true if element is successfully pushed to stack
     * @throws
     * @author WuTian
     * @date 2018/6/7 9:36
     * @description push the element to stack
     */
    boolean push(E e);

    /**
     * @param
     * @return true if no element in current array
     * @throws
     * @author WuTian
     * @date 2018/6/7 10:07
     * @description return true if no element in current array
     */
    boolean isEmpty();

    /**
     * @param
     * @return true if no more slot in current array
     * @throws
     * @author WuTian
     * @date 2018/6/7 10:08
     * @description return true if no more slot in current array
     */
    boolean isFull();

    /**
     * @param
     * @return E the element from top of the stack
     * @throws
     * @author WuTian
     * @date 2018/6/6 17:37
     * @description pop the element from top of the stack and remove it
     */
    E pop();

    /**
     * @param
     * @return the element from top of the stack
     * @throws
     * @author WuTian
     * @date 2018/6/6 17:39
     * @description return the element from top of the stack , will not remove it
     */
    E peek();


}
