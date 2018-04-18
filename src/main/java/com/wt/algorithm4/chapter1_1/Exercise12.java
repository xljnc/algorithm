package com.wt.algorithm4.chapter1_1;

/**
 * @Author WuTian
 * @Date 2018-04-10 19:09
 */
public class Exercise12 {
    public static void main(String[] args) {
        int[] a = new int[10];
        for (int i = 0; i < 10; i++) {
            a[i] = 9 - i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = a[a[i]];
        }
        //应该是印刷错误
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
        for (int i = 0; i < 10; i++) {
            System.out.println(a[i]);
        }
    }
}
