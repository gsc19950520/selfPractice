package com.design.proxy.Static;

public class BlackDuck implements Duck {

	@Override
	public void quack() {
		System.out.println("��Ѽ�ӽ�");
	}

	@Override
	public void fly() {
		System.out.println("Ѽ�ӷ���");
	}

}
