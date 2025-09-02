package com.mycompany.app;

import java.util.Random;

import com.mycompany.app.Code;

public class CodeGenerator {

    private static final int MAX_CODES = 10000;

    public Code newCode() {
        int value = generateCode();
        String name = getNameByValue(value);
        Code code = new Code(name, value);
        return code;
    }
    
    private int generateCode() {
        Random r = new Random();
        return r.nextInt(MAX_CODES);
    }
    
    private String getNameByValue(int value) {
        return String.format("%04d", value);
    }
}
