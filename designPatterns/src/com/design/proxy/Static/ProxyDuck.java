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
		System.out.println("Ѽ�ӽ�֮ǰ�Ĳ���");
		duck.quack();
		System.out.println("Ѽ�ӽ�֮��Ĳ���");
	}

	@Override
	public void fly() {
		if(duck != null) {
			duck.fly();
		}else {
			try {
				Thread.sleep(1000 * 10);
				System.out.println("�ȴ�֮���ڷ���");
				duck = new BlackDuck();
				duck.fly();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
