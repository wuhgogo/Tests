package com.study.test.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

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
	
	static List<Integer> list = new LinkedList<Integer>();
	
	@Test
	public static void prduceAndConsume() {
		//两个线程，一个线程需要生产，另一个负责消费
		//任务是生产和消费，共享的是一个集合
		//生产线程，如果当前大小没有到最大值，则需要生产，如果达到最大值，则需要等待消费线程消费
		new Thread( () -> {
			Random random = new Random();
			while(true) {
				synchronized(list) {
					while(list.size()==10) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					int produce = random.nextInt(9);
					list.add(produce);
					System.out.println("生产了："+produce);
					list.notifyAll();
				}
				
			}
		}).start();
		
		//消费线程，如果当前没有可以消费，需要唤醒生产者生产，否则需要消费
		new Thread( () -> {
			while(true) {
				synchronized(list) {
					while(list.size()==0) {
						try {
							list.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					int consume = list.remove(list.size()-1);
					System.out.println("消费了："+consume);
					list.notifyAll();
				}
			}
		}).start();
	}

}
