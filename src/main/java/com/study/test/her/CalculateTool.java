package com.study.test.her;

import java.util.Scanner;

public class CalculateTool {

	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in); 
			System.out.println("请输入高度：");
			double a = sc.nextDouble();
			System.out.println("请输入长度："); 
			double c = sc.nextDouble();
			System.out.println("请输入斜率："); 
			double b = sc.nextDouble();
			System.out.println("结果是："+(a-b*c/(Math.sqrt(1+b*b))));
			System.out.println();
		}
	}

}
