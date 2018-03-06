package com.study.test.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class MyMethodInterceptor implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("----- before -----");  
        Object result = methodProxy.invokeSuper(obj, args);  
        System.out.println("----- after -----"); 
        return result;  
	}

}
