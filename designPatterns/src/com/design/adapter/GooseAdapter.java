package com.design.adapter;

public class GooseAdapter implements Duck {
	
	private Goose goose;
	
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}

	@Override
	public void quack() {
		goose.hook();
	}

}
