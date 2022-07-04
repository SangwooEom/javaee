package com.sangwooeom.javaee.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringWriter;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonNumber;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonString;
import jakarta.json.JsonStructure;
import jakarta.json.JsonValue;
import jakarta.json.JsonWriter;

public class ObjectModel {
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(System.getProperty("user.dir"));
		
		// JSON 데이터를 이용하여 Object Model 생성하기
		JsonReader reader = Json.createReader(new FileReader("src/file/test.json"));
		JsonStructure jsont = reader.read();
		System.out.println(jsont.toString());
		
		// 코드를 이용해서 Object Model 생성하기
		JsonObject model = Json.createObjectBuilder()
				.add("firstName", "Duke")
				.add("lastName", "Java")
				.add("age", 18)
				.add("streetAddress", "100 Internet Dr")
				.add("city", "JavaTown")
				.add("phoneNumbers", Json.createArrayBuilder()
						.add(Json.createObjectBuilder()
								.add("type", "mobile")
								.add("number", "111-111-1111"))
						.add(Json.createObjectBuilder()
								.add("type", "home")
								.add("number", "222-222-2222")))
				.build();
		
		navigateTree(model, null);
		
		StringWriter stWriter = new StringWriter();
		JsonWriter jsonWriter = Json.createWriter(stWriter);
		jsonWriter.writeObject(model);
		jsonWriter.close();
		
		String jsonData = stWriter.toString();
		System.out.println(jsonData);
	}
	
	private static void navigateTree(JsonValue tree, String key) {
		if (key != null) System.out.print("Key " + key + ": ");
		
		switch(tree.getValueType()) {
			case OBJECT:
				System.out.println("OBJECT");
				JsonObject object = (JsonObject) tree;
				
				for (String name: object.keySet()) {
					navigateTree(object.get(name), name);
				}
				
				break;
			case ARRAY:
				System.out.println("ARRAY");
				JsonArray array = (JsonArray) tree;
				
				for (JsonValue val : array) {
					navigateTree(val, null);
				}
				
				break;
			case STRING:
				JsonString st = (JsonString) tree;
				System.out.println("STRING " + st.getString());
				break;
			case NUMBER:
				JsonNumber num = (JsonNumber) tree;
				System.out.println("NUMBER " + num.toString());
				break;
			case TRUE:
			case FALSE:
			case NULL:
				System.out.println(tree.getValueType().toString());
				break;
		}
	}
}
