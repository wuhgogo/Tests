package com.study.test.concurrent;

import java.awt.Button;
import java.util.concurrent.CountDownLatch;

import com.sun.java_cup.internal.emit;

public class AddTest {

	
	public static void main(String[] args) {
		final Counter counter = new Counter();
		final boolean flag = false;
		new Thread(
				() -> System.out.println(1)
				).start();
		new Thread() {
			public void run() {
			}
		}.start();
		new Button().addActionListener(e -> {
			System.out.println(1);
		}
				);
		new Thread() {
			public void run() {
			};
		}.start();
		System.out.println(counter);
		new LambdaInterfaceTest().exe( () -> {
			System.out.println(1);
		});
	}
}
class Counter{
	private volatile int count = 0;
	
	public void inc() {
		count += 1;
	}
	
	
	@Override
	public String toString() {
		return "[count:="+count+"]";
	}
}
@FunctionalInterface
interface LambdaInterface {
	void test(); 
	default void fuck() {
		System.out.println(1);
	};
}

class LambdaInterfaceTest{
	public void exe(LambdaInterface li) {
		li.test();
	}
}
