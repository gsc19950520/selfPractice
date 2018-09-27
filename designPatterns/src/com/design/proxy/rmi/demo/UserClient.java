package com.design.proxy.rmi.demo;

import java.io.IOException;

/**
 * 鑵捐璇惧爞鎼滅储 鍜曟场瀛﹂櫌
 * 鍔犵兢鑾峰彇瑙嗛锛�608583947
 * 椋庨獨鐨凪ichael 鑰佸笀
 */
public class UserClient {

    public static void main(String[] args) throws IOException {
        User user=new User_Stub();

        int age=user.getAge();

        System.out.println(age);
    }
}
