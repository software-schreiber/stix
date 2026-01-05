package com.mycompany.app;

import java.util.Random;

public class FourDigitCodeGenerator {

	private static final int MAX_CODES = 10000;

	public FourDigitCode newCode() {
		return new FourDigitCode(new Random().nextInt(MAX_CODES));
	}

	public class FourDigitCode {

		private final int value;

		public int getValue() {
			return value;
		}

		FourDigitCode(int value) {
			if (value < 0 || value > 9999) {
				throw new IllegalArgumentException("Invalid code value " + value + ".");
			}
			this.value = value;
		}

		@Override
		public String toString() {
			return String.format("%04d", value);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null || getClass() != obj.getClass()) {
				return false;
			}
			FourDigitCode other = (FourDigitCode) obj;
			return this.value == other.value;
		}

		@Override
		public int hashCode() {
			return Integer.hashCode(value);
		}
	}
}
