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
     * @throws
     * @author Xljnc
     * @date 2018/6/10 16:44
     * @returns void
     * @description remove all elements in this list (optional operation). The list will be empty after this call returns.
     */
    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.prev = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    /**
     * @param index index of the element to be removed.
     * @throws
     * @author Xljnc
     * @date 2018/6/10 17:16
     * @returns the element previously at the specified position.
     * @description remove the element at the specified index of this list(optional operation). Return the element previously at the specified position.
     */
    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
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

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private E unlink(Node<E> x) {
        final E element = x.item;
        final Node<E> prev = x.prev;
        final Node<E> next = x.next;

        if (prev == null) {
            first = prev;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        x = null;
        size--;
        return element;
    }


    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
            Node<E> x = last;
            for (int i = (size - 1); i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }


    /**
     * Return true if the specified index is valid.
     */
    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }


    /**
     * Return the IndexOutOfBoundsException Message.
     */
    private String outOfBoundsMsg(int index) {
        return "index:" + index + ",size:" + size;
    }


    private static class Node<E> {
        E item;
        Node next;
        Node prev;

        Node(E item, Node<E> next, Node<E> previous) {
            this.item = item;
            this.next = next;
            this.prev = previous;
        }
    }


}
