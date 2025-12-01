package com.mycompany.app;

import java.util.Random;

public class FourDigitCodeGenerator {

	private static final int MAX_CODES = 10000;

	public Code newCode() {
		int value = generateCode();
		return new Code(String.valueOf(value), value);
	}

	private int generateCode() {
		return new Random().nextInt(MAX_CODES);
	}

	public class Code {

		private final String name;
		private final int value;

		public String getName() {
			return name;
		}

		public int getValue() {
			return value;
		}

		Code(String name, int value) {
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
}
