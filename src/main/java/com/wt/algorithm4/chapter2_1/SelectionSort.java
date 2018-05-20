package com.wt.algorithm4.chapter2_1;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    private static int[] candidates = new int[20];

    public static void main(String[] args) {
        init();
        selectionSort();
    }

    public static void init() {
        Random rad = new Random();
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = rad.nextInt(100);
        }
        System.out.println(Arrays.toString(candidates));
    }

    public static void selectionSort() {
        for (int i = 0; i < (candidates.length - 1); i++) {
            int min = i;
            for (int j = (i + 1); j < candidates.length; j++) {
                if (candidates[j] < candidates[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(i, min);
            }
        }
        System.out.println(Arrays.toString(candidates));
    }

    public static void swap(int a, int b) {
        int temp = candidates[a];
        candidates[a] = candidates[b];
        candidates[b] = temp;
    }
}
