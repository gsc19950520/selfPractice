package com.design.proxy.dynamic;

import java.lang.reflect.Proxy;

public class Proxy2 {
	
	private PersonBean person;

	public Proxy2(PersonBean person) {
		this.person = person;
	}

	
	public Person getOwnProxy() {
		//ֻ���ýӿ� ���գ�����ת�������쳣
		//������ �� ���� ����ӵ����ͬ�Ľӿ�
		return (Person) Proxy.newProxyInstance(
				person.getClass().getClassLoader(),
				new Class[] {com.design.proxy.dynamic.Person.class},
				new HandlerTest(person));
	}
}
