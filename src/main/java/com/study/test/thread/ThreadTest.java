package com.study.test.thread;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

public class ThreadTest {

	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread1 thread2 = new Thread1();
		thread1.start();
		thread2.start();
	}

	@Test
	public void dirCreateThreadTest() {
		System.out.println("1111111111111111111111111");
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				final File testDir = new File("D:\\othertest\\1\\test");
				if(!testDir.exists()) {
					testDir.mkdir();
				}
				try {
					FileUtils.copyFile(new File("D:\\othertest\\0101\\333333333333333333.jpg"), new File("D:\\othertest\\1\\test\\333333333333333333.jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				final File testDir = new File("D:\\othertest\\1\\test");
				if(!testDir.exists()) {
					testDir.mkdir();
				}
				try {
					FileUtils.copyFile(new File("D:\\othertest\\0101\\333333333333333333.jpg"), new File("D:\\othertest\\1\\test\\333333333333333333.jpg"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}).start();
		System.out.println("00000000000000000000000000");
	}

}