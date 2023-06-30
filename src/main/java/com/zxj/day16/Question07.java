package com.zxj.day16;

import java.util.HashMap;

/**
 * 要求在程序中记住如下省份和其对应的城市信息，记录成功后，要求可以查询出湖北省的城市信息
 * 江苏省 = 南京市，扬州市，苏州市，无锡市，常州市
 * 湖北省 = 武汉市，孝感市，十堰市，宜昌市，鄂州市
 * 河北省 = 石家庄市，唐山市，邢台市，保定市，张家口市
 */
public class Question07 {
    public static void main(String[] args) {
        HashMap<String, String> city = new HashMap<>();
        HashMap<String, String> province = new HashMap<>();
        city.put("江苏省", "南京市，扬州市，苏州市，无锡市，常州市");
        city.put("湖北省", "武汉市，孝感市，十堰市，宜昌市，鄂州市");
        city.put("河北省", "石家庄市，唐山市，邢台市，保定市，张家口市");
        province.put("江苏省", city.get("江苏省"));
        province.put("湖北省", city.get("湖北省"));
        province.put("河北省", city.get("河北省"));

        province.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }
}
