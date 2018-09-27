package com.design.state.state;

import com.design.state.GumballMachine;

public class SoldOutState implements State {

	private GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("糖不足，无法投币");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("糖不足，无法操作");
	}

	@Override
	public void turnHandle() {
		System.out.println("糖不足，无法转动手柄");
	}

	@Override
	public void dispense() {
		System.out.println("糖不足，无法发糖");
	}

}
