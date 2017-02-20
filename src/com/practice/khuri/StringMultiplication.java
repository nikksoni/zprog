package com.practice.khuri;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikhilesh.Soni on 07-02-2017.
 */
public class StringMultiplication {
    public static void main(String[] args){
        String number = "1234567890123456789012345678901234567890";
        List<String> numArr=splitNumToSmallStrings(number,6);
        for(String num: numArr){
            System.out.println( num);
        }

    }

    private static List<String> splitNumToSmallStrings(String num, int chunkNum) {
        int start = num.length() - chunkNum;
        int end = num.length();
        List<String> numList = new ArrayList<String>();
        while (end > 0) {
            start = start >= 0 ? start : 0;
            String numAchieved = num.substring(start, end);
            numList.add(numAchieved);
            start -= chunkNum;
            end -= chunkNum;
        }
        return  numList;
    }
}
