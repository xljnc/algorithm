package com.wt.ahaalgorithm.chapter3_1;


/**
 * @author WuTian
 * @date 2018-05-25 11:49
 * @description ABC + DEF = GHI
 */
public class APlusBEqualsC {
    private static int[] result = new int[9];
    private static int[] book = new int[9];
    private static int total;

    public static void main(String[] args) {
        dfs(0);
        System.out.println("total num is:" + total / 2);
    }

    private static void dfs(int step) {
        if (step == 9) {
            if (((result[0] + result[3]) * 100 + (result[1] + result[4]) * 10 + result[2] + result[5]) == (result[6] * 100 + result[7] * 10 + result[8])) {
                System.out.printf("%d%d%d + %d%d%d = %d%d%d%n", result[0], result[1], result[2], result[3], result[4], result[5], result[6], result[7], result[8]);
                total += 1;
            }
            return;
        }
        for (int i = 0; i < 9; i++) {
            if (book[i] == 0) {
                result[step] = (i + 1);
                book[i] = 1;
                dfs(step + 1);
                book[i] = 0;
            }
        }
    }

}
