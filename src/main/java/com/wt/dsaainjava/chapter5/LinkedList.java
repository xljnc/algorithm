package com.wt.dsaainjava.chapter5;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
     * @description return true if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the number of elements in this list.If this list contains more than Integer.MaxValue elements, returns Integer.MaxValue
     * @throws
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
     * @description Appends the specified element to the end of this list(Optional operation).
     */
    @Override
    public boolean add(E e) {
        linkLast(e);
        return true;
    }

    /**
     * @throws
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
     * remove the element previously at first position of this list.
     *
     * @param
     * @return the element previously at first position of this list.
     * @throws
     */
    public E remove() {
        return removeFirst();
    }

    /**
     * @param index index of the element to be removed.
     * @throws
     * @returns the element previously at the specified position.
     * @description remove the element at the specified index of this list(optional operation). Return the element previously at the specified position.
     */
    @Override
    public E remove(int index) {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlink(f);
    }

    private E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlink(l);
    }

    /**
     * @param e
     * @return void
     * @throws
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

    /**
     * Remove the element from this list.
     *
     * @param x
     * @return E
     * @throws
     */
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

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {

        Node<E> curr = first;
        Node<E> lastRet;

        /**
         * return true if current position has next value
         *
         * @param
         * @return true if current position has next value
         * @throws
         */
        @Override
        public boolean hasNext() {
            return curr == null ? false : true;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            final Node<E> l = curr;
            lastRet = curr;
            if (l == null)
                throw new NoSuchElementException();
            curr = l.next;
            return l.item;
        }

        /**
         * Remove from this list the last element returned by the iterator (Optional operation)
         *
         * @param
         * @return void
         * @throws
         */
        @Override
        public void remove() {
            LinkedList.this.unlink(lastRet);
        }
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

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        Iterator<Integer> itr = list.iterator();
        while(itr. hasNext()){
            System.out.println(itr.next());
            itr.remove();
        }
        System.out.println(list.isEmpty());

    }
}
