package com.wt.dsaainjava.chapter4;

/*
 * @author  WuTian
 * @date 2018/6/6 17:37
 * @description Stack数据结构顶级接口
 */
public interface Stack<E> {

    /*
     * @author  WuTian
     * @date 2018/6/6 17:36
     * @param e
     * @return void
     * @throws
     * @description 将元素入栈
     */
    void push(E e);

    /*
     * @author  WuTian
     * @date 2018/6/6 17:37
     * @param
     * @return E
     * @throws
     * @description 将栈顶元素出栈
     */
    E pop();

    /*
     * @author  WuTian
     * @date 2018/6/6 17:39
     * @param
     * @return E
     * @throws
     * @description 返回栈顶元素
     */
    E peek();


}
