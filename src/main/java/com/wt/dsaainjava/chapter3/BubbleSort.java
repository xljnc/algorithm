package com.wt.dsaainjava.chapter3;

import java.util.Arrays;

/**
 * @author WuTian
 * @date 2018-06-04 11:22
 * @description
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] data = {3, 5, 70, 71, 74, 43, 12, 46, 15, 51, 20, 56, 57, 25, 60, 93, 30, 94, 95};
        //int[] data = {3, 2, 1};
        System.out.println("array before bubble sort:" + Arrays.toString(data));
        bubbleSort(data);
        System.out.println("array after bubble sort:" + Arrays.toString(data));
    }

    public static void bubbleSort(int[] data) {
        for (int i = (data.length - 1); i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    swap(data, j, j + 1);
                }
            }
        }
    }

    private static void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
