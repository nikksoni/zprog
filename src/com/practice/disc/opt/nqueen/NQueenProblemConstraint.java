package com.practice.disc.opt.nqueen;


/**
 * Created by Nikhilesh.Soni on 04-02-2017.
 */

public class NQueenProblemConstraint {
    public static void main(String[] args) {
        int N = 34;
        int[] counterArr = new int[N];
        int[][] chess = new int[N][N];
        long start = System.nanoTime();
        boolean check = nQueenPopulateFunction(1, 0, 0, chess, 0, counterArr);
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

    private static boolean nQueenPopulateFunction(int num, int row, int rowReached, int[][] chess, int column, int[] counterArr) {
        if (row >= chess.length || column >= chess.length || row < 0 || column < 0) {
            return false;
        }
        int currentColumnIndex = column;
        while (currentColumnIndex < chess.length) {
            if (chess[row][currentColumnIndex] == 0) {
                populateIQueenPositon(0, num, row, currentColumnIndex, chess, counterArr);
                int availableRowAgain = checkOnePositionLeftinRow(counterArr);
                if (availableRowAgain != -1) {
                    boolean isSuccess = nQueenPopulateFunction(num + 1, availableRowAgain, rowReached, chess, 0, counterArr);
                    if (isSuccess) {
                        return true;
                    } else {
                        populateIQueenPositon(num, 0, row, currentColumnIndex, chess, counterArr);
                        currentColumnIndex++;
                    }
                } else {
                    boolean isNextColumnAvailable = checkColumn(row + 1, 0, chess);
                    if (isNextColumnAvailable) {
                        boolean isSuccess = nQueenPopulateFunction(num + 1, row + 1, rowReached + 1, chess, 0, counterArr);
                        if (isSuccess) {
                            return true;
                        } else {
                            populateIQueenPositon(num, 0, row, currentColumnIndex, chess, counterArr);
                            currentColumnIndex++;
                        }
                    } else {
                        if (num == chess.length) {
                            return true;
                        }
                        populateIQueenPositon(num, 0, row, currentColumnIndex, chess, counterArr);
                        currentColumnIndex++;
                    }
                }
            } else {
                currentColumnIndex++;
            }

        }
        return false;
    }

    private static void populateIQueenPositon(int ini, int num, int row, int column, int[][] chess, int[] counterArr) {
        // printMatrix(chess);
        populateHorizontal(ini, num, row, column, chess, counterArr);
        populateNegDiagonal(ini, num, row, column, chess, counterArr);
        populateVertical(ini, num, row, column, chess, counterArr);
        populatePosDiagonal(ini, num, row, column, chess, counterArr);
    }

    private static void populateVertical(int ini, int num, int row, int column, int[][] chess, int[] counterArr) {
        for (int i = row; i < chess.length; i++) {
            if (chess[i][column] == ini || chess[i][column] == -ini) {
                if (num == 0 && ini != 0) {
                    counterArr[i]--;
                } else if (num != 0 && ini == 0) {
                    counterArr[i]++;
                }
                if (i != row) {
                    chess[i][column] = num;
                } else {
                    chess[i][column] = -num;
                }

            }
        }
    }

    private static void populateHorizontal(int ini, int num, int row, int column, int[][] chess, int[] counterArr) {
        for (int i = 0; i < chess.length; i++) {
            if (chess[row][i] == ini || chess[row][i] == -ini) {
                if (num == 0 && ini != 0) {
                    counterArr[row]--;
                } else if (num != 0 && ini == 0) {
                    counterArr[row]++;
                }
                if (i != column) {
                    chess[row][i] = num;
                } else {
                    chess[row][i] = -num;
                }

            }
        }
    }

    private static void populatePosDiagonal(int ini, int num, int row, int column, int[][] chess, int[] counterArr) {
        for (int i = 0; i < chess.length; i++) {
            if ((i + row) < chess.length && (i + column) < chess.length) {
                if (chess[row + i][column + i] == ini || chess[row + i][column + i] == -ini) {
                    if (num == 0 && ini != 0) {
                        counterArr[row + i]--;
                    } else if (num != 0 && ini == 0) {
                        counterArr[row + i]++;
                    }
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

        for (int i = 1; i < chess.length; i++) {
            if ((row - i) >= 0 && (column - i) >= 0) {
                if (chess[row - i][column - i] == ini || chess[row - i][column - i] == -ini) {
                    if (num == 0 && ini != 0) {
                        counterArr[row - i]--;
                    } else if (num != 0 && ini == 0) {
                        counterArr[row - i]++;
                    }
                    chess[row - i][column - i] = num;
                }
            } else {
                break;
            }
        }

    }

    private static void populateNegDiagonal(int ini, int num, int row, int column, int[][] chess, int[] counterArr) {
        for (int i = 0; i < chess.length; i++) {
            if ((row + i) < chess.length && (column - i) >= 0) {
                if (chess[row + i][column - i] == ini || chess[row + i][column - i] == -ini) {
                    if (num == 0 && ini != 0) {
                        counterArr[row + i]--;
                    } else if (num == 0 && ini != 0) {
                        counterArr[row + i]++;
                    }
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
        for (int i = 1; i < chess.length; i++) {
            if ((column + i) < chess.length && (row - i) >= 0) {
                if (chess[row - i][column + i] == ini || chess[row - i][column + i] == -ini) {
                    if (num == 0 && ini != 0) {
                        counterArr[row - i]--;
                    } else if (num == 0 && ini != 0) {
                        counterArr[row - i]++;
                    }
                    chess[row - i][column + i] = num;
                }
            } else {
                break;
            }
        }
    }

    private static int checkOnePositionLeftinRow(int[] counterArr) {
        for (int i = 0; i < counterArr.length; i++) {
            if (counterArr[i] == counterArr.length - 1) {
                return i;
            }
        }
        return -1;
    }

    private static void printMatrix(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess.length; j++) {
                if (chess[i][j] < 0) {
                    System.out.print(chess[i][j] + " ");
                } else {
                    System.out.print(" " + chess[i][j] + " ");
                }
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
