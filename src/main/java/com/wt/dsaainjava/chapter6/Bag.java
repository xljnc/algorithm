package com.wt.dsaainjava.chapter6;

/**
 * @author WuTian
 * @date 2018-06-27 17:15
 * @description 未完成
 */
public class Bag {
    private static int[] option;

    public static void main(String[] args) {
        option = new int[]{11, 8, 7, 6, 5};
        inBag(20, 5);
    }

    private static void inBag(int score, int times) {
        if (score <= 0 && times <= 0)
            return;
        boolean result;
        for (int i = 0; i < option.length; i++) {
            System.out.println("Start from index " + i);
            result = put(score, i, times);
            if (result == true) {
                break;
            }
        }
    }

    private static boolean put(int score, int start, int times) {
        if ((score < 0) || (score > 0 && times <= 0)) {
            System.out.println("can not find the ball,start next loop");
            return false;
        }
        if (score == option[start]) {
            System.out.println("put " + option[start] + " in bag,Job done");
            return true;
        }
        System.out.println("put " + option[start] + " in bag.");
        return put(score - option[start], ++start, --times);
    }
}
