package com.mycompany.app;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class App {
    public static void main(String[] args) {
        QRCodeGenerator qrCodeGenerator = new QRCodeGenerator("www.google.com", "google");
        try {
            qrCodeGenerator.saveQRCode();
        } catch (WriterException | IOException e) {
            e.printStackTrace();
        }
    }

}
