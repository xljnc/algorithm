package com.wt.dsaainjava.chapter3;

import java.util.Arrays;

/**
 * @author WuTian
 * @date 2018-06-05 14:45
 * @description 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] data = {3, 5, 70, 71, 74, 43, 12, 46, 15, 51, 20, 56, 57, 25, 60, 93, 30, 94, 95};
        //int[] data = {3, 2, 1};
        System.out.println("array before selection sort:" + Arrays.toString(data));
        selectionSort(data);
        System.out.println("array after selection sort:" + Arrays.toString(data));
    }

    public static void selectionSort(int[] data) {
        for (int i = 0; i < (data.length - 1); i++) {
            int min = i;
            for (int j = (i + 1); j < data.length; j++) {
                if (data[j] < data[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(data, i, min);
            }
        }
    }

    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
