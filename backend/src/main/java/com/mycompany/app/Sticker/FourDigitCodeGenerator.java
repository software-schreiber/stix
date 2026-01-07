package com.mycompany.app.Sticker;

import java.util.Random;

/**
 * Generates a {@link FourDigitCode}.
 * <hr>
 * Use the {@link #newCode()} method to generate a new random code.
 * 
 * @author Kevin Forst
 */
public class FourDigitCodeGenerator {

	private static final int MAX_CODES = 10000;

	/**
	 * Generates and returns a new random {@link FourDigitCode}.
	 * 
	 * @return a new random {@link FourDigitCode}.
	 */
	public FourDigitCode newCode() {
		return new FourDigitCode(new Random().nextInt(MAX_CODES));
	}

	/**
	 * Represents a four-digit code between 0000 and 9999 inclusive.
	 * <hr>
	 * Has a string representation that is always four characters long, with leading zeros if necessary <br>-> see {@link #toString()} implementation.
	 * <br>
	 * The integer value can be retrieved using {@link #getValue()}.
	 * <br><br>
	 * Overrides {@link #equals(Object)} and {@link #hashCode()} for proper value comparison and hashing.
	 * @author Kevin Forst
	 */
	public class FourDigitCode {

		private final int value;

		/**
		 * Returns the <b>int</b> value of this four-digit code.
		 *
		 * @return the <b>int</b> value of this four-digit code.
		 */
		public int getValue() {
			return value;
		}

		/**
		 * Constructs a FourDigitCode with the specified value, between 0 and 9999 inclusive.
		 *
		 * @param value the <b>int</b> value of the four-digit code.
		 * @throws IllegalArgumentException if the value is not between 0 and 9999 inclusive.
		 */
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
