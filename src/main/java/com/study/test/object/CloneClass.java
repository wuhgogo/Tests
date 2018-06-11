package com.study.test.object;

public class CloneClass implements Cloneable{

	private String cloneStringField;
	
	private int cloneIntField;
	
	public int getCloneIntField() {
		return cloneIntField;
	}

	public void setCloneIntField(int cloneIntField) {
		this.cloneIntField = cloneIntField;
	}

	public String getCloneStringField() {
		return cloneStringField;
	}

	public void setCloneStringField(String cloneStringField) {
		this.cloneStringField = cloneStringField;
	}
	
	@Override
	protected CloneClass clone() throws CloneNotSupportedException {
		CloneClass cloneClass = (CloneClass) super.clone();
//		cloneClass.setCloneStringField(cloneStringField.clone());
		return cloneClass;
	}

	public static void main(String[] args) throws CloneNotSupportedException{
		CloneClass cloneClass = new CloneClass();
		cloneClass.setCloneStringField("a");
		cloneClass.setCloneIntField(1);
		System.out.println(cloneClass.getCloneStringField());
		System.out.println(((CloneClass)cloneClass.clone()).getCloneStringField()==cloneClass.getCloneStringField());
		System.out.println(((CloneClass)cloneClass.clone()).getCloneIntField()==cloneClass.getCloneIntField());
	}
	
}
