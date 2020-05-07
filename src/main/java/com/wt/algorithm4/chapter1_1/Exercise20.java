package com.wt.algorithm4.chapter1_1;


import java.util.Scanner;

/**
 * @Author WuTian
 * @Date 2018-04-11 9:14
 */
public class Exercise20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        while (true) {
            System.out.println("Please input a integer which is bigger than 0.");
            n = in.nextInt();
            if(n<=0){
                System.out.println("Invalid input.");
                continue;
            }
            System.out.println("result of ln(N!) is:"+calcLn(n));
        }
    }

    public static double calcLn(int n) {
        if (n == 1) {
            return 0;
        }
        return Math.log(n) + calcLn(n - 1);
    }

}
