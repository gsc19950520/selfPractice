package com.design.state.state;

import java.util.Random;

import com.design.state.GumballMachine;

public class SoldState implements State {
	
	private GumballMachine gumballMachine;
	
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("����Ͷ��");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("�Ѿ�������");
	}

	@Override
	public void turnHandle() {
		int count = gumballMachine.getCount();
		if(count < 1) {
			System.out.println("ת���ֱ�ʧ�ܣ��ǹ�����");
			gumballMachine.setConcurrent(gumballMachine.getSoldOutState());
			return;
		}
		Random random = new Random();
		int nextInt = random.nextInt(10);
		if(nextInt == 0) {
			gumballMachine.setConcurrent(gumballMachine.getWinnerState());
		}
		System.out.println("ת���ֱ��ɹ�");
	}

	@Override
	public void dispense() {
		int count = gumballMachine.getCount();
		if(count == 1) {
			gumballMachine.setConcurrent(gumballMachine.getSoldOutState());
		}
		gumballMachine.setCount(count - 1);
		System.out.println("���ǳɹ����ǹ�ʣ������"+gumballMachine.getCount());
		gumballMachine.setConcurrent(gumballMachine.getNoQuarterState());
	}

}
