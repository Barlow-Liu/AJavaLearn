package com.barlow.proxy;

import java.lang.reflect.Proxy;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TargetImpl target = new TargetImpl();
		DoHandler handler = new DoHandler(target);
		Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[] { TargetInterface.class },
				handler);
		TargetInterface proxyTarget = (TargetInterface) proxy;
		proxyTarget.doSome();
		proxyTarget.doOther();
	}

}
