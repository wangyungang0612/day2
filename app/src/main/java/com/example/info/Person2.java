package com.example.info;

public class Person2 {
	private String personName;
	private String personAddress;

	public Person2(String personName, String personAddress) {

		this.personName = personName;
		this.personAddress = personAddress;
	}

	public String getPersonName() {
		return personName;
	}
	
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	public String getPersonAddress() {
		return personAddress;
	}
	
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
	}


}
