package com.design.state.state;

import com.design.state.GumballMachine;

public class NoQuarterState implements State{

	private GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("投币成功");
		gumballMachine.setConcurrent(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("还未投币，无法操作");
	}

	@Override
	public void turnHandle() {
		System.out.println("还未投币，无法转动手柄");
	}

	@Override
	public void dispense() {
		System.out.println("还未投币无法操作");
	}

}
