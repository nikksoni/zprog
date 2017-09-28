package com.btree;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nikhilesh.Soni on 19-09-2017.
 */
public class Solution {

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */

        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        Integer rows = Integer.parseInt(n);
        for (int i = 0; i < rows; i++) {
            String input = scanner.nextLine();
            buildString(input);

        }
    }

    private static void buildString(String input) {
        String s = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (int j = 0; j < input.length(); j++) {
            if ((input.charAt(j) >= 65 && input.charAt(j) <= 90) || (input.charAt(j) >= 97 && input.charAt(j) <= 122) || (input.charAt(j) >= 48 && input.charAt(j) <= 57)) {
                stringBuilder.append(input.charAt(j));
            }
            if (input.charAt(j) == ' ') {
                if(s!=null)
                s = stringBuilder.toString() + " " + s;
                else s = stringBuilder.toString();
                stringBuilder = new StringBuilder();
            }
        }
        s = stringBuilder.toString() +" " + s;
        System.out.println(appendSpecial(s, input));

    }

    private static String appendSpecial(String string, String input) {
        String s = "";
        StringBuilder stringBuilder = new StringBuilder();
        int wordCount = 0;
        Map<Integer, String> sp = new LinkedHashMap<Integer, String>();
        for (int j = 0; j < input.length(); j++) {
            if (!((input.charAt(j) >= 65 && input.charAt(j) <= 90) || (input.charAt(j) >= 97 && input.charAt(j) <= 122) || (input.charAt(j) >= 48 && input.charAt(j) <= 57))) {
                if (input.charAt(j) == ' ') {
                    wordCount++;
                } else {
                    String s1 = sp.get(wordCount);
                    if (s1 == null) {
                        s1 = "";
                    }
                    s1 = s1 + input.charAt(j);
                    sp.put(wordCount, s1);
                }
            }

        }
        String output = "";
        wordCount = 0;
        int startIndex = 0;
        for (int i = 0; i < string.length(); i++) {
            String ss = sp.get(wordCount);
            if (string.charAt(i) == ' ') {
                if (ss != null) {
                    output = output + string.substring(startIndex, i) + ss;
                    startIndex = i;
                }
                wordCount++;
            }
        }
        output = output + string.substring(startIndex, string.length());
        String last = sp.get(wordCount);
        if (last != null) {
            output += last;
        }
        return output;
    }
}