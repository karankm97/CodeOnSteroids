package algorithm;

public class DLLNode<K> {
    DLLNode<K> prev;
    DLLNode<K> next;
    public K element;

    public DLLNode(K element) {
        prev = null;
        next = null;
        this.element = element;
    }
}
