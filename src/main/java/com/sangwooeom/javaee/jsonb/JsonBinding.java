package com.sangwooeom.javaee.jsonb;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;

public class JsonBinding {
	public static void main(String[] args) {
		Jsonb jsonb = JsonbBuilder.create();
		
		Person person = new Person();
		person.setName("Fred");
		
		// Serialize to JSON
		String result = jsonb.toJson(person);
		System.out.println(result);
		
		
		// Deserialize from JSON
		person = jsonb.fromJson("{\"person-name\":\"joe\"}", Person.class);
		System.out.println(person.toString());
	}
}