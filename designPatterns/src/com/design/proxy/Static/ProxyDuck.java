package com.design.proxy.Static;

import javax.swing.text.BadLocationException;

public class ProxyDuck implements Duck {
	
	private Duck duck;
	
	public ProxyDuck() {
		
	}

	public ProxyDuck(Duck duck) {
		this.duck = duck;
	}

	@Override
	public void quack() {
		System.out.println("鸭子叫之前的操作");
		duck.quack();
		System.out.println("鸭子叫之后的操作");
	}

	@Override
	public void fly() {
		if(duck != null) {
			duck.fly();
		}else {
			try {
				Thread.sleep(1000 * 10);
				System.out.println("等待之后在飞翔");
				duck = new BlackDuck();
				duck.fly();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
