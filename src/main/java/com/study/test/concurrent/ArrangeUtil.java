package com.study.test.concurrent;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ArrangeUtil {

	
	//需要共享的三个变量，因为只涉及到顺序读取和移除操作和键值对形式，因此可用linkedlist方式和hashmap
	public static ConcurrentLinkedQueue ksPool = new ConcurrentLinkedQueue();
	public static Map roomPool = Collections.synchronizedMap(new HashMap());
	public static Map seatPool = Collections.synchronizedMap(new HashMap());
	
	public static int maxSeatNum;
	
	//编排
	public void arrange() {
		//每个任务拆分为3份
		//如果考生池不为空，则从考生池中获取考生进行编排
		while(!ksPool.isEmpty()) {
			//1、获取考生标识
			String ksInfo = arrangeInfo(ksPool.poll());
			//2、获取考生考场流水号
			String ksRoom = arrangeRoom(ksInfo);
			//3、获取考生座位流水号
			String ksSeatNum = arrangeSeat(ksRoom);
			//如果考生座位已满，需要新增考场
			if("0".equals(ksSeatNum)) {
				ksRoom = addRoom(ksInfo);
				ksSeatNum = arrangeSeat(ksRoom);
			}
			//剩下的就是其他数据整合写入操作
			System.out.println(ksInfo+ksRoom+ksSeatNum);
		}
	}

	private String arrangeSeat(String ksRoomNum) {
		int index = 1;
		//当前考场号座位是否为空
		if(seatPool.containsKey(ksRoomNum)) {
			//获取当前座位号
			index = (int)seatPool.get(ksRoomNum)+1;
		}
		if(index>maxSeatNum) {
			return "0";
		}else {
			seatPool.put(ksRoomNum, index);
			return generateNums(index, 2);
		}
	}

	private String arrangeRoom(String ksInfo) {
		//考场是否为空
		//空时写入考生标识和流水号
		if(roomPool.containsKey(ksInfo)) {
			return (String) roomPool.get(ksInfo);
		}else {
			return addRoom(ksInfo);
		}
	}

	/**
	 * 新增考场
	 * @param ksInfo 考生标识
	 * @return 考场号
	 */
	private String addRoom(String ksInfo) {
		//新增考场有两种情况
		//当前考生标识的考场并未存在
		//初始流水号
		int index = 1;
		if(roomPool.containsKey(ksInfo)) {
			//此时考场已存在，但是考生数量已到达上限，需要将流水加一
			index = (int) roomPool.get(ksInfo)+1;
		}
		//此时需要写入或更新考场标识-流水
		roomPool.put(ksInfo,index);
		return  generateNums(index,3);
	}

	private String arrangeInfo(Object ks) {
		return ks.toString();
	}
	
	/*
	 * 根据数字和0的位数生成流水号
	 */
	public static String generateNums(int num,int zeroNum) {
		StringBuilder zeros = new StringBuilder();
		int nums = num;
		for(int i = zeroNum-1;i>0;i--) {
			if((num/=10)==0) {
				zeros.append("0");
			}
		}
		return zeros.append(nums).toString();
	}
	
	
	public static void main(String[] args) {
		System.out.println(generateNums(33, 4));
		System.out.println(generateNums(1, 4));
		System.out.println(generateNums(123, 4));
		System.out.println(generateNums(1111, 4));
		ArrangeUtil.ksPool = new ConcurrentLinkedQueue(new LinkedList() {{add("1");add("2");}});
		new ArrangeUtil().arrange();
	}
}
