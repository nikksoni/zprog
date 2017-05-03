package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 11-04-2017.
 *
 * Statement:  It’s a two player game. Both the players are equally intelligent to win the game. Give n no. of stones. A player can choose either 1 stone or k stones or l stone (1<k<l). Suppose player 'A' starts game then challenge was to identify the player who will win the game. Player who picks the last 1 stone or last k stone or last l stones win the game.
 */
public class MinMaxTwoPlayerGame {

    public static void main(String[] args){
        int ans=myFunction(5,true,new int[]{1,2,3});
        System.out.print("ans: "+ans);
    }


    public static int myFunction(int remaining, boolean turn, int[] options) {
        int value = -1;
        for (int option : options) {
            if (remaining > option) {
                int val = myFunction(remaining - option, !turn, options);
                if (value == -1) {
                    value = val;
                } else
                    value = turn ? (value > val ? value : val) : (value < val ? value : val);
            } else if(remaining == option){

            }
        }
        return value;
    }

    public static int max(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }

    public static int min(int[] arr) {
        int min = 0;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i])
                min = arr[i];
        }
        return min;
    }

}


