package com.wt.dsaainjava.chapter3;

import java.util.Arrays;

/**
 * @author WuTian
 * @date 2018-06-05 15:18
 * @description 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] data = {3, 5, 70, 71, 74, 43, 12, 46, 15, 51, 20, 56, 57, 25, 60, 93, 30, 94, 95};
//        int[] data = {3, 2, 1};
        System.out.println("array before insert sort:" + Arrays.toString(data));
        insertSort(data);
        System.out.println("array after insert sort:" + Arrays.toString(data));
    }

    public static void insertSort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int pivot = data[i];
            int j = i;
            while (j > 0 && data[j - 1] > pivot) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = pivot;
        }
    }

}
