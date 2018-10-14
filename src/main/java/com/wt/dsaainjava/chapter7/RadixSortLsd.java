package com.wt.dsaainjava.chapter7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WuTian
 * @date 2018-06-29 14:16
 * @description 基数排序，LSD
 */
public class RadixSortLsd {
    private static int[] src;
    private static List<List<Integer>> slot;

    public static void main(String[] args) {
        src = new int[]{1100, 192, 221, 12, 23, 45, 343, 11111,4545, 1234, 3306, 392, 681, 16, 230};
        radixSortLsd();
        display();
    }

    private static void radixSortLsd() {
        int count = highestDigit();
        int i = 1;
        while (i <= count) {
            dealNumber(i);
            i++;
        }
    }

    private static void dealNumber(int index) {
        int digit;
        initSlot();
        String stringItem;
        for (int item : src) {
            stringItem = item + "";
            digit = index > stringItem.length() ? 0 : Integer.parseInt(stringItem.substring(stringItem.length() - index,stringItem.length() - index+1));
            slot.get(digit).add(item);
        }
        int srcIndex = 0;
        for (int i = 0; i < 10; i++) {
            for (int item : slot.get(i)) {
                src[srcIndex++] = item;
            }
        }
        slot = null;
    }

    private static int highestDigit() {
        int max = Integer.MIN_VALUE;
        for (int item : src) {
            if (item > max)
                max = item;
        }
        return (max + "").length();
    }

    private static void initSlot() {
        slot = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            slot.add(new ArrayList<>());
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
