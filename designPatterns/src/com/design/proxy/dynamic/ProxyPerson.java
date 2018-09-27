package com.design.proxy.dynamic;

import java.lang.reflect.Proxy;

public class ProxyPerson {

	public PersonBean getOwnProxy(PersonBean person) {
		System.out.println(person.getClass().getClassLoader());
		System.out.println(person.getClass().getInterfaces());
		return (PersonBean) Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				person.getClass().getInterfaces(),
				new HandlerTest(person));
	}

}
