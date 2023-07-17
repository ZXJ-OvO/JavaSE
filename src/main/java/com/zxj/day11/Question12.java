package com.zxj.day11;

/**
 * 给用户的手机号码上发送一个短信验证码！如下图所示：
 * 发送短信验证码的大致逻辑如下所示：
 * 1、生成一个4位的随机的数字字符串
 * 2、访问指定的短信服务平台让其完成验证码的发送
 * 3、将验证码数据进行存储
 * **需求描述**：在素材的msg项目的AliyunSendMsg类和TencentSendMsg的指定位置补全代码，并使用模板设计模式对代码进行优化。实现短信验证码发送功能！案例实现效果如下所示：
 * 1、当在Entry类中创建AliyunSendMsg对象时，在控制台输出
 * 2、当在Entry类中创建TencentSendMsg对象时，在控制台输出
 * **实现提示**：
 * 1、生成一个4位随机字符串(字符来源于chs数组)
 * 2、发送短信验证码(由于知识储备不足，此处可以通过输出语句进行模拟)
 * 3、创建CheckCode对象，将该对象存储到arrayList集合中
 * 4、将AliyunSendMsg和TencentSendMsg中相同的代码向上进行抽取，将其定义到一个模板类中，然后让AliyunSendMsg和TencentSendMsg继承该类
 */
public class Question12 {
    public static void main(String[] args) {
        AliyunSendMsg aliyunSendMsg = new AliyunSendMsg();
        TencentSendMsg tencentSendMsg = new TencentSendMsg();
        aliyunSendMsg.send();
        tencentSendMsg.send();
    }
}

abstract class SendMsg {
    private void sendMsg() {
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += (int) (Math.random() * 10);
        }
        System.out.println("发送短信验证码：" + s);
    }

    public void send() {
        sendMsg();
    }


}

class AliyunSendMsg extends SendMsg {

    @Override
    public void send() {
        System.out.println("阿里云发送短信验证码");
        super.send();
    }
}

class TencentSendMsg extends SendMsg {
    @Override
    public void send() {
        System.out.println("腾讯云发送短信验证码");
        super.send();
    }
}


