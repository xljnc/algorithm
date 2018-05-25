package com.wt.algorithm4.string;


/**
 * @Author WuTian
 * @Date 2018-04-12 9:44
 */
public class StringArrayTest {
    public static void main(String[] args) {
        String[] test = {"a","b","c","d"};
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<test.length;i++){
            if(i!=0){
                sb.append(",");
            }
            sb.append("h"+test[i]);
        }
        System.out.println(sb.toString());
    }
}
