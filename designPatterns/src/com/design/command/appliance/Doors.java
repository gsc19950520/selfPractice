package com.design.command.appliance;

public class Doors implements Appliance {

	@Override
	public void on() {
		System.out.println("�Ŵ���");
	}

	@Override
	public void off() {
		System.out.println("�Źر���");
	}

}
