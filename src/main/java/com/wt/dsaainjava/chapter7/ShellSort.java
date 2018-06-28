package com.wt.dsaainjava.chapter7;

/**
 * @author WuTian
 * @date 2018-06-28 11:14
 * @description 原书上的代码是有问题的
 */
public class ShellSort {
    private static int[] src;

    public static void main(String[] args) {
        src = new int[]{3, 5, 70, 71, 74, 43, 93, 12, 46, 15, 51, 20, 95, 56, 57, 25, 60, 30, 94};
        shellSort();
        display();
    }

    private static void shellSort() {
        int h = 1;
        while ((h * 3 + 1) < src.length) {
            h = h * 3 + 1;
        }
        int temp;
        int j;
        while (h > 0) {
            for (int i = h; i < src.length; i++) {
                temp = src[i];
                j = i;
                while (j > h && src[j - h] > temp) {
                    src[j] = src[j - h];
                    j -= h;
                }
                src[j] = temp;
            }
            h = (h - 1) / 3;
        }
    }

    private static void display() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < src.length; i++) {
            if (i != 0)
                sb.append(" ");
            sb.append(src[i]);
        }
        System.out.println(sb.toString());
    }
}
