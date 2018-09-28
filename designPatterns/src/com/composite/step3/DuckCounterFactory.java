package com.composite.step3;

import com.composite.step1.BlackDuck;
import com.composite.step1.Duck;
import com.composite.step1.RedDuck;
import com.composite.step1.WhiteDuck;
import com.composite.step2.DuckCounter;

public class DuckCounterFactory extends AbstractDuck{

	@Override
	public Duck createRedDuck() {
		return new DuckCounter(new RedDuck());
	}

	@Override
	public Duck createWhiteDuck() {
		return new DuckCounter(new WhiteDuck());
	}

	@Override
	public Duck createBlackDuck() {
		return new DuckCounter(new BlackDuck());
	}

}
