package com.binary_winters.demo_project;

import java.util.Optional;

public class App3 {
	
	String giveName() throws Exception {
		Optional<String> optName = Optional.empty();
		
		// Due to orElseGet uses a Supplier and in it (T get() method) there is no throws Exception 
		// in the method signature, we're obligated to handle it by try-catch, and inside the catch
		// we cannot throw a checked exception but an unchecked one.
		String name = optName.orElseGet(() -> {
			String otherName = null;
			try {
				otherName = giveAnotherName();
			} catch (Exception e) {
				e.printStackTrace();
				// Based on https://www.javatpoint.com/restful-web-services-404-not-found
				// we should create a custom exception class exteding RuntimeException
				// and add on top of it: @ResponseStatus(HttpStatus.NOT_FOUND)
				throw new RuntimeException("name not found");
			}
			return otherName;
		});

		return name;
	}
	
	String giveAnotherName() throws Exception {
		boolean nameNotFound = true;
		if (nameNotFound) {
			throw new Exception();
		}

		return "peter";
	}

	public static void main(String[] args) throws Exception {
		App3 app = new App3();
		String name = app.giveName();
		System.out.println(name);
	}
}
