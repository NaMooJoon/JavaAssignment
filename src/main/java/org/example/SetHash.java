package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class SetHash<T> implements Set, Iterable {

    private Node<T> head;
    private int size;

    public SetHash() {
        this.head = new Node<T>(null);
        this.head.setNext(null);
        this.size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(Object value) {
        return (getNodeOf(value) != null);
    }

    @Override
    public Iterator<T> iterator() {
        return new SetIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        Object[] ret = new Object[size];

        Node curr = head.next();
        for (int i = 0; i < size; i++) {
            ret[i] = curr;
            curr = curr.next();
        }
        return ret;
    }

    @Override
    public boolean add(Object o) {
        if (contains(o)) {
            return false;
        }
        try {
            T value = (T) o;
            Node<T> node = new Node<>(value);

            node.setNext(head.next());
            head.setNext(node);
        } catch (ClassCastException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {

        if (!contains(o)) {
            return false;
        }
        Node<T> target = getNodeOf(o);

        // find previous node
        Node prev = head;
        while (prev.hasNext() && prev.next() != target) {
            prev = prev.next();
        }

        // remove
        prev.setNext(target.next());
        size--;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean flag = true;
        for (Object o : c) {
            boolean isSucceed = add(o);
            if (isSucceed) { flag = false; }
        }
        return flag;
    }

    @Override
    public void clear() {
        head.setNext(null);
        size = 0;
    }

    @Override
    public boolean removeAll(Collection c) {
        boolean flag = true;
        for (Object o : c) {
            boolean isSucceed = remove(o);
            if (isSucceed) {
                flag = false;
            }
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection c) {
        for (Object o : c) {
            if (contains(o)) {
                continue;
            }
            boolean isSucceed = remove(o);
            if (isSucceed) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean containsAll(Collection c) {
        for (Object o : c) {
            if (contains(o)) {
                continue;
            }
            return false;
        }
        return true;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0]; // TODO
    }

    private Node getNodeOf(Object value) {

        for (Node curr = head.next(); curr != null; curr = curr.next()) {
            if (Objects.equals(curr.getValue(), (T) value)) {
                return curr;
            }
        }
        return null;
    }

    static class SetIterator<T> implements Iterator<T> {

        Node<T> curr;

        public SetIterator(SetHash<T> set) {
            curr = set.getHead().getNext();
        }

        @Override
        public boolean hasNext() {
            return (curr != null);
        }

        @Override
        public T next() {
            T data = curr.getValue();
            curr = curr.getNext();
            return data;
        }
    }

    static class Node<T> implements Iterator {
        private T value;
        private Node<T> next;

        public Node(T value) {
            this.value = value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public T getValue() {
            return value;
        }

        public Node<T> getNext() {
            return next;
        }

        @Override
        public boolean hasNext() {
            return (next != null);
        }

        @Override
        public Node<T> next() {
            return next;
        }
    }
}
