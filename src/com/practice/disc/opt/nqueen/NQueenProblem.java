package com.practice.disc.opt.nqueen;

/**
 * NQueens to be placed in NxN chessBoard So that no one can point each other
 */

public class NQueenProblem {
    public static void main(String[] args) {
        int N = 30;
        int[][] chess = new int[N][N];
        long start = System.nanoTime();
        boolean check = nQueenPopulateFunction(1, 0, 0, chess);
        System.out.println((System.nanoTime() - start));
        if (check) {
            printQueen(chess);
        }

    }

    private static boolean checkColumn(int row, int column, int[][] chess) {
        if (row >= chess.length) {
            return false;
        }
        for (int r = row; r < chess.length; r++) {
            boolean check = false;
            for (int i = column; i < chess.length; i++) {
                if (chess[r][i] == 0) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                return false;
            }
        }
        return true;
    }

    private static boolean nQueenPopulateFunction(int num, int row, int column, int[][] chess) {
        if (row >= chess.length || column >= chess.length || row < 0 || column < 0) {
            return false;
        }
        int currentColumnIndex = column;
        while (currentColumnIndex < chess.length) {
            if (chess[row][currentColumnIndex] == 0) {
                populateIQueenPositon(0, num, row, currentColumnIndex, chess);
                boolean isNextColumnAvailable = checkColumn(row + 1, 0, chess);

                if (isNextColumnAvailable) {
                    boolean isSuccess = nQueenPopulateFunction(num + 1, row + 1, 0, chess);
                    if (isSuccess) {
                        return true;
                    } else {
                        populateIQueenPositon(num, 0, row, currentColumnIndex, chess);
                        currentColumnIndex++;
                    }
                } else {
                    if (num == chess.length) {
                        return true;
                    }
                    populateIQueenPositon(num, 0, row, currentColumnIndex, chess);
                    currentColumnIndex++;
                }

            } else {
                currentColumnIndex++;
            }

        }
        return false;
    }

    private static void populateIQueenPositon(int ini, int num, int row, int column, int[][] chess) {
        // printMatrix(chess);
        populateHorizontal(ini, num, row, column, chess);
        populateNegDiagonal(ini, num, row, column, chess);
        populateVertical(ini, num, row, column, chess);
        populatePosDiagonal(ini, num, row, column, chess);
    }

    private static void populateVertical(int ini, int num, int row, int column, int[][] chess) {
        for (int i = row; i < chess.length; i++) {
            if (chess[i][column] == ini || chess[i][column] == -ini) {
                if (i != row) {
                    chess[i][column] = num;
                } else {
                    chess[i][column] = -num;
                }

            }
        }
    }

    private static void populateHorizontal(int ini, int num, int row, int column, int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            if (chess[row][i] == ini || chess[row][i] == -ini) {
                if (i != column) {
                    chess[row][i] = num;
                } else {
                    chess[row][i] = -num;
                }

            }
        }
    }

    private static void populatePosDiagonal(int ini, int num, int row, int column, int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            if ((i + row) < chess.length && (i + column) < chess.length) {
                if (chess[row + i][column + i] == ini || chess[row + i][column + i] == -ini) {
                    if (i != 0) {
                        chess[row + i][column + i] = num;
                    } else {
                        chess[row + i][column + i] = -num;
                    }
                }
            } else {
                break;
            }
        }
    }

    private static void populateNegDiagonal(int ini, int num, int row, int column, int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            if ((row + i) < chess.length && (column - i) >= 0) {
                if (chess[row + i][column - i] == ini || chess[row + i][column - i] == -ini) {
                    if (i != 0) {
                        chess[row + i][column - i] = num;
                    } else {
                        chess[row + i][column - i] = -num;
                    }

                }
            } else {
                break;
            }
        }
    }

    private static void printMatrix(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }

    private static void printQueen(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] < 0) {
                    System.out.print("* ");
                } else {
                    System.out.print(". ");
                }

            }
            System.out.println();
        }
        System.out.println();
        System.out.println();

    }

}
