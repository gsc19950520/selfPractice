package com.design.state;

import com.design.state.state.SoldOutState;
import com.design.state.state.HasQuarterState;
import com.design.state.state.NoQuarterState;
import com.design.state.state.State;
import com.design.state.state.WinnerState;
import com.design.state.state.SoldState;

public class GumballMachine {

	State noQuarterState;
	State hasQuarterState;
	State soldState;
	State soldOutState;
	State winnerState;
	
	State concurrent;
	int count;
	
	public GumballMachine(int count) {
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		soldOutState = new SoldOutState(this);
		winnerState = new WinnerState(this);
		
		concurrent = noQuarterState;
		this.count = count;
	}
	
	public void insertQuarter() {
		concurrent.insertQuarter();
	}
	
	public void ejectQuarter() {
		concurrent.ejectQuarter();
	}
	
	public void turnHandle() {
		concurrent.turnHandle();
		concurrent.dispense();
	}
	
	
	
	
	//----------------------------------------------------

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public void setNoQuarterState(State noQuarterState) {
		this.noQuarterState = noQuarterState;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public void setHasQuarterState(State hasQuarterState) {
		this.hasQuarterState = hasQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public void setSoldState(State soldState) {
		this.soldState = soldState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public void setSoldOutState(State soldOutState) {
		this.soldOutState = soldOutState;
	}

	public State getConcurrent() {
		return concurrent;
	}

	public void setConcurrent(State concurrent) {
		this.concurrent = concurrent;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public State getWinnerState() {
		return winnerState;
	}

	public void setWinnerState(State winnerState) {
		this.winnerState = winnerState;
	}
	
}
