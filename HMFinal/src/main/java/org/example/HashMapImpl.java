package org.example;



public class HashMapImpl<K, V> {
    class Entry<K, V> {
        K key;
        V value;
        Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public K getKey() {
            return key;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }
    private static final int INITIAL_SIZE = 1<<4; // 16
    private static final int MAX_CAPACITY = 1<<30;

    Entry[] hashTable;

    public HashMapImpl(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int cap) {
        int n = cap-1;
        n |= n>>1;
        n |= n>>2;
        n |= n>>4;
        n |= n>>>8;
        n |= n>>>16;
        return (n<0) ? 1 : (n >= MAX_CAPACITY) ? MAX_CAPACITY : n+1;
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length; //too many collisions
        Entry node = hashTable[hashCode];
        if(node == null) {
            Entry newNode = new Entry(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry previousNode = node;
            while(node != null) {
                if(node.getKey() == key) {
                    node.setValue(value);
                    return;
                }
                previousNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            previousNode.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];

        while(node != null) {
            if(node.getKey().equals(key)) {
                return (V)node.getValue();
            }
            node = node.next;
        }
        return null;
    }

//    public static void main(String args[]) {
//
//        HashMapImpl<Integer, String> map = new HashMapImpl<>(7);
//        map.put(1, "hi");
//        map.put(2, "my");
//        map.put(3, "name");
//        map.put(4, "is");
//        map.put(5, "Shrayansh");
//        map.put(6, "how");
//        map.put(7, "are");
//        map.put(8, "you");
//        map.put(9, "friends");
//        map.put(10, "?");
//
//        String value = map.get(8);
//        System.out.println(value);
//
//
//    }

}
