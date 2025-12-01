package com.mycompany.app;


public class App {
    public static void main(String[] args) {
        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator("www.youtube.com");
        qrCodeGenerator.saveQRCode();
        IO.println(new FourDigitCodeGenerator().newCode().getValueAsString());
    }

}
