package com.design.proxy.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 鑵捐璇惧爞鎼滅储 鍜曟场瀛﹂櫌
 * 鍔犵兢鑾峰彇瑙嗛锛�608583947
 * 椋庨獨鐨凪ichael 鑰佸笀
 */
public interface ISayHello extends Remote{

    public String sayHello(String name) throws RemoteException;
}
