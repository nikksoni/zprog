package com.practice.lru;

/**
 * Created by Nikhilesh.Soni on 07-09-2017.
 */
public class QNode {
    QNode previous, next;
    Integer value;
    Integer key;

    public QNode(QNode previous, QNode next, Integer value, Integer key) {
        this.previous = previous;
        this.next = next;
        this.value = value;
        this.key = key;
    }

    public QNode getPrevious() {
        return previous;
    }

    public void setPrevious(QNode previous) {
        this.previous = previous;
    }

    public QNode getNext() {
        return next;
    }

    public void setNext(QNode next) {
        this.next = next;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }
}
