package com.study.test.javac;

public class InnerClassTest {

	public void main(String[] args){
		InnerClass innerClass = new InnerClass();
		innerClass.print();
	} 
	
	class InnerClass {
		public void print(){
			System.out.println("InnerClassTest$InnerClass.print");
		}
	}
	
}
