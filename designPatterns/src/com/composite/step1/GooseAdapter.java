package com.composite.step1;


public class GooseAdapter extends Duck {
	
	private Goose goose;
	
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}

	@Override
	public void quack() {
		goose.hook();
	}

}
