package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 11-04-2017.
 */
public class ReverseLinkedListEveryK {


    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 4;
        Node start = populateLlist(input);
        printList(start);
        Node t = processFunctionNode(start, 4);
        System.out.println(" => ");
        printList(t);
        System.out.println(" => ");
        printList(start);

    }

    private static Node populateLlist(int[] input) {
        Node n = new Node();
        Node parentNode = n;
        int counter = 1;
        for (int inp : input) {
            if (counter < input.length)
                parentNode.setNext(new Node());
            counter++;
            parentNode.setValue(inp);
            parentNode = parentNode.getNext();


        }
        return n;
    }

    private static void printList(Node n) {
        while (n != null) {
            System.out.print(n.value);
            if (n.next != null) {
                System.out.print(" => ");
            }
            n = n.next;
        }

    }

    private static Node processFunctionNode(Node parent, int k) {
        Node returnNode = null;
        Node one = parent;
        Node two = parent.next;
        Node previousEndNode = null;

        while (parent != null) {
            Node currEndNode = one;
            for (int i = 1; i < k; i++) {
                if (two.next != null) {
                    Node temp = two.next;
                    two.next = one;
                    one = two;
                    two = temp;
                } else {
                    two.next = one;
                    previousEndNode.next = two;
                    currEndNode.next = null;
                    return returnNode;
                }
            }
            if (previousEndNode != null) {
                previousEndNode.next = one;
            }
            previousEndNode = currEndNode;
            if (returnNode == null) {
                returnNode = one;
            }
            one = two;
            two = two.next;
        }
        return two;
    }


    public static class Node {
        Node next;
        int value;

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }


}
