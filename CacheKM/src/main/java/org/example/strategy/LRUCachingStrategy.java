package org.example.strategy;

import org.example.algorithm.DoublyLinkedList;
import org.example.algorithm.DoublyLinkedListNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCachingStrategy<K> implements ICachingStrategy<K> {
    DoublyLinkedList<K> dll;
    Map<K, DoublyLinkedListNode<K>> mapper;

    public LRUCachingStrategy() {
        dll = new DoublyLinkedList<>();
        mapper = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        if(!mapper.containsKey(key)) {
            //TODO: offload node creation responsibility also to DLL
            DoublyLinkedListNode<K> newNode = new DoublyLinkedListNode<>(key);
            dll.addLast(newNode);
            mapper.put(key, newNode);
        } else {
            DoublyLinkedListNode<K> node = mapper.get(key);
            dll.deleteNode(node);
            dll.addLast(node);
        }
    }

    public void removeKey(K key) {
        dll.searchAndRemove(key);
    }

    public K evictKey() {
        DoublyLinkedListNode<K> nodeToBeRemoved = dll.getFirst();
        dll.deleteNode(nodeToBeRemoved);
        mapper.remove(nodeToBeRemoved.getElement());
        return nodeToBeRemoved.getElement();
    }
}
