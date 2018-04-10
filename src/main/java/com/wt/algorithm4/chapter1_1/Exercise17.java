package com.wt.algorithm4.chapter1_1;

/* *
 * RunWith: -Xss128K
 * @Author  WuTian
 * @Date 2018/4/10 16:11
 */
public class Exercise17 {
    /* * 
     * @Author  WuTian
     * @Date 2018/4/10 16:14
     * @Param [n]
     * @Return java.lang.String
     * @Throws java.lang.StackOverflowError
     * @Description: n<=0的情况永远不会被调用，递归调用直到抛出StackOverflowError
     */
    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;
        if (n <= 0) {
            return "";
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(exR2(4));
    }
}
