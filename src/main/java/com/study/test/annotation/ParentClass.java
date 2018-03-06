package com.study.test.annotation;

@MyAnnotaion(value = "类名上的注解")
public abstract class ParentClass {
    @MyAnnotaion(value = "父类的abstractMethod方法")  
    public abstract void abstractMethod();  
  
    @MyAnnotaion(value = "父类的doExtends方法")  
    public void doExtends() {  
        System.out.println(" ParentClass doExtends ...");  
    }  
      
    @MyAnnotaion(value = "父类的doHandle方法")  
    public void doHandle(){  
        System.out.println(" ParentClass doHandle ...");  
    } 
}
