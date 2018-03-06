package com.study.test.arrays;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class ArraysTest {

	@Test
	public void testCopyOf() {
//		int[] srcInt = {0,1,2,3,4,5};
//		int[] destInt = new int[5];
//		destInt = Arrays.copyOf(srcInt, srcInt.length);
//		Class newType = String[].class;
//        String[] copy = ((Object)newType == (Object)Object[].class)
//                ? (String[]) new Object[srcInt.length]
//                : (String[]) Array.newInstance(newType.getComponentType(), srcInt.length);
//                System.out.println(copy);
		Map<String,String> testMap = new HashMap<String, String>(100);
		testMap.put("a", "b");
		System.out.println(testMap.size());
		
	}
	
}
