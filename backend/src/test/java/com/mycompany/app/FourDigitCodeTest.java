package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mycompany.app.Sticker.FourDigitCodeGenerator;

/**
 * Test class for {@link FourDigitCodeGenerator}.
 */
public class FourDigitCodeTest {

    /**
     * Tests for valid four-digit codes.
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(new FourDigitCodeGenerator().newCode().getValue() >= 0);
        assertTrue(new FourDigitCodeGenerator().newCode().getValue() <= 9999);
        assertTrue(new FourDigitCodeGenerator().newCode().toString().length() == 4);
    }
}
