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
		System.out.println("无需投币");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("已经操作过");
	}

	@Override
	public void turnHandle() {
		int count = gumballMachine.getCount();
		if(count < 1) {
			System.out.println("转动手柄失败，糖果不足");
			gumballMachine.setConcurrent(gumballMachine.getSoldOutState());
			return;
		}
		Random random = new Random();
		int nextInt = random.nextInt(10);
		if(nextInt == 0) {
			gumballMachine.setConcurrent(gumballMachine.getWinnerState());
		}
		System.out.println("转动手柄成功");
	}

	@Override
	public void dispense() {
		int count = gumballMachine.getCount();
		if(count == 1) {
			gumballMachine.setConcurrent(gumballMachine.getSoldOutState());
		}
		gumballMachine.setCount(count - 1);
		System.out.println("发糖成功，糖果剩余数："+gumballMachine.getCount());
		gumballMachine.setConcurrent(gumballMachine.getNoQuarterState());
	}

}
