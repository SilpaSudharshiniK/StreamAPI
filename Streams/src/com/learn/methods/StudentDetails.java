package com.learn.methods;

public class StudentDetails {
	int rollNo;
	String name;
	char Sex;	
	
	
	public StudentDetails() {
		super();
	}
	
	public StudentDetails(int rollNo, String name, char sex) {
		super();
		this.rollNo = rollNo;
		this.name = name;
		Sex = sex;
	}
	
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return Sex;
	}
	public void setSex(char sex) {
		Sex = sex;
	}

	//@Override
	public String toString() {
		return "StudentDetails [rollNo=" + rollNo + ", name=" + name + ", Sex=" + Sex + "]";
	}
	
	

}
