package com.design.state.state;

import com.design.state.GumballMachine;

public class NoQuarterState implements State{

	private GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("Ͷ�ҳɹ�");
		gumballMachine.setConcurrent(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("��δͶ�ң��޷�����");
	}

	@Override
	public void turnHandle() {
		System.out.println("��δͶ�ң��޷�ת���ֱ�");
	}

	@Override
	public void dispense() {
		System.out.println("��δͶ���޷�����");
	}

}
