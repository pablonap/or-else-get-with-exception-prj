package com.binary_winters.demo_project;

import java.util.Optional;

public class App4 {
	
	// Fancier solution

	String giveName() throws Exception {
		Optional<String> optName = Optional.empty();
		
		// Due to orElseGet uses a Supplier and in it (T get() method) there is no "throws Exception" 
		// in the method signature, we're obligated to handle it by try-catch, and inside the catch
		// we cannot throw a checked exception but an unchecked one.
		// Based on https://www.javatpoint.com/restful-web-services-404-not-found
		// we should create a custom exception class exteding RuntimeException
		// and add on top of it: @ResponseStatus(HttpStatus.NOT_FOUND)
		String name = optName.orElseGet(() -> giveAnotherName().orElseThrow(RuntimeException::new));

		return name;
	}
	
	// Instead of returning a String now it returns an Optional so we can invoke orElseThrow on it
	Optional<String> giveAnotherName() {
		String name = null;
		boolean nameNotFound = true;
		if (nameNotFound) {
			try {
				throw new Exception(); // When searching for the name in the repository a checked exception is thrown
//				name = "peter";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return Optional.of(name);
	}

	public static void main(String[] args) throws Exception {
		App4 app = new App4();
		String name = app.giveName();
		System.out.println(name);
	}
}
