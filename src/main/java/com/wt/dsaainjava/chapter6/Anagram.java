package com.wt.dsaainjava.chapter6;

/**
 * @author WuTian
 * @date 2018-06-14 19:16
 * @description
 */
public class Anagram {

    private static char[] charArr;
    private static int size;
    private static int count;

    public static void main(String[] args) {
        String input = "abcd";
        size = input.length();
        charArr = new char[size];
        count = 0;
        for (int i = 0; i < size; i++) {
            charArr[i] = input.charAt(i);
        }
        doAnagram(size);
    }

    private static void doAnagram(int currSize) {
        
    }
}
