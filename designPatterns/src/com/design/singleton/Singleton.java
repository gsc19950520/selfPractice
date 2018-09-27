package com.design.singleton;

public class Singleton {

	private Singleton singleton;
	
	private Singleton() {}
	
	//Ð§ÂÊµÍ
//	public synchronized Singleton getInstance() {
//		if(singleton == null) {
//			singleton = new Singleton();
//		}
//		return singleton;
//	}
	
	public Singleton getInstance() {
		if(singleton == null) {
			synchronized (Singleton.class) {
				if(singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;
	}
}
