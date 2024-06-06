package strategy;

import algorithm.DLL;
import algorithm.DLLNode;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheStrategy<K> implements  CacheStrategy<K> {
    Map<K, DLLNode<K>> nodeMap;
    DLL<K> dll;

    public LRUCacheStrategy() {
        dll = new DLL<K>();
        nodeMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        if (nodeMap.containsKey(key)) {
           DLLNode<K> node = nodeMap.get(key);
           dll.deleteNode(node);
           dll.insertFirst(node);
        } else {
            DLLNode<K> node = new DLLNode<K>(key);
            nodeMap.put(key, node);
            dll.insertFirst(node);
        }
    }

    @Override
    public K evictKey() {
        if(dll.isEmpty()) {
            return null;
        }

        DLLNode<K> delNode = dll.getLast();
        dll.deleteNode(delNode);
        return delNode.element;
    }

    public void deleteKey(K key) {
        DLLNode<K> node = nodeMap.get(key);
        if(node == null) return;
        dll.deleteNode(node);
    }
}
