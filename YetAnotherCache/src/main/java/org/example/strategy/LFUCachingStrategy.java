package org.example.strategy;

import org.example.Main;
import org.example.algorithm.DLL;
import org.example.algorithm.DLLNode;
import org.example.exception.KeyNotFoundException;
import org.example.model.Element;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LFUCachingStrategy<K> implements ICachingStrategy<K> {
    TreeMap<Integer, DLL<K>> lfuMap;
    Map<K, Element<K>> countMap;

    public LFUCachingStrategy() {
        this.lfuMap = new TreeMap<>();
        this.countMap = new HashMap<>();
    }

    @Override
    public void keyAccessed(K key) {
        if (countMap.containsKey(key)) {
           Element<K> node = countMap.get(key);

           //remove from existing count list
           Integer count = node.getCount();
           DLL<K> dll = lfuMap.get(count);
           dll.removeNode(node.getNode());
           if(dll.isListEmpty()) {
               lfuMap.remove(count);
           }

           //incrementing count
           node.incrementCount();
           //checking if treemap contains list for new counter
            addToLFUMap(node);
        } else  {
            //key is not present
            //create new node
            DLLNode<K> newNode = new DLLNode<>(key);
            //put in countmap
            Element<K> newElement = new Element<K>(newNode);
            countMap.put(key, newElement);

            //check if tree map contains list for new counter and add it to tree map
            addToLFUMap(newElement);
        }
    }

    private void addToLFUMap(Element<K> element) {
        if(!lfuMap.containsKey(element.getCount())) {
            lfuMap.put(element.getCount(), new DLL<K>());
        }
        lfuMap.get(element.getCount()).addToLast(element.getNode());
    }

    @Override
    public K evictKey() {
        DLLNode<K> nodeToEvict = lfuMap.firstEntry().getValue().getFirstNode();
        //remove from list
        lfuMap.firstEntry().getValue().removeNode(nodeToEvict);

        //remove count from tree map if list is empty
        if(lfuMap.firstEntry().getValue().isListEmpty()) {
            Integer key = lfuMap.firstKey();
            lfuMap.remove(key);
        }

        //remove node from count map
        countMap.remove(nodeToEvict.getElement());

        return nodeToEvict.getElement();
    }

    @Override
    public void removeKey(K key) {
        if(!countMap.containsKey(key)) {
            throw new KeyNotFoundException();
        } else {
            Element<K> elementToRemove = countMap.get(key);

            //remove from count map
            countMap.remove(key);

            //remove from dll map
            lfuMap.get(elementToRemove.getCount()).removeNode(elementToRemove.getNode());
            //check if dll is empty
            if(lfuMap.get(elementToRemove.getCount()).isListEmpty()) {
                lfuMap.remove(elementToRemove.getCount());
            }
        }
    }
}
