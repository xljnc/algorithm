package com.wt.dsaainjava.chapter7;

/**
 * @author WuTian
 * @date 2018-06-28 14:18
 * @description 划分
 */
public class Partition {
    private static int[] src;

    public static void main(String[] args) {
        src = new int[]{3, 5, 70, 71, 74, 43, 93, 12, 46, 15, 51, 20, 95, 56, 57, 25, 60, 30, 94};
        int pivot = 50;
        System.out.println(partition(pivot));
        display();
    }

    private static int partition(int pivot) {
        int left = 0;
        int right = src.length - 1;
        while (true) {
            while (left < right && src[left] <= pivot) {
                left++;
            }
            while (right > left && src[right] >= pivot) {
                right--;
            }
            if (left >= right)
                break;
            swap(left, right);
        }
        return left;
    }

    private static void swap(int i, int j) {
        int temp = src[i];
        src[i] = src[j];
        src[j] = temp;
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
