package com.wt.dsaainjava.chapter2;

import java.util.Arrays;

/**
 * @author WuTian
 * @date 2018-05-31 18:53
 * @description 二分查找，使用递归
 */
public class BinarySearchUsingRecursion {

    public static void main(String[] args) {
        int[] a = {1, 2, 13, 16, 25, 26, 35, 36, 42, 49, 50, 60, 63, 68, 77, 83, 93, 96, 98};
        System.out.println(Arrays.toString(a));
        int index = binarySearch(a, 36, 0, a.length);
        System.out.println((index == -1) ? "Key not found!" : ("Key at index " + index));
    }

    public static int binarySearch(int[] src, int searchKey, int start, int end) {
        if (start <= end) {
            int mid = (start + end) / 2;
            if (searchKey == src[mid]) {
                return mid;
            } else if (searchKey < src[mid]) {
                return (binarySearch(src, searchKey, start, mid - 1));
            } else {
                return (binarySearch(src, searchKey, mid + 1, end));
            }
        } else {
            return -1;
        }
    }

}
