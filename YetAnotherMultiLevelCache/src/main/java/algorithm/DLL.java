package algorithm;

public class DLL<K> {
    DLLNode<K> head;
    DLLNode<K> tail;

    public DLL() {
        head = new DLLNode<>(null);
        tail = new DLLNode<>(null);
        head.next = tail;
        tail.prev = head;
    }

    public DLLNode<K> getFirst() {
        if(isEmpty()) {
            //TODO: throw relevant exception
        }
        return head.next;
    }

    public DLLNode<K> getLast() {
        if(isEmpty()) {
            //TODO: throw relevant exception
        }
        return tail.prev;
    }

    public DLLNode<K> insertFirst(DLLNode<K> newNode) {
        DLLNode<K> headNext = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = headNext;
        headNext.prev = newNode;
        return newNode;
    }

    public DLLNode<K> insertLast(DLLNode<K> newNode) {
        DLLNode<K> tailPrev = tail.prev;
        tail.prev = newNode;
        newNode.next = tail;
        newNode.prev = tailPrev;
        tailPrev.next = newNode;
        return newNode;
    }

    public void deleteNode(DLLNode<K> node) {
        if(isEmpty()) {
            //TODO: throw relevant exception
        }
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public boolean isEmpty() {
        return head.next == tail;
    }
}
