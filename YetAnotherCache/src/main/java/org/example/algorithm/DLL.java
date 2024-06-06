package org.example.algorithm;

import org.example.exception.EmptyDLLException;
import org.example.exception.InvalidElementException;

public class DLL<K> {
    DLLNode<K> head;
    DLLNode<K> tail;

    public DLL() {
        this.head = new DLLNode<K>(null);
        this.tail = new DLLNode<K>(null);
        head.next = tail;
        tail.prev = head;
    }

    //addToLast
    public DLLNode<K> addToLast(DLLNode<K> newNode) {
        if(newNode == null) {
            throw new InvalidElementException();
        }
        //DLLNode<K> newNode = new DLLNode<K>(element);
        tail.prev.next = newNode;
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev = newNode;
        return newNode;
    }

    //addToFirst
    public DLLNode<K> addToFirst(DLLNode<K> newNode) {
        if(newNode == null) {
            throw  new InvalidElementException();
        }
        //DLLNode<K> newNode = new DLLNode<K>(element);
        head.next.prev = newNode;
        newNode.next = head.prev;
        newNode.prev= head;
        head.next = newNode;
        return newNode;
    }

    //removeNode
    public void removeNode(DLLNode<K> node) {
        if(node == null) {
            throw new InvalidElementException();
        }
        if(head.next == tail) {
            throw new EmptyDLLException();
        }

        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    //getFirstNode
    public DLLNode<K> getFirstNode() {
        if(head.next == tail) {
            throw new EmptyDLLException();
        }
        return head.next;
    }

    //getLastNode
    public DLLNode<K> getLastNode() {
        if(head.next == tail) {
            throw new EmptyDLLException();
        }
        return tail.prev;
    }

    //is list empty
    public boolean isListEmpty() {
        return head.next == tail;
    }
}
