package com.study.test.random;

import java.util.Date;
import java.util.Random;

import org.junit.Test;

public class RandomTest {

	@Test
	public void getRandomTest(){
		System.out.println(new Date().getTime());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Date().getTime());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
		System.out.println(new Random(new Date().getTime()).nextInt());
	}
	
}
