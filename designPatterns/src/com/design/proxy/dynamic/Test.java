package com.design.proxy.dynamic;

public class Test {

	public static void main(String[] args) {
		PersonBean p = new PersonBean("����",10,"ϲ����ɫ");
		ProxyPerson proxy = new ProxyPerson();
		Proxy2 proxy2 = new Proxy2(p);
		Person person =  proxy2.getOwnProxy();
		System.out.println(person.getName());
	}
}
