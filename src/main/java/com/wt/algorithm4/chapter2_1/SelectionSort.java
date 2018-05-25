package com.wt.algorithm4.chapter2_1;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    private static int[] initCandidates = new int[20];

    public static void main(String[] args) {
        init();
        selectionSort(initCandidates);
        System.out.println(Arrays.toString(initCandidates));
    }

    public static void selectionSort(int[] candidates) {
        for (int i = 0; i < candidates.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < candidates.length; j++) {
                if (candidates[j] < candidates[min]) {
                    min = j;
                }
            }
            if (min != i) {
                swap(candidates, i, min);
            }
        }
    }

    private static void swap(int[] candidates, int a, int b) {
        int temp = candidates[a];
        candidates[a] = candidates[b];
        candidates[b] = temp;
    }

    private static void init() {
        Random rad = new Random();
        for (int i = 0; i < initCandidates.length; i++) {
            initCandidates[i] = rad.nextInt(100);
        }
        System.out.println(Arrays.toString(initCandidates));
    }
}
