package com.design.state.state;

import com.design.state.GumballMachine;

public class WinnerState implements State {

	private GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("�޷�����");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("�޷�����");
	}

	@Override
	public void turnHandle() {
		System.out.println("�޷�����");
	}

	@Override
	public void dispense() {
		int count = gumballMachine.getCount();
		if(count > 1) {
			count = count - 2;
			System.out.println("��ϲ�㣬�е������Ǵ󽱣��ǹ���ʣ��"+ count +"��");
		}else {
			count = count - 1;
			System.out.println("���ǳɹ����ǹ�ʣ������"+ count);
		}
		gumballMachine.setCount(count);
		gumballMachine.setConcurrent(gumballMachine.getNoQuarterState());
	}

}
