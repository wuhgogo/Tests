package com.study.test.Integer;

import java.lang.reflect.Field;

import org.junit.Test;

public class IntegerTest {

	@Test
	public void swapTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Integer a = 1;
		Integer b = 2;
		swap(a,b);
		System.out.println(a+":"+b);
		System.out.println(Integer.valueOf(1));
	}
	
	/**
	 * java方法都是值传递，因此作为参数传入的都是新的地址引用值，直接修改参数修改的只是方法栈中的引用地址，并不会影响传入的真实参数。
	 * 此处使用反射直接设置参数内部代表值的数据，同时需要考虑传入的为自动包装的Integer，交换值的过程中，也代表Integer中缓存的值可能会有变化。
	 * @param a
	 * @param b
	 * @throws NoSuchFieldException
	 * @throws SecurityException
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public void swap(Integer a,Integer b) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Field value = Integer.class.getDeclaredField("value");
		value.setAccessible(true);
		Integer tmp = new Integer(a);
		value.set(a, b);
		value.set(b, tmp);
	}
	
}
