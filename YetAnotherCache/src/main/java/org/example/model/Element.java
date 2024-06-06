package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.algorithm.DLLNode;


@Setter
public class Element<K> {
    DLLNode<K> node;
    Integer count;

    public  Element(DLLNode<K> node) {
        this.node = node;
        this.count = 1;
    }

    public void incrementCount() {
        count = count + 1;
    }

    public DLLNode<K> getNode() {
        return node;
    }

    public Integer getCount() {
        return count;
    }
}
