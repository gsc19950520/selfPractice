package com.design.state.state;

import com.design.state.GumballMachine;

public class SoldOutState implements State {

	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("�ǲ��㣬�޷�Ͷ��");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("�ǲ��㣬�޷�����");
	}

	@Override
	public void turnHandle() {
		System.out.println("�ǲ��㣬�޷�ת���ֱ�");
	}

	@Override
	public void dispense() {
		System.out.println("�ǲ��㣬�޷�����");
	}

}
