package org.example.algorithm;

import lombok.Getter;

@Getter
public class DoublyLinkedListNode<K> {
    DoublyLinkedListNode prev;
    DoublyLinkedListNode next;
    K element;

    public DoublyLinkedListNode(K element) {
        this.element = element;
    }
}
