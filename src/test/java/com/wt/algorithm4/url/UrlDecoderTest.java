package com.wt.algorithm4.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

/**
 * @Author WuTian
 * @Date 2018-04-16 11:01
 */
public class UrlDecoderTest {
    public static void main(String[] args) {
//        String url = "http://10.10.13.170:8086/carshow/initvideo?banner=%E6%B5%8B%E8%AF%95Json&brand=%E6%B5%8B%E8%AF%95Json&serial=%E6%B5%8B%E8%AF%95Json&mainUrl=files%2F2018-04-18%2F201804181618067055860.jpg&addiUrls=%5B%22files%2F2018-04-18%2F201804181618084889292.jpg%22%2C%22files%2F2018-04-18%2F201804181618108548966.jpg%22%2C%22files%2F2018-04-18%2F201804181618129759346.png%22%2C%22files%2F2018-04-18%2F201804181618176467220.png%22%5D&priority=444";
//        String urlDE = URLDecoder.decode(url);
//        System.out.println(urlDE);


        //String url =  "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wx1118dfcf7dfb4a42&redirect_uri=http%3A%2F%2Fts-m.cheguo.com%2Fminigame%2Findex%3Fjump%3Dtrue&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect";
        String[] names = {
                "静语－浅浅",
                "王岩-雅诗阁",
                "Chihiro",
                "Janet",
                "Ash",
                "Sunshine🍀",
                "杰",
                "8想长大💗",
                "ivan",
                "你是妖怪吧",
                "Lyh",
                "菟丝草",
                "云在青天水在瓶",
                "阿蕾",
                "沉溺",
                "大墨",
                "赵玉荣",
                "短板",
                "Hyuna",
                "jlm",
                "欢欢",
                "chun红",
                "Jbjt",
                "Ming Xiong",
                "马小二🎈 🎈",
                "OTW平",
                "安卉",
                "是我。。。。。",
                "Start ✨"
        };
        String[] endNames = new String[names.length];
        try {
            for (int i = 0; i < names.length; i++) {
                endNames[i] = URLEncoder.encode(names[i], "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < endNames.length; i++) {
            System.out.println(endNames[i]);
        }
//        try {
//            for (int i = 0; i < endNames.length; i++) {
//                System.out.println(URLDecoder.decode(endNames[i],"UTF-8"));
//            }
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        String encodedName = "%E5%BF%B5";
//        try {
//            System.out.println(URLDecoder.decode(encodedName, "UTF-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
    }

}
