package com.sangwooeom.javaee.jsonb;

import jakarta.json.bind.annotation.JsonbProperty;

public class Person {
	// Using Annotations
	@JsonbProperty("person-name")
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "name = " + this.name;
	}
}
