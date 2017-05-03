package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 21-04-2017.
 */
public class PrintIterationOfString {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder("BAA");
        printFunction(builder, 0);

    }

    public static StringBuilder printFunction(StringBuilder input, int index) {
        if (index == input.length() - 1) {
            System.out.println(input.toString());
        }
        if (index <= input.length() - 2)
        input = printFunction(input, index+1);
        for (int j = index + 1; j < input.length(); j++) {
            if (input.charAt(index) != input.charAt(j)) {
                input = swap(input, index, j);
                input = printFunction(input, index + 1);
                input = swap(input, j, index);
            }
        }
        return input;
    }

    public static StringBuilder swap(StringBuilder input, int i, int j) {
        if (i >= input.length() || j >= input.length())
            return null;
        char c = input.charAt(i);
        input.setCharAt(i, input.charAt(j));
        input.setCharAt(j, c);
        return input;
    }
}
