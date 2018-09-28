package com.composite;

import com.composite.step1.BlackDuck;
import com.composite.step1.Duck;
import com.composite.step1.Goose;
import com.composite.step1.GooseAdapter;
import com.composite.step1.WhiteDuck;
import com.composite.step2.DuckCounter;
import com.composite.step3.AbstractDuck;
import com.composite.step3.DuckCounterFactory;
import com.composite.step4.DuckFlock;
import com.composite.step5.Observer;
import com.composite.step5.PersonBean;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
//		t.step1();
//		t.step2();
//		t.step3();
//		t.step4();
		
		t.step5();
	}
	
	public void step5() {
//		Goose goose = new Goose();
//		Duck d2 = new GooseAdapter(goose);
		
		AbstractDuck factory = new DuckCounterFactory();
		
		Duck duck1 = factory.createBlackDuck();
		Duck duck2 = factory.createWhiteDuck();
		Duck duck3 = factory.createRedDuck();
		
		DuckFlock duckFlock = new DuckFlock();
		DuckFlock smallFlock = new DuckFlock();
		duckFlock.addDuck(duck1);
		duckFlock.addDuck(duck3);
		smallFlock.addDuck(duck3);
		smallFlock.addDuck(duck2);
		smallFlock.addDuck(duck1);
		duckFlock.addDuck(smallFlock);
		
		Observer person = new PersonBean();
		duckFlock.registerObserver(person);
		smallFlock.registerObserver(person);
		
		quack(duckFlock);
		System.out.println(DuckCounter.getCount());
	}
	
	public void step4() {
		Goose goose = new Goose();
		Duck d2 = new GooseAdapter(goose);
		
		AbstractDuck factory = new DuckCounterFactory();
		
		Duck duck1 = factory.createBlackDuck();
		Duck duck3 = factory.createRedDuck();
		
		DuckFlock duckFlock = new DuckFlock();
		duckFlock.addDuck(d2);
		duckFlock.addDuck(duck1);
		duckFlock.addDuck(duck3);
		
		quack(duckFlock);
		System.out.println(DuckCounter.getCount());
	}
	
	public void step3() {
		Goose goose = new Goose();
		Duck d2 = new GooseAdapter(goose);
		
		AbstractDuck factory = new DuckCounterFactory();
		
		Duck duck1 = factory.createBlackDuck();
		Duck duck3 = factory.createRedDuck();
		
		quack(duck1);
		quack(d2);
		quack(duck3);
		System.out.println(DuckCounter.getCount());
	}
	
	public void step2() {
		Duck d1 = new BlackDuck();
		Goose goose = new Goose();
		Duck d2 = new GooseAdapter(goose);
		Duck d3 = new WhiteDuck();
		
		Duck duck1 = new DuckCounter(d1);
		Duck duck3 = new DuckCounter(d3);
		
		quack(duck1);
		quack(d2);
		quack(duck3);
		System.out.println(DuckCounter.getCount());
	}
	
	public void step1() {
		Duck d1 = new BlackDuck();
		Goose goose = new Goose();
		Duck d2 = new GooseAdapter(goose);
		Duck d3 = new WhiteDuck();
		
		quack(d1);
		quack(d2);
		quack(d3);
	}
	
	public void quack(Duck duck) {
		duck.quack();
	}
	
}
