package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class MapHash<K, V> implements Map {

    private Entry<K, V> head;
    private int size;

    public MapHash() {
        head = new Entry<K, V>(null, null);
        this.size = 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public boolean containsKey(Object key) {

        validateNullKey(key);
        return (getEntryBy(key) != null);
    }

    @Override
    public boolean containsValue(Object value) {

        Entry<K, V> curr = head.getNext();
        for (int i = 0; i < size; i++) {
            V nextValue = curr.getValue();
            if (Objects.equals(nextValue, value)) {
                return true;
            }
            curr = curr.getNext();
        }
        return false;
    }

    @Override
    public V get(Object key) {

        validateNullKey(key);
        Entry<K, V> entry = getEntryBy(key);
        V ret = (entry != null)? entry.getValue() : null;
        return ret;
    }

    @Override
    public V put(Object key, Object value) {

        Entry<K, V> duplicatedEntry = getEntryBy(key);

        // if not duplicated
        if (duplicatedEntry == null) {
            Entry<K, V> newEntry = new Entry<K, V>((K) key, (V) value);
            newEntry.setNext(head.getNext());
            head.setNext(newEntry);
            size++;
            return null;
        }
        // if duplicated
        V ret = duplicatedEntry.getValue();
        duplicatedEntry.setValue(value);
        return ret;
    }

    @Override
    public V remove(Object key) {

        Entry<K, V> dest = getEntryBy(key);
        if (dest == null) {
            return null;
        }
        // find the previous node
        Entry<K, V> prev = head;
        while (prev.getNext() != dest) {
            prev = prev.getNext();
        }
        // remove
        V ret = dest.getValue();
        prev.setNext(dest.getNext());
        size--;
        return ret;
    }

    @Override
    public void putAll(Map m) {

        Set<K> keySet = m.keySet();
        for (K key : keySet) {
            put(key, m.get(key));
        }
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public Set keySet() {

        Set<K> set = new HashSet<>();

        Entry<K, V> curr = head.getNext();
        for (int i = 0; i < size; i++) {
            set.add(curr.getKey());
            curr = curr.getNext();
        }
        return set;
    }

    @Override
    public List values() {

        List<V> list = new ArrayList<>();

        Entry<K, V> curr = head.getNext();
        for (int i = 0; i < size; i++) {
            list.add(curr.getValue());
            curr = curr.getNext();
        }
        return list;
    }

    @Override
    public Set<Map.Entry> entrySet() {
        return null; // TODO
    }

    private Entry getEntryBy(Object key) {

        Entry<K, V> curr = head.getNext();
        for (int i = 0; i < size; i++) {
            if (Objects.equals(curr.getKey(), (K) key)) {
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }

    private void validateNullKey(Object key) {
        if (key == null) {
            throw new NullPointerException();
        }
    }

    @Override
    public String toString() {
        String s = "";
        Entry<K, V> entry = head.getNext();
        for (int i = 0; i < size; i++) {
            s += "\t" + entry.toString() + "\n";
            entry = entry.getNext();
        }
        return "MapHash{size= " + size + "\n" +
                s + '}';
    }

    static class Entry<K, V> implements Map.Entry {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public V setValue(Object value) {
            if (value == null) {
                throw new NullPointerException();
            }
            this.value = (V) value;
            return this.value;
        }

        @Override
        public String toString() {
            return "Node{ " +
                    "key=" + key +
                    ", value=" + value +
                    " }";
        }
    }
}
