package com.wt.dsaainjava.chapter6;

/**
 * @author WuTian
 * @date 2018-06-27 16:28
 * @description 乘方实现
 */
public class MathPow {
    public static void main(String[] args) {
        System.out.println(pow(4,8)==Math.pow(4,8));
    }

    private static long pow(int x, int y) {
        if (y == 1)
            return x;
        if (y % 2 == 0)
            return pow(x * x, y / 2);
        else
            return x * pow(x * x, (y - 1) / 2);
    }
}
