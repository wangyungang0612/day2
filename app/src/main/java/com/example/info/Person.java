package com.example.info;

public class Person {
	private String nameString;
	private String numberString;
	
	public Person(String nameString, String numberString){
		this.nameString = nameString;
		this.numberString = numberString;
		
	}
	
	public String getNameString() {
		return nameString;
	}
	
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	
	public String getNumberString() {
		return numberString;
	}
	
	public void setNumberString(String numberString) {
		this.numberString = numberString;
	}

}
