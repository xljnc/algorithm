package com.wt.algorithm4.chapter2_1;

import java.util.Arrays;
import java.util.Random;

public class BubbleSort {

    private static int[] candidates = new int[20];

    public static void main(String[] args) {
        init();
        bubbleSort();
    }

    public static void bubbleSort() {
        for (int i = 0; i < candidates.length - 1; i++) {
            for (int j = 0; j < candidates.length - i - 1; j++) {
                if (candidates[j] > candidates[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
        System.out.println(Arrays.toString(candidates));
    }

    private static void init() {
        Random rad = new Random();
        for (int i = 0; i < candidates.length; i++) {
            candidates[i] = rad.nextInt(100);
        }
        System.out.println(Arrays.toString(candidates));
    }

    private static void swap(int a, int b) {
        int temp = candidates[a];
        candidates[a] = candidates[b];
        candidates[b] = temp;
    }
}
