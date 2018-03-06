package com.study.test.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
//		ObjectTest objectTest = new ObjectTest();
		System.out.println(ObjectTest.class.getClassLoader().getResource("").toString());
		List<Object[]> test = new ArrayList<>();
		test.add(new String[]{"1","2","3"});
		test.add(new String[]{"4"});
		test.add(new String[]{"5"});
		System.out.println(Arrays.toString(test.get(0)));
//		for(int i=0;i<10000;i++) {
//			System.out.println(i);
//			if(i==10) {
//				try {
//					int tt = 1/0;
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//					continue;
//				}
//			}
//		}
		int[] intTest = {1,2,3,4,5,6,7,8,9,0};
		int[] nums = {1,4,3,2,123,321,135,5321};
        //先排序
        Arrays.sort(nums);
        int retInt = 0;
        //求和
        for(int i=0;i<nums.length;i+=2){
            retInt += nums[i];
        }
	}

}
