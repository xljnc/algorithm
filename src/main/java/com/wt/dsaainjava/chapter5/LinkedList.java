package com.wt.dsaainjava.chapter5;

/**
 * @author WuTian
 * @date 2018-06-08 16:24
 * @description
 */
public class LinkedList<E> implements List<E> {

    //number of elements in this list
    private int size;

    Node<E> first;

    Node<E> last;

    public LinkedList() {

    }

    /**
     * @return true if this list contains no elements
     * @throws
     * @author WuTian
     * @date 2018/6/8 14:07
     * @description return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the number of elements in this list.If this list contains more than Integer.MaxValue elements, returns Integer.MaxValue
     * @throws
     * @author WuTian
     * @date 2018/6/8 14:14
     * @description Return the number of elements in this list.If this list contains more than Integer.MaxValue elements, returns Integer.MaxValue
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @param e
     * @return true if the element is successfully added to this list
     * @throws
     * @author WuTian
     * @date 2018/6/8 16:48
     * @description Appends the specified element to the end of this list(Optional operation).
     */
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * @param e
     * @return void
     * @throws
     * @author WuTian
     * @date 2018/6/8 17:04
     * @description link e as the last element
     */
    void linkLast(E e) {
        final Node<E> l = last;
        Node<E> newNode = new Node<>(e, null, l);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }


    private static class Node<E> {
        E item;
        Node next;
        Node previous;

        Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.previous = previous;
        }
    }


}
