package com.practice.geeks.amazon;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nikhilesh.Soni on 25-04-2017.
 */
public class NonIntersectingBridge {

    public static void main(String[] args) throws ParseException {
//int[] arr1 = new int[]{1,2, 6, 7, 8, 3, 4, 5};
//int[] arr2 = new int[]{3,6, 1, 2, 4, 8, 7, 5};
        int[] arr1 = new int[]{1,2, 3,4,5,6,7};
        int[] arr2 = new int[]{1, 7,3,4, 2,6,5};

        Map<Integer, Integer> pairIndexArr = new HashMap<>();
        for(int i=0;i< arr2.length;i++){
            pairIndexArr.put(new Integer(arr2[i]), new Integer(i));
        }
        int maxBridge = findNonIntersectingBridges(arr1, arr2, pairIndexArr, 0, 0);
        System.out.print(maxBridge);

    }

    public static int findNonIntersectingBridges(int[] arr1, int[] arr2, Map<Integer, Integer> pairIndexArr, int index1, int index2){
        int length1 = arr1.length;
        int length2 = arr2.length;

        if(length1 == 0 || length2 == 0 || index1 >= length1){
            return 0;
        }

        int sumExcluding = findNonIntersectingBridges(arr1, arr2, pairIndexArr, index1+1, index2);

        boolean pairExists =false;
        Integer pairIndex = pairIndexArr.get(new Integer(arr1[index1]));
        if(pairIndex!=null && (pairIndex >= index2) && (pairIndex <= (length2-1))){
            pairExists = true;
        }

        int sumIncluding = 0;
        if(pairExists){
            sumIncluding = 1 + findNonIntersectingBridges(arr1, arr2, pairIndexArr, index1+1, pairIndex+1);
        }

        return sumExcluding>sumIncluding?sumExcluding:sumIncluding;
    }
}
