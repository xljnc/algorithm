package com.wt.algorithm4.chapter1_1;

/**
 * @Author WuTian
 * @Date 2018-04-10 19:09
 */
public class Exercise13 {
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(matrix[j][i]);
            }
            System.out.println();
        }

    }


    public static void main(String[] args) {
        int[][] a = {{100, 200, 300}, {400, 500, 600}};
        printMatrix(a);
    }
}
