package com.wt.algorithm4.chapter1_1;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("Please input a int:");
            int inputInt = input.nextInt();
            String result = "";
            while(inputInt>0){
                result=(inputInt%2)+result;
                inputInt/=2;
            }
            System.out.println(result);
        }
    }
}
