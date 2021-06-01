package com.binary_winters.demo_project;

import java.util.Optional;

public class App2 {
	
	String giveName() throws Exception {
		Optional<String> optName = Optional.empty();
		
		// Due to orElseGet uses a Supplier and in it there is no throws Exception 
		// in the method signature, we're obligated to handle it by try-catch
		String name = optName.orElseGet(() -> {
			String otherName = null;
			try {
				otherName = giveAnotherName();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return otherName;
		});
		
		// Make no sense using Optional if in the end I ask for "== null"
		if (name == null) {
			throw new Exception();
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
		App2 app = new App2();
		String name = app.giveName();
		System.out.println(name);
	}
}
