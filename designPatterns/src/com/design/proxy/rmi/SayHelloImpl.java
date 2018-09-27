package com.design.proxy.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * 鑵捐璇惧爞鎼滅储 鍜曟场瀛﹂櫌
 * 鍔犵兢鑾峰彇瑙嗛锛�608583947
 * 椋庨獨鐨凪ichael 鑰佸笀
 */
public class SayHelloImpl extends UnicastRemoteObject implements ISayHello{

    public SayHelloImpl() throws RemoteException {
    }

    public String sayHello(String name) throws RemoteException {
        return "Hello Mic->"+name;
    }
}
