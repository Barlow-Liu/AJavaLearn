package com.barlow.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DoHandler implements InvocationHandler {

	private Object target;

	public DoHandler(Object t) {
		// TODO Auto-generated constructor stub
		target = t;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("Before advice...");
		Object targetResult= method.invoke(target, args);
		System.out.println("After advice...");
		return targetResult;
	}

}
