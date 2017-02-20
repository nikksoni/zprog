package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 05-02-2017.
 */

/**
 * A binary tree and a number, say k are given.
 * Print every path in the tree with sum of the nodes in the path as k.
 * (A path can start from any node and end at any node, i.e. they need not be root node and leaf node;
 * and negative numbers can also be there in the tree)
 */
public class BTSumNodesK {


    public static void main(String[] args) {
        int[] bArray = new int[]{5,2,2,2,0,1,3,0,0,0,0,1,1,-1,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,-1,0};
        int size = bArray.length;
        int[][] dpArray = new int[size][size];
        System.out.println("size: "+bArray.length);
        for(int i=0;i<bArray.length;i++){
            dpArray[i][i]=bArray[i];
        }
        populatesDpArray(dpArray);
        for (int i = 0; i < dpArray.length; i++) {
            for (int j = 0; j < dpArray.length; j++) {
                System.out.print(dpArray[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println(dpArray[0][5]);





    }

    private static void populatesDpArray(int[][] dpArray) {
        for (int i = 0; i < dpArray.length; i++) {
            for (int j = i + 1; j < dpArray.length; j++) {
                dpArray[i][j] =dpArray[j][j] + dpArray[i][(j-1)/2];
                dpArray[j][i] = dpArray[i][j];
            }
        }

    }

   /* private static void traverseBTAndPopDP(int nodeIndex, int sumAchieved, int currNode, int[] bArray, int[][] dpArray) {
        int rc = (currNode * 2) + 2;
        int lc = (currNode * 2) + 1;
        if (rc <= bArray.length) {
            dpArray[nodeIndex][rc] = sumAchieved + bArray[rc];
            dpArray[rc][nodeIndex] = sumAchieved + bArray[rc];
            traverseBTAndPopDP(nodeIndex, dpArray[nodeIndex][rc], rc, bArray, dpArray);
        }
        if (lc <= bArray.length) {
            dpArray[nodeIndex][lc] = sumAchieved + bArray[lc];
            dpArray[lc][nodeIndex] = sumAchieved + bArray[lc];
            traverseBTAndPopDP(nodeIndex, dpArray[nodeIndex][lc], lc, bArray, dpArray);
        }

    }*/
}
