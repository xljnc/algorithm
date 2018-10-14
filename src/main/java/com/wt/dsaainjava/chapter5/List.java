package com.wt.dsaainjava.chapter5;

/**
 * @author WuTian
 * @date 2018/6/8 14:04
 * @description Top level interface of
 */
public interface List<E> extends Iterable<E>{
    /**
     * @param
     * @return true if this list contains no elements
     * @throws
     * @author WuTian
     * @date 2018/6/8 14:07
     * @description return true if this list contains no elements
     */
    boolean isEmpty();

    /**
     * @param
     * @return the number of elements in this list.If this list contains more than Integer.MaxValue elements, returns Integer.MaxValue
     * @throws
     * @author WuTian
     * @date 2018/6/8 14:14
     * @description Return the number of elements in this list.If this list contains more than Integer.MaxValue elements, returns Integer.MaxValue
     */
    int size();

    /**
     * @param item
     * @return true if the element is successfully added to this list
     * @throws
     * @author WuTian
     * @date 2018/6/8 16:48
     * @description Appends the specified element to the end of this list(Optional operation).
     */
    boolean add(E e);


    /**
     * @param
     * @throws
     * @author Xljnc
     * @date 2018/6/10 16:44
     * @returns void
     * @description remove all elements in this list (optional operation). The list will be empty after this call returns.
     */
    void clear();

    /**
     * @param index index of the element to be removed.
     * @throws
     * @author Xljnc
     * @date 2018/6/10 17:16
     * @returns the element previously at the specified position.
     * @description remove the element at the specified index of this list(optional operation). Return the element previously at the specified position.
     */
    E remove(int index);



}
