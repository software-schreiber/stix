package com.mycompany.app;

import com.mycompany.app.Sticker.StickerGenerator;

public class App {
    public static void main(String[] args) {
        StickerGenerator stickerGenerator = new StickerGenerator("www.example.com");
        stickerGenerator.getSticker().getQrCodeGenerator().saveQRCode();
        IO.println(stickerGenerator.getSticker().getFourDigitCode());
    }
}
