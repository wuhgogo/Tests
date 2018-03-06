package com.study.test.proxy;

public class TargetClass implements TargetInterface {

	public void proxyMethodA(){
		System.out.println("i'm targetA---------------------");
	}
	
	public void proxyMethodB(){
		System.out.println("i'm targetB---------------------");
	}
	
}
