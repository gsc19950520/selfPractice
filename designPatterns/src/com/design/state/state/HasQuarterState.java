package com.design.state.state;

import com.design.state.GumballMachine;

public class HasQuarterState implements State {

	
	private GumballMachine gumballMachine;
	
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("无需再投币");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("操作成功");
		gumballMachine.setConcurrent(gumballMachine.getSoldState());
	}

	@Override
	public void turnHandle() {
		System.out.println("请先将币掷出");
	}

	@Override
	public void dispense() {
		System.out.println("无法发糖");
	}

}
