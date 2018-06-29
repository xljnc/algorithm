package com.wt.dsaainjava.chapter7;

/**
 * @author WuTian
 * @date 2018-06-29 9:40
 * @description 快速排序，采用了三值取中法
 */
public class QuickSort {

    private static int[] src;

    public static void main(String[] args) {
        src = new int[]{3, 5, 70, 74, 43, 93, 71, 12, 78, 46, 15, 51, 20, 95, 56, 57, 25, 60, 30, 94};
        // src = new int[]{3, 5, 10, 8, 6, 4};
        quickSort(0, src.length - 1);
        display();
    }


    private static void quickSort(int left, int right) {
        int size = right - left + 1;
        if (size <= 3)
            manualSort(left, right, size);
        else {
            int pivot = findPivot(left, right);
            int partition = patition(left, right, pivot);
            quickSort(left, partition - 1);
            quickSort(partition + 1, right);
        }
    }

    private static int patition(int left, int right, int pivot) {
        int leftPtr = left + 1;
        int rightPtr = right - 2;
        while (true) {
            //这里不需要再判断leftPtr<rightPtr,因为从左到右迟早会达到倒数第二位，即pivot
            while (src[leftPtr] < pivot) {
                leftPtr++;
            }
            //这里也不需要再判断leftPtr<rightPtr,因为从右到左迟早会到达left，而src[left]肯定小于pivot
            while (src[rightPtr] > pivot) {
                rightPtr--;
            }
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr, right - 1);
        return leftPtr;
    }

    //获取pivot,采用了三值取中法
    private static int findPivot(int left, int right) {
        int mid = (left + right) / 2;
        if (src[left] > src[mid])
            swap(left, mid);
        if (src[mid] > src[right])
            swap(mid, right);
        if (src[left] > src[right])
            swap(left, right);
        //不知道这一步的好处何在
        swap(mid, right - 1);
        return src[right - 1];
    }


    private static void manualSort(int left, int right, int size) {
        if (size == 1)
            return;
        if (size == 2) {
            if (src[left] > src[right]) {
                swap(left, right);
                return;
            }
        } else {
            if (src[left] > src[right - 1])
                swap(left, right - 1);
            if (src[right - 1] > src[right])
                swap(right - 1, right);
            if (src[left] > src[right])
                swap(left, right);
        }
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
