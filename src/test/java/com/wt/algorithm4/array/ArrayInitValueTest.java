package com.wt.algorithm4.array;

/**
 * @Author WuTian
 * @Date 2018-05-07 11:50
 * @Description
 */
public class ArrayInitValueTest {
    public static void main(String[] args) {
       boolean[][] a = new boolean[3][2];
       for(int i=0;i<a.length;i++){
           for(int j=0;j<a[i].length;j++){
               System.out.println(a[i][j]);
           }
       }
    }
}
