package com.design.template;

public class Tea extends Beverage{

	@Override
	public void addToBeverage() {
		System.out.println("��ˮ���ݲ�");
	}

	@Override
	public void addCondiment() {
		System.out.println("�Ӳ�����ĵ���");
	}

}
