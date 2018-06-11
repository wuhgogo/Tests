package com.study.test.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.tools.ant.taskdefs.Sleep;
import org.junit.Test;


public class ObjectTest {

	public ObjectTest(){
//		System.out.println("a class new ··········");
		
	}
	@Test
	public void test(){
	}
	
	public static ObjectTest objectTest = new ObjectTest();
	
//	public static Map m = new HashMap(){{m.put("a", "2");}};
	
	public static void main(String[] args) {
////		ObjectTest objectTest = new ObjectTest();
//		System.out.println(ObjectTest.class.getClassLoader().getResource("").toString());
//		List<Object[]> test = new ArrayList<>();
//		test.add(new String[]{"1","2","3"});
//		test.add(new String[]{"4"});
//		test.add(new String[]{"5"});
//		System.out.println(Arrays.toString(test.get(0)));
////		for(int i=0;i<10000;i++) {
////			System.out.println(i);
////			if(i==10) {
////				try {
////					int tt = 1/0;
////				} catch (Exception e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////					continue;
////				}
////			}
////		}
//		int[] intTest = {1,2,3,4,5,6,7,8,9,0};
//		int[] nums = {1,4,3,2,123,321,135,5321};
//        //先排序
//        Arrays.sort(nums);
//        int retInt = 0;
//        //求和
//        for(int i=0;i<nums.length;i+=2){
//            retInt += nums[i];
//        }
		prduceAndConsume();
	}
	
	@Test
	public void wanshuTest() {
		int sum;
		for(int i=1;i<=1000;i++) {
			sum = 0;
			for(int j=1;j<i;j++) {
				if(i%j==0) {
					sum += j;
				}
			}
			if(sum==i) {
				System.out.println(i);
			}
		}
	}
	
	@Test
	public void joinTest() {
		Thread test = new Thread() {
			public void run() {
				System.out.println("before lock");
				lock();
				System.out.println("after lock");
			}
			public synchronized void lock() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		System.out.println("start");
		test.start();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("before join");
		try {
			test.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("after join");
		
	}
	
	@Test
	public void waitTest() {
		Boolean b = false;
		new Thread(()->{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			synchronized (Boolean.class) {
				System.out.println("before notify");
				b.notifyAll();
				System.out.println("end notify");
			}
		}).start();
		try {
//			Thread.sleep(1000);
			System.out.println("before wait");
			synchronized(Boolean.class) {
				b.wait();
			}
			System.out.println("end wait");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//	public static void main(String[] args) {
////		ObjectTest objectTest = new ObjectTest();
//		System.out.println(ObjectTest.class.getClassLoader().getResource("").toString());
//		List<Object[]> test = new ArrayList<>();
//		test.add(new String[]{"1","2","3"});
//		test.add(new String[]{"4"});
//		test.add(new String[]{"5"});
//		System.out.println(Arrays.toString(test.get(0)));
////		for(int i=0;i<10000;i++) {
////			System.out.println(i);
////			if(i==10) {
////				try {
////					int tt = 1/0;
////				} catch (Exception e) {
////					// TODO Auto-generated catch block
////					e.printStackTrace();
////					continue;
////				}
////			}
////		}
//		int[] intTest = {1,2,3,4,5,6,7,8,9,0};
//		int[] nums = {1,4,3,2,123,321,135,5321};
//        //先排序
//        Arrays.sort(nums);
//        int retInt = 0;
//        //求和
//        for(int i=0;i<nums.length;i+=2){
//            retInt += nums[i];
//        }
//	}

}
