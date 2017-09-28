package com.practice.khuri;

/**
 * Created by Nikhilesh.Soni on 27-09-2017.
 */
public class RatMazeTraversal {
    private static int rowMax = 3, colMax = 3;

    public static void main(String[] args) {
        int[][] ratmaze = new int[][]{{0, 1, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        rowMax = ratmaze.length - 1;
        colMax = ratmaze[0].length - 1;
        boolean[][] isVisited = new boolean[ratmaze.length][ratmaze[0].length];
        printRatMaze(ratmaze, isVisited, 0, 0, new StringBuilder());
    }

    private static void printRatMaze(int[][] ratMaze, boolean[][] isVisited, int rowIndex, int columnIndex, StringBuilder builder) {
        isVisited[rowIndex][columnIndex] = true;
        builder.append("{" + rowIndex + "-" + columnIndex + "} ");
        if (rowIndex == rowMax && columnIndex == colMax) {
            System.out.println(builder.toString());
        }
        int newRowIndex = rowIndex - 1, newColIndex = columnIndex;
        if (newRowIndex >= 0 && newRowIndex <= rowMax && newColIndex >= 0 && newColIndex <= colMax) {
            if (!isVisited[newRowIndex][newColIndex] && ratMaze[newRowIndex][newColIndex] == 0) {
                printRatMaze(ratMaze, isVisited, newRowIndex, newColIndex, builder);
            }
        }
        newRowIndex = rowIndex + 1;
        if (newRowIndex >= 0 && newRowIndex <= rowMax && newColIndex >= 0 && newColIndex <= colMax) {
            if (!isVisited[newRowIndex][newColIndex] && ratMaze[newRowIndex][newColIndex] == 0) {
                printRatMaze(ratMaze, isVisited, newRowIndex, newColIndex, builder);
            }
        }
        newRowIndex = rowIndex;
        newColIndex = columnIndex + 1;
        if (newRowIndex >= 0 && newRowIndex <= rowMax && newColIndex >= 0 && newColIndex <= colMax) {
            if (!isVisited[newRowIndex][newColIndex] && ratMaze[newRowIndex][newColIndex] == 0) {
                printRatMaze(ratMaze, isVisited, newRowIndex, newColIndex, builder);
            }
        }
        newColIndex = columnIndex - 1;
        if (newRowIndex >= 0 && newRowIndex <= rowMax && newColIndex >= 0 && newColIndex <= colMax) {
            if (!isVisited[newRowIndex][newColIndex] && ratMaze[newRowIndex][newColIndex] == 0) {
                printRatMaze(ratMaze, isVisited, newRowIndex, newColIndex, builder);
            }
        }
        builder.delete(builder.length() - 6, builder.length());
        isVisited[rowIndex][columnIndex] = false;
    }
}
