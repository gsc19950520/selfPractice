package com.design.proxy.rmi.demo;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 鑵捐璇惧爞鎼滅储 鍜曟场瀛﹂櫌
 * 鍔犵兢鑾峰彇瑙嗛锛�608583947
 * 椋庨獨鐨凪ichael 鑰佸笀
 */
public class User_Stub extends User{

    private Socket socket;

    public User_Stub() throws IOException {
        socket=new Socket("localhost",8888);
    }

    public int getAge() throws IOException {
        ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());

        outputStream.writeObject("age");
        outputStream.flush();

        ObjectInputStream objectInputStream=new ObjectInputStream(socket.getInputStream());
        int age=objectInputStream.readInt();
        return age;
    }
}
