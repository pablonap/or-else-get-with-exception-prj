package com.binary_winters.demo_project;

import java.util.Optional;

public class App {
	
	String giveName() throws Exception {
		Optional<String> optName = Optional.empty();
		
		String name = null;
		
		if (optName.isPresent() == false) {
			name = giveAnotherName();
		} else {
			name = optName.get();
		}
		
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
		App app = new App();
		String name = app.giveName();
		System.out.println(name);
	}
}
