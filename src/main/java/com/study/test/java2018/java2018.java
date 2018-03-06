package com.study.test.java2018;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class java2018 {

	@Test
	public void breakLoop() {
		ok: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 5)
					break ok;
//					continue ok;
				System.out.println(i+"-"+j);
			}
		}
	}
	
	public static void referenceMethod(List<String> s) {
//		List<String> test = new ArrayList<>();
		s.add("abc");
//		s = test;
	}
	
	@Test
	public void StringLoop() {
		String s = "";
		Random rand = new Random();
		for(int i=0;i<100000;i++) {
			s = s + rand.nextInt(1000)+ " ";
		}
		System.out.println(s);
	}

	@Test
	public void StringEquals() {
		String s3 = new String("0") + new String("1");    // 此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
		 s3.intern();    // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，会直接将s3的地址存储在常量池
		String s4 = "01";    // jdk1.7之后，常量池中的地址其实就是s3的地址
		System.out.println(s3 == s4); // jdk1.7之前false， jdk1.7之后true
//		String s1 = new String("1") + new String("1");
//		System.out.println(s1 == s1.intern());
//		String s2 = new String("2") + new String("2");
//		System.out.println(s2 == s2.intern());
//		String s3 = new String("3") + new String("3");
//		System.out.println(s3 == s3.intern());
	}
	
//	public static void main(String[] args) {
////		String s = "123";
//		List<String> test = new ArrayList<>();
//		test.add("123");
//		System.out.println(test.toString());
//		referenceMethod(test);
//		System.out.println(test.toString());
//	}
	
//    public static final String s1 = "5";  
//    public static String s2 = "5";  
//      
//    public static String getS(){  
//        return "5";  
//    }  
//    public static void main(String[] args) {  
//        String a1 = "12";  
//        String a2 = "12";  
//        String a3 = new String("12");  
//        String a4 = new String("12");  
//        System.out.println(a1 == a2); //1  
//        System.out.println(a3 == a4); //2  
//        System.out.println(a1 == a3); //3  
//        System.out.println("============");  
//        //==============================  
//        String b1 = "34";  
//        String b2 = "3" + "4";  
//        String b3 = 3 + "4";  
//        String b4 = "3" + 4;  
//        System.out.println(b1 == b2); //4  
//        System.out.println(b1 == b3); //5  
//        System.out.println(b1 == b4); //6  
//        System.out.println("============");  
//        //==============================  
//        String c1 = "56";  
//        String c2 = "5";  
//        String c3 = "6";  
//        String c4 = c2 + "6";  
//        String c5 = c2 + c3;  
//        final String c6 = "5";  
//        String c7 = c6 + "6";  
//        String c8 = s1 + "6";  
//        String c9 = s2 + "6";  
//        String c0 = getS() + "6";  
//        System.out.println(c1 == c4); //7  
//        System.out.println(c1 == c5); //8  
//        System.out.println(c1 == c7); //9  
//        System.out.println(c1 == c8); //10  
//        System.out.println(c1 == c9); //11  
//        System.out.println(c1 == c0); //12  
//    }  
	public static void main(String\u005B\u005D args) {
		System.out.println(2.0-1.1);
		int x = 0;
		if((x=1)!=2) {
			System.out.println(x=1);
		}
//		double a=12123121.323444353234443532344435d;
//		System.out.println(a);
		short s1 = 1;
		s1 +=1;
		Integer a = new Integer(3);
		Integer b = 3;
		int c = 3;
		Integer d = new Integer(3);
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a==d);
		Integer f1=100,f2=100,f3=150,f4=150;
		System.out.println(f1==f2);
		System.out.println(f3==f4);
		
		
	}
}
