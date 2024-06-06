package org.example.strategy;

import org.example.algorithm.DLL;
import org.example.algorithm.DLLNode;
import org.example.exception.KeyNotFoundException;
import org.w3c.dom.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCachingStrategy<K> implements ICachingStrategy<K> {
    private DLL<K> dll;
    private Map<K, DLLNode<K>> nodeMap;

    public LRUCachingStrategy() {
        this.dll = new DLL<K>();
        this.nodeMap = new HashMap<>();
    }
    @Override
    public void keyAccessed(K key) {
        if (nodeMap.containsKey(key)) {
            //key already exists, put it at end of dll. deletion from beginning
            DLLNode<K> node = nodeMap.get(key);
            dll.removeNode(node);
            dll.addToLast(node);
        } else {
            DLLNode<K> newNode = new DLLNode<K>(key);
            dll.addToLast(newNode);
            nodeMap.put(key, newNode);
        }
    }

    @Override
    public K evictKey() {
        DLLNode<K> nodeToBeDeleted = dll.getFirstNode();
        dll.removeNode(nodeToBeDeleted);
        nodeMap.remove(nodeToBeDeleted.getElement());
        return nodeToBeDeleted.getElement();
    }

    @Override
    public void removeKey(K key) {
        if(!nodeMap.containsKey(key)) {
            throw new KeyNotFoundException();
        } else {
            DLLNode<K> nodeToRemove = nodeMap.get(key);
            dll.removeNode(nodeToRemove);
            nodeMap.remove(key);
        }
    }
}
