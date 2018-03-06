package com.study.test.thread;

class Thread1 extends Thread {
	public void run(){
		try{
			System.out.println(Thread.currentThread().toString()+"-----------------------------start");
			Thread.currentThread().sleep(1000);
			System.out.println(Thread.currentThread().toString()+"-------------------------end sleep");
		}catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
