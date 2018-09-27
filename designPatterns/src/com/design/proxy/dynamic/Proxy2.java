package com.design.proxy.dynamic;

import java.lang.reflect.Proxy;

public class Proxy2 {
	
	private PersonBean person;

	public Proxy2(PersonBean person) {
		this.person = person;
	}

	
	public Person getOwnProxy() {
		//只能用接口 接收，否则报转换类型异常
		//代理类 和 主类 必须拥有相同的接口
		return (Person) Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				new Class[] {com.design.proxy.dynamic.Person.class},
				new HandlerTest(person));
	}
}
