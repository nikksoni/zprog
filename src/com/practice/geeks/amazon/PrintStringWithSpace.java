package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 18-04-2017.
 * Input:  str[] = "ABC"
 * Output: ABC
 * AB C
 * A BC
 * A B C
 */
public class PrintStringWithSpace {
    public static void main(String[] args) {
        String input = "ABCD";
        StringBuilder builder = new StringBuilder(input);
        printPattern(1, builder, builder.length());

    }


    public static StringBuilder printPattern(int i, StringBuilder input, int size) {
        if (i == input.length()) {
            if (input.length() != size)
                System.out.println(input.toString());
        } else if (i > input.length()) {
        } else {

            input = input.insert(i, ' ');
            printPattern(i + 2, input, size);
            input = input.deleteCharAt(i);
            printPattern(i + 1, input, size);
        }
        return input;
    }
}
