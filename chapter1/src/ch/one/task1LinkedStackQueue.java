package ch.one;

import java.util.NoSuchElementException;
public class task1LinkedStackQueue<T> {
    private Node<T> head;
    private Node<T> tail;

    public void pushInBegin(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    public T pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack-Queue is empty");
        }
        T data = head.getData();
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return data;
    }

    public void appendInEnd(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
        } else {
            tail.setNext(newNode);
        }
        tail = newNode;
    }

    public T peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack-Queue is empty");
        }
        return head.getData();
    }

    public boolean isEmpty() {
        return head == null;
    }
}
