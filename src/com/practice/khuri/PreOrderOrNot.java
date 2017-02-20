package com.practice.khuri;

/**
 * Created by Nikhilesh.Soni on 17-02-2017.
 */
public class PreOrderOrNot {

    private static boolean isSUccess = false;

    public static void main(String[] args) {
        int[] input = new int[]{40, 30, 35, 20, 80, 100};
//        int[] input = new int[]{20,18,10,5,19};
        int ans = -1;
        if (input.length > 2) {
            ans = checkPreTraversalOrder(input, 0, 0, 1000);
            System.out.print(ans + "" + isSUccess);
        }
    }


    public static int checkPreTraversalOrder(int[] input, int index, int minVal, int maxValue) {
        if (input.length == index) {
            return index;
        } else if (input[index] < minVal || input[index] > maxValue) {
            return index;
        } else if (input.length - 1 == index) {
            return index + 1;
        } else {
            int lcIndex = index + 1;
            if (input[index + 1] < input[index]) {
                lcIndex = checkPreTraversalOrder(input, index + 1, minVal, input[index]);
                if (input.length == lcIndex) {
                    return lcIndex;
                }
            }
            int rcIndex = checkPreTraversalOrder(input, lcIndex, input[index], maxValue);
            return rcIndex;
        }
    }
}
