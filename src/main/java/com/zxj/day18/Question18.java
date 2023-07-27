package com.zxj.day18;

import java.io.FileOutputStream;

public class Question18 {
    public static void main(String[] args) throws Exception {
        // 加true追加
        FileOutputStream outputStream = new FileOutputStream("src/main/resources/abc.txt",true);
        outputStream.write(97);
        outputStream.write('a');
        outputStream.write('徐');    // 不支持中文，中文是三个字节，而本方法只能写出一个字节

        // outputStream.flush();   // 刷新流，此时还可以继续使用流



        byte[] buffer = {97, 98, 99, 100};
        outputStream.write(buffer);

        byte[] bytes = "我爱你美国".getBytes();
        outputStream.write(bytes);
        outputStream.write("\r\n".getBytes());  // 写出一个换行
        outputStream.close();   // 关闭流，关闭了就不能再次使用了
    }
}
