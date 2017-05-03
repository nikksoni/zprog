package com.practice.geeks.amazon;

/**
 * Created by Nikhilesh.Soni on 15-04-2017.
 */
public class PrintDiagonalMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 4, 6, 7}, {3, 5, 2, 3, 5}, {44, 33, 22, 55, 66}};
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int counter = 0;
        boolean check = true;
        int columnCounter = 0;
        int rowCounter = 0;
        while (counter <= row + column - 1) {
            if (columnCounter >= column) {
                columnCounter = column - 1;
                rowCounter = counter - columnCounter;
            } else if (rowCounter >= row) {
                rowCounter = row - 1;
                columnCounter = counter - rowCounter;
            } else if (columnCounter < 0) {
                rowCounter = counter;
                columnCounter = 0;
            } else if (rowCounter < 0) {
                columnCounter = counter;
                rowCounter = 0;
            }
            while (rowCounter >= 0 && columnCounter >= 0 && rowCounter < row && columnCounter < column) {
                System.out.print(matrix[rowCounter][columnCounter] + " => ");
                if (check) {
                    rowCounter--;
                    columnCounter++;
                } else {
                    rowCounter++;
                    columnCounter--;
                }
            }
            counter++;
           /* if (rowCounter < 0 || columnCounter >=column )
                check = false;
            if(columnCounter<0|| rowCounter>=row)
                check=true;*/
            check = !check;
        }


    }
}
