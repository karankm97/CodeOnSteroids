package org.example.algorithm;

import org.example.algorithm.exception.InvalidElementException;
import org.example.algorithm.exception.ListEmptyException;

public class DoublyLinkedList<K> {
    DoublyLinkedListNode<K> dummyHead;
    DoublyLinkedListNode<K> dummyTail;

    public DoublyLinkedList() {
        dummyHead = new DoublyLinkedListNode<>(null);
        dummyTail = new DoublyLinkedListNode<>(null);
        dummyTail.prev = dummyHead;
        dummyHead.next = dummyTail;
    }

    public void searchAndRemove(K key) {
        if(key == null) {
            throw new InvalidElementException();
        }
        DoublyLinkedListNode<K> temp = dummyHead.next;
        while (temp != dummyTail) {
            if(temp.getElement() == key) {
                break;
            }
        }
        if (temp == dummyTail) {
            return;
        }
        deleteNode(temp);
    }

    //add to first
    public DoublyLinkedListNode<K> addFirst(DoublyLinkedListNode<K> node) {
        if(node == null) {
            throw new InvalidElementException();
        }
        node.next = dummyHead.next;
        dummyHead.next.prev = node;
        node.prev = dummyHead;
        dummyHead.next = node;
        return node;
    }

    //get first
    public DoublyLinkedListNode<K> getFirst() {
        if(isListEmpty()) {
            return null;
        }
        return dummyHead.next;
    }

    //add to last
    public DoublyLinkedListNode<K> addLast(DoublyLinkedListNode<K> node) {
        if(node == null) {
            throw new InvalidElementException();
        }
        dummyTail.prev.next = node;
        node.prev = dummyTail.prev;
        node.next = dummyTail;
        dummyTail.prev = node;
        return node;
    }

    //get from last
    public DoublyLinkedListNode<K> getLast() {
        if(isListEmpty()) {
            return null;
        }
        return dummyTail.prev;
    }

    //delete node
    public void deleteNode(DoublyLinkedListNode<K> node) {
        if(isListEmpty()) {
            throw new ListEmptyException();
        }
        if(node == null) {
            throw new InvalidElementException();
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public boolean isListEmpty() {
        return dummyHead.next == dummyTail;
    }
}
