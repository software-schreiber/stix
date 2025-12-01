package com.mycompany.app;

import java.util.Random;

public class FourDigitCodeGenerator {

	private static final int MAX_CODES = 10000;

	public FourDigitCode newCode() {
		return new FourDigitCode(new Random().nextInt(MAX_CODES));
	}

	public class FourDigitCode {

		private final int value;

		public String getValueAsString() {
			return String.valueOf(value);
		}

		public int getValue() {
			return value;
		}

		FourDigitCode(int value) {
			if (value < 0 || value > 9999) {
				throw new IllegalArgumentException("Invalid code value.");
			}
			this.value = value;
		}
	}
}
