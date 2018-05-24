package com.wt.algorithm4.chapter2_1;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author WuTian
 * @date 2018-05-23 10:30
 * @description
 */
public class QuickSort {
    private static int[] candidates = new int[16];

    public static void main(String[] args) {
        init();
        quickSort(0, candidates.length - 1);
        System.out.println(Arrays.toString(candidates));
    }

    private static void quickSort(int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right;
        while (i != j) {
            while (candidates[j] >= candidates[left] && j > i) {
                j--;
            }
            while (candidates[i] <= candidates[left] && i < j) {
                i++;
            }
            if (i < j) {
                swap(i, j);
            }
        }
        swap(left, i);
        quickSort(left, i - 1);
        quickSort(j + 1, right);
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
