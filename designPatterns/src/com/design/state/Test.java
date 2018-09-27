package com.design.state;

public class Test {

	public static void main(String[] args) {
		GumballMachine machine = new GumballMachine(10);
		for(int i = 0; i < 11; i++) {
			machine.insertQuarter();
			machine.ejectQuarter();
			machine.turnHandle();
		}
	}
}
