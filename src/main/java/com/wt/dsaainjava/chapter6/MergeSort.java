package com.wt.dsaainjava.chapter6;

/**
 * @author WuTian
 * @date 2018-06-27 15:18
 * @description
 */
public class MergeSort {

    private static int[] temp;
    private static int[] src;

    public static void main(String[] args) {
        src = new int[]{3, 5, 70, 71, 74, 43, 12, 46, 15, 51, 20, 56, 57, 25, 60, 93, 30, 94, 95};
        temp = new int[src.length];
        recMerge(0, src.length - 1);
        display();
    }

    private static void recMerge(int start, int end) {
        if (start >= end)
            return;
        int mid = (start + end) / 2;
        recMerge(start, mid);
        recMerge(mid + 1, end);
        merge(start, mid, end);
    }

    private static void merge(int start, int mid, int end) {
        int oriStart = start;
        int leftPoint = start;
        int rightPoint = mid + 1;
        while (leftPoint <= mid && rightPoint <= end) {
            if (src[leftPoint] <= src[rightPoint])
                temp[start++] = src[leftPoint++];
            else
                temp[start++] = src[rightPoint++];
        }
        while (leftPoint <= mid) {
            temp[start++] = src[leftPoint++];
        }
        while (rightPoint <= end) {
            temp[start++] = src[rightPoint++];
        }
        for (int i = oriStart; i <= end; i++) {
            src[i] = temp[i];
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
