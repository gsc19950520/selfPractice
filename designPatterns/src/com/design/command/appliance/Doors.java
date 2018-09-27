package com.design.command.appliance;

public class Doors implements Appliance {

	@Override
	public void on() {
		System.out.println("门打开了");
	}

	@Override
	public void off() {
		System.out.println("门关闭了");
	}

}
