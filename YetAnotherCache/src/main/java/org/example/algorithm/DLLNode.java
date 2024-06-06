package org.example.algorithm;

import lombok.Getter;

@Getter
public class DLLNode<K> {
    DLLNode<K> prev;
    DLLNode<K> next;
    K element;

    public DLLNode(K element) {
        this.element = element;
        this.prev = null;
        this.next = null;
    }
}
