package com.design.state.state;

import com.design.state.GumballMachine;

public class WinnerState implements State {

	private GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("无法操作");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("无法操作");
	}

	@Override
	public void turnHandle() {
		System.out.println("无法操作");
	}

	@Override
	public void dispense() {
		int count = gumballMachine.getCount();
		if(count > 1) {
			count = count - 2;
			System.out.println("恭喜你，中得两颗糖大奖，糖果还剩："+ count +"个");
		}else {
			count = count - 1;
			System.out.println("发糖成功，糖果剩余数："+ count);
		}
		gumballMachine.setCount(count);
		gumballMachine.setConcurrent(gumballMachine.getNoQuarterState());
	}

}
