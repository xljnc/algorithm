package com.wt.algorithm4.chapter1_1;

import java.util.Random;

/**
 * @Author  Xljnc
 * @Date 2018/5/6 22:28
 * @Description 从mystery1计算公式中可以看出，当b为2的倍数时，不会对结果造成影响，只是将a
 * 变为原来的2倍。假设b=5,用二进制表示则为0101，除以2相当于右移一位，当位数为1时，则有余数，表示需要加上a。
 * 最后得到的结果为0+b*a。同理，mystery2则为pow(a,pow(2,0))*pow(a,pow(2,1))*...*pow(a,pow(2,n)),即为pow(a, b)
 */

public class Exercise18 {
    public static int mystery1(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return mystery1(a + a, b >> 1);
        }
        return mystery1(a + a, b >> 1) + a;
    }

    public static int mystery2(int a, int b) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 0) {
            return mystery2(a * a, b >> 1);
        }
        return mystery2(a * a, b >> 1) * a;
    }

    public static void main(String[] args) {
        Random rad = new Random();
        int a = rad.nextInt(20);
        int b = rad.nextInt(20);
        System.out.println("mystery1(2,25)=" + mystery1(2, 25));
        System.out.println("mystery1(3,11)=" + mystery1(3, 11));
        System.out.println(mystery1(a, b) == a * b);
        System.out.println("mystery2(2,25)=" + mystery2(2, 25));
        System.out.println("mystery2(3,11)=" + mystery2(3, 11));
        System.out.println(mystery2(a, b) == Math.pow(a, b));
    }

}
