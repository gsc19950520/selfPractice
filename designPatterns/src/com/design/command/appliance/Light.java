package com.design.command.appliance;

public class Light implements Appliance {

	@Override
	public void on() {
		System.out.println("灯打开了");
	}

	@Override
	public void off() {
		System.out.println("灯关闭了");
	}

}
