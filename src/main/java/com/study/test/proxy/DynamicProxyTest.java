package com.study.test.proxy;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Proxy;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import sun.misc.ProxyGenerator;

public class DynamicProxyTest {
	public static void main(String[] args){
//		TargetInterface targetInterface = new TargetClass();
//		MyInvocationHandler myInvocationHandler = new MyInvocationHandler(targetInterface);
//		TargetInterface proxy =  (TargetInterface) Proxy.newProxyInstance(Thread.currentThread()  
//                .getContextClassLoader(), targetInterface.getClass().getInterfaces(),  
//                myInvocationHandler);
//		proxy.proxyMethodA();
//		proxy.proxyMethodB();
//		System.out.println(proxy.toString());
//		
//		String path = "d:/$Proxy0.class";  
//        byte[] classFile = ProxyGenerator.generateProxyClass("$Proxy0",  
//        		TargetClass.class.getInterfaces());  
//        FileOutputStream out = null;  
//  
//        try {  
//            out = new FileOutputStream(path);  
//            out.write(classFile);  
//            out.flush();  
//        } catch (Exception e) {  
//            e.printStackTrace();  
//        } finally {  
//            try {  
//                out.close();  
//            } catch (IOException e) {  
//                e.printStackTrace();  
//            }  
//        }
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:/cglib");   
		TargetClass targetClass = new TargetClass();
		MyMethodInterceptor myMethodInterceptor = new MyMethodInterceptor();
        Enhancer enhancer = new Enhancer();  
        enhancer.setSuperclass(targetClass.getClass());  
        enhancer.setCallback(myMethodInterceptor);
        TargetClass proxy = (TargetClass) enhancer.create();  
		proxy.proxyMethodA();
		proxy.proxyMethodB();
		System.out.println(proxy.toString());
	}
}
