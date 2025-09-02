package com.mycompany.app;

public class Code {

	private final String name;
	private final int value;

	public String getName() {
		return name;
	}

	public int getValue() {
		return value;
	}

	Code (String name, int value) {
		this.name = name;
		this.value = value;
		verifyCode();
	}

	private void verifyCode() {
		if (name == null || name.trim().isEmpty()) {
			throw new IllegalArgumentException("Invalid code name.");
		}
		if (value < 0 || value > 9999) {
			throw new IllegalArgumentException("Invalid code value.");
		}
	}
	
}
