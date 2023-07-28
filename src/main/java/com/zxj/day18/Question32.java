package com.zxj.day18;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;

public class Question32 {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("D:\\project\\java\\JavaSE\\JavaSE\\src\\main\\java\\com\\zxj\\day18\\test.xml");

        Element rootElement = document.getRootElement();

        HashMap<Integer, User> hashMap = new HashMap<>();
        List<Element> elements = rootElement.elements();

        for (Element element : elements) {
            String id = element.attributeValue("id");
            String 名字 = element.elementText("name");
            char 性别 = element.elementText("sex").charAt(0);
            String 地址 = element.elementText("地址");
            String 密码 = element.elementText("password");
            User user = new User(名字, 性别, 地址, 密码);
            hashMap.put(Integer.parseInt(id), user);
        }

        hashMap.forEach((k, v) -> System.out.println(k + " " + v));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String name;
    private Character sex;
    private String address;
    private String password;
}
