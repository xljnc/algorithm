package com.wt.dsaainjava.chapter8;

/**
 * @author WuTian
 * @date 2018-07-03 17:35
 * @description 树结构实现
 */
public class Tree<T extends Comparable<T>> {
    private Node<T> root;

    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>();
        tree.insert(50);
        tree.insert(25);
        tree.insert(75);
        tree.insert(12);
        tree.insert(37);
        tree.insert(43);
        tree.insert(30);
        tree.insert(33);
        tree.insert(87);
        tree.insert(93);
        tree.insert(97);
        tree.display();
    }

    /**
     * @param item
     * @return void
     * @throws NullPointerException if the item to be insert is null.
     */
    public void insert(T item){
        if (item == null)
            throw new NullPointerException("item must not be null.");
        if (root == null) {
            root = new Node<>(item);
            return;
        }
        Node<T> current = root;
        Node<T> parent;
        while (true) {
            if (current.data.equals(item))
                return;
            parent = current;
            if (item.compareTo(current.data) < 0) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = new Node<>(item);
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = new Node<>(item);
                    return;
                }
            }
        }
    }


    public boolean isExisted(T item) {
        if (item == null)
            throw new NullPointerException("item must not be null.");
        if (root == null)
            return false;
        Node<T> current = root;
        while (current != null) {
            if (current.data.equals(item))
                return true;
            if (item.compareTo(current.data) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        return false;
    }

    public boolean delete(T item) {
        Node<T> current = root;
        Node<T> delParent = root;
        boolean isLeftChild = false;
        while (current != null) {
            if (current.data.equals(item))
                break;
            if (item.compareTo(current.data) < 0) {
                delParent = current;
                current = current.leftChild;
                isLeftChild = true;
            } else {
                delParent = current;
                current = current.rightChild;
                isLeftChild = false;
            }
        }
        if (current == null) {
            System.out.println("not found item specified.");
            return false;
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                delParent.leftChild = null;
            else
                delParent.rightChild = null;
            current = null;
            return true;
        }
        if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                delParent.leftChild = current.rightChild;
            else
                delParent.rightChild = current.rightChild;
            current = null;
            return true;
        }
        if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                delParent.leftChild = current.leftChild;
            else
                delParent.rightChild = current.leftChild;
            current = null;
            return true;
        }
        Node<T> successor = getSuccessor(current);
        if (current == root)
            root = successor;
        else if (isLeftChild)
            delParent.leftChild = successor;
        else
            delParent.rightChild = successor;
        successor.leftChild = current.leftChild;
        current = null;
        return true;
    }

    private Node<T> getSuccessor(Node<T> delNode) {
        Node<T> current = delNode.rightChild;
        Node<T> succParent = delNode;
        Node<T> successor = delNode;
        while (current != null) {
            succParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != delNode.rightChild) {
            succParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    /**
     * 遍历树。
     *
     * @param type 0:前序 1:中序 2:后序
     * @return void
     * @throws
     */
    public void display(int type) {
        switch (type) {
            case 0:
                preOrder(root);
                break;
            case 1:
                inOrder(root);
                break;
            case 2:
                postOrder(root);
                break;
            default:
                inOrder(root);
                break;
        }
    }

    public void display() {
        display(1);
    }

    private void preOrder(Node<T> node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    private void inOrder(Node<T> node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.data + " ");
            inOrder(node.rightChild);
        }
    }

    private void postOrder(Node<T> node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.data + " ");
        }
    }


    private static class Node<T extends Comparable<T>> {
        T data;

        Node<T> leftChild;

        Node<T> rightChild;

        Node() {

        }

        Node(T data) {
            this.data = data;
        }
    }
}
