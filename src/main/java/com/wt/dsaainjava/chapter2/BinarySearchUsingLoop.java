package com.wt.dsaainjava.chapter2;

import java.util.Arrays;
import java.util.Random;

/**
 * @author WuTian
 * @date 2018-05-31 17:09
 * @description 二分查找，使用循环
 */
public class BinarySearchUsingLoop {

    public static void main(String[] args) {
        int[] a = {1, 2, 13, 16, 25, 26, 35, 36, 42, 49, 50, 60, 63, 68, 77, 83, 93, 96, 98};
        System.out.println(Arrays.toString(a));
        int index = binarySearch(a, 50);
        System.out.println((index == -1) ? "Key not found!" : ("Key at index " + index));
    }

    public static int binarySearch(int[] src, int searchKey) {
        int start = 0;
        int end = src.length - 1;
        int mid;
        if (src[start] == searchKey) {
            return start;
        }
        if (src[end] == searchKey) {
            return end;
        }
        while (start <= end) {
            mid = (start + end) / 2;
            if (searchKey == src[mid]) {
                return mid;
            } else if (searchKey < src[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
