package com.composite.step3;

import com.composite.step1.BlackDuck;
import com.composite.step1.Duck;
import com.composite.step1.RedDuck;
import com.composite.step1.WhiteDuck;

public class DuckFactory extends AbstractDuck{

	@Override
	public Duck createRedDuck() {
		return new RedDuck();
	}

	@Override
	public Duck createWhiteDuck() {
		return new WhiteDuck();
	}

	@Override
	public Duck createBlackDuck() {
		return new BlackDuck();
	}

}
