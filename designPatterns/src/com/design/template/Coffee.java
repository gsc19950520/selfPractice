package com.design.template;

public class Coffee extends Beverage{

	@Override
	public void addToBeverage() {
		System.out.println("��ˮ���ݿ���");
	}

	@Override
	public void addCondiment() {
		System.out.println("�ӿ�������ĵ���");
	}

	@Override
	public boolean hook() {
		return true;
	}
}
