package com.wt.algorithm4.string;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.fastjson.JSON.parseArray;

/**
 * @Author WuTian
 * @Date 2018-04-13 16:34
 */
public class JsonTest {
    public static void main(String[] args) {
        String jsonUrl = "{\"addiUrls\":[\"1\",\"2\"]}";
        MyObject obj =  JSON.parseObject(jsonUrl,MyObject.class);
        System.out.println(obj.getAddiUrls());
        List<String> urls =  JSON.parseArray(obj.getAddiUrls(),String.class);
        List<String> newUrls = new ArrayList<String>(urls.size());
        for(String s:urls){
            s="test"+s;
            newUrls.add(s);
        }
        for(String s:newUrls){
            System.out.println(s);
        }
        obj.setAddiUrls(JSON.toJSONString(newUrls));
        System.out.println(obj.getAddiUrls());
    }
}

class MyObject{
    private String addiUrls;

    public String getAddiUrls() {
        return addiUrls;
    }

    public void setAddiUrls(String addiUrls) {
        this.addiUrls = addiUrls;
    }
}
