package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 20-04-2017.
 */
public class RevListEveryKRecursiveApproach {
    public static void main(String[] args) {
        int[] input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int k = 4;
        Node start = populateLlist(input);
        printList(start);
        Node t = processFunctionNode(start, 4);
        System.out.println(" => ");
        printList(t);

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

    private static Node processFunctionNode(Node currentNode, int k) {
        Node oneNode = currentNode;
        Node two = currentNode.getNext();
        oneNode.next = null;
        Node endNode = currentNode;

        for (int i = 1; i < k && two != null; i++) {
            if (two.next != null) {
                Node temp = two.next;
                two.next = oneNode;
                oneNode = two;
                two = temp;
            } else {
                two.next = oneNode;
                return two;
            }
        }
        if (two == null) {
            return oneNode;
        }
        if (two != null)
            endNode.next = processFunctionNode(two, k);
        return oneNode;
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
