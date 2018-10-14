package com.wt.dsaainjava.chapter6;

/**
 * @author WuTian
 * @date 2018-06-14 19:16
 * @description 变位词实现
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
        if (currSize == 1)
            return;
        for (int i = 0; i < currSize; i++) {
            doAnagram(currSize - 1);
            if (currSize == 2)
                displayWord();
            rotate(currSize);
        }
    }

    private static void rotate(int currSize) {
        int position = (size - currSize);
        char temp = charArr[position];
        int j;
        for (j = (position + 1); j < size; j++) {
            charArr[j - 1] = charArr[j];
        }
        charArr[j - 1] = temp;
    }

    private static void displayWord() {
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++) {
            System.out.print(charArr[i]);
        }
        if(count % 6 != 0)
            System.out.print(" ");
        if (count % 6 == 0)
            System.out.println("");
    }


}
