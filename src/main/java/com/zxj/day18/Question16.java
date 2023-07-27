package com.zxj.day18;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class Question16 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String name ="我爱你美国666";
      //  byte[] bytes = name.getBytes("GBK");
        byte[] bytes = name.getBytes();
        System.out.println(bytes.length);
        System.out.println(Arrays.toString(bytes));

        String s = new String(bytes, "GBK");
        System.out.println(s);
    }

}
