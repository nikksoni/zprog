package com.btree;

/**
 * Created by Nikhilesh.Soni on 20-09-2017.
 */
public class BTreeNode {
    private BTreeNode leftChild, rightChild;
    private int value;

    public BTreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BTreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public BTreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BTreeNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
