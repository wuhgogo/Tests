package com.study.test.annotation;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class AnnotationTest {
	public static void main(String[] args) throws SecurityException, NoSuchMethodException {

		Class<SubClass> clazz = SubClass.class;
		if (clazz.isAnnotationPresent(MyAnnotaion.class)) {
			MyAnnotaion cla = clazz.getAnnotation(MyAnnotaion.class);
			System.out.println("子类继承到父类类上Annotation,其信息如下：" + cla.value());
		} else {
			System.out.println("子类没有继承到父类类上Annotation");
		}

		// 实现抽象方法测试
		Method method = clazz.getMethod("abstractMethod", new Class[] {});
		if (method.isAnnotationPresent(MyAnnotaion.class)) {
			MyAnnotaion ma = method.getAnnotation(MyAnnotaion.class);
			System.out.println("子类实现父类的abstractMethod抽象方法，继承到父类抽象方法中的Annotation,其信息如下：" + ma.value());
		} else {
			System.out.println("子类实现父类的abstractMethod抽象方法，没有继承到父类抽象方法中的Annotation");
		}

		// 覆盖测试
		Method methodOverride = clazz.getMethod("doExtends", new Class[] {});
		if (methodOverride.isAnnotationPresent(MyAnnotaion.class)) {
			MyAnnotaion ma = methodOverride.getAnnotation(MyAnnotaion.class);
			System.out.println("子类继承父类的doExtends方法，继承到父类doExtends方法中的Annotation,其信息如下：" + ma.value());
		} else {
			System.out.println("子类继承父类的doExtends方法，没有继承到父类doExtends方法中的Annotation");
		}

		// 继承测试
		Method method3 = clazz.getMethod("doHandle", new Class[] {});
		if (method3.isAnnotationPresent(MyAnnotaion.class)) {
			MyAnnotaion ma = method3.getAnnotation(MyAnnotaion.class);
			System.out.println("子类覆盖父类的doHandle方法，继承到父类doHandle方法中的Annotation,其信息如下：" + ma.value());
		} else {
			System.out.println("子类覆盖父类的doHandle方法，没有继承到父类doHandle方法中的Annotation");
		}
	}
}
