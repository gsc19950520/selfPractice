package com.design.command.appliance;

public class Light implements Appliance {

	@Override
	public void on() {
		System.out.println("�ƴ���");
	}

	@Override
	public void off() {
		System.out.println("�ƹر���");
	}

}
