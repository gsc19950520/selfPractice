package com.design.proxy.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

/**
 * 鑵捐璇惧爞鎼滅储 鍜曟场瀛﹂櫌
 * 鍔犵兢鑾峰彇瑙嗛锛�608583947
 * 椋庨獨鐨凪ichael 鑰佸笀
 */
public class HelloServer {

    public static void main(String[] args) {
        try {
            ISayHello hello=new SayHelloImpl();

            LocateRegistry.createRegistry(8888);

            Naming.bind("rmi://localhost:8888/sayHello",hello);

            System.out.println("server start success");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}
