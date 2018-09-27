package com.design.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class HandlerTest implements InvocationHandler{
	
	private Person person;
	
	public HandlerTest(PersonBean person) {
		this.person = person;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if(method.getName().startsWith("set")) {
			method.invoke(person, args);
		}else if(method.getName().startsWith("getName")){
			throw new IllegalAccessError();
		}else {
			method.invoke(person, args);
		}
		return null;
	}

}
