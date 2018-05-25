package com.wt.algorithm4.chapter2_1;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * @author WuTian
 * @date 2018-05-23 10:30
 * @description
 */
public class QuickSort {
    private static int[] initCandidates = new int[16];

    public static void main(String[] args) {
        init();
        quickSort(initCandidates, 0, initCandidates.length - 1);
        System.out.println(Arrays.toString(initCandidates));
    }

    public static void quickSort(int[] candidates, int left, int right) {
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
                swap(candidates, i, j);
            }
        }
        swap(candidates, left, i);
        quickSort(candidates, left, i - 1);
        quickSort(candidates, j + 1, right);
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
