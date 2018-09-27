package com.design.proxy.rmi.demo;

/**
 * 鑵捐璇惧爞鎼滅储 鍜曟场瀛﹂櫌
 * 鍔犵兢鑾峰彇瑙嗛锛�608583947
 * 椋庨獨鐨凪ichael 鑰佸笀
 */
public class UserServer extends User{

    public static void main(String[] args) {
        UserServer userServer=new UserServer();
        userServer.setAge(18);

        User_Skeleton skel=new User_Skeleton(userServer);

        skel.start();
    }

}
