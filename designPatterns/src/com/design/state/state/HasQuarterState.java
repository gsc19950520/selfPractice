package com.design.state.state;

import com.design.state.GumballMachine;

public class HasQuarterState implements State {

	
	private GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("������Ͷ��");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("�����ɹ�");
		gumballMachine.setConcurrent(gumballMachine.getSoldState());
	}

	@Override
	public void turnHandle() {
		System.out.println("���Ƚ�������");
	}

	@Override
	public void dispense() {
		System.out.println("�޷�����");
	}

}
