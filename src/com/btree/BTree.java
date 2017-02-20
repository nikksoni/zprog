package com.btree;

/**
 * Created by Nikhilesh.Soni on 05-02-2017.
 */
public class BTree {
    private int node;
    private BTree left;
    private BTree right;
    private int value;

    public int getNode() {
        return node;
    }

    public void setNode(int node) {
        this.node = node;
    }

    public BTree getLeft() {
        return left;
    }

    public void setLeft(BTree left) {
        this.left = left;
    }

    public BTree getRight() {
        return right;
    }

    public void setRight(BTree right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
