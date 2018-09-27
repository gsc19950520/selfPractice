package com.design.proxy.Static;

public class Test {

	public static void main(String[] args) {
		Duck duck = new BlackDuck();
		Duck duckProxy = new ProxyDuck();
		duckProxy.fly();
	}
}
