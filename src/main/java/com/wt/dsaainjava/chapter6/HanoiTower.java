package com.wt.dsaainjava.chapter6;

/**
 * @author WuTian
 * @date 2018-06-15 16:03
 * @description 汉诺塔实现 注意：递归栈大小设置的太小会有StackOverFlowError
 */
public class HanoiTower {

    public static void main(String[] args) {
        move(5, 'A', 'B', 'C');
    }

    private static void move(int topN, char from, char mid, char to) {
        if (topN == 1)
            System.out.println("Move Disk " + 1 + " from " + from + " to " + to);
        else {
            move(topN - 1, from, to, mid);
            System.out.println("Move Disk " + topN + " from " + from + " to " + to);
            move(topN - 1, mid, from, to);
        }
    }
}
