package com.design.factory.pizza;

import com.design.factory.ingredient.Dough;
import com.design.factory.ingredient.Sauce;

public abstract class Pizza {
	
	String name;
	Dough dough;
	Sauce sauce;
	
	public abstract void prepare();
	
	public void bake() {
		System.out.println("执行烘烤步骤");
	}
	
	public void cut() {
		System.out.println("执行切块");
	}
	
	public void box() {
		System.out.println("执行打包");
	}
}
