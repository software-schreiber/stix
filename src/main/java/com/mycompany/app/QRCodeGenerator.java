package com.mycompany.app;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGenerator {

	private static final int WIDTH_AND_HEIGHT = 400;
	private static final String IMAGE_FORMAT = "PNG";
	private static final BarcodeFormat BARCODE_FORMAT = BarcodeFormat.QR_CODE;

	private final String content;
	private final String fileName;

	QRCodeGenerator(String content, String fileName) {
		this.content = content;
		this.fileName = fileName + ".png";
	} 

	QRCodeGenerator(String content) {
		this(content, removeLinkCharacteristics(content));
	}

	private static String removeLinkCharacteristics(String s) {
		return s.split("\\.")[1];
	}

	public BitMatrix createQRBitMatrix() {
		try {
			return new QRCodeWriter().encode(content, BARCODE_FORMAT, WIDTH_AND_HEIGHT, WIDTH_AND_HEIGHT);
		} catch (WriterException e) {
			System.err.println("Error generating QR Code in Method createQRBitMatrix: \n" + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	public void saveQRCode() {
		try {
			MatrixToImageWriter.writeToPath(createQRBitMatrix(), IMAGE_FORMAT, FileSystems.getDefault().getPath(fileName));
		} catch (IOException e) {
			System.err.println("Error generating QR Code in Method saveQRCode: \n" + e.getMessage());
		}
	}
	
}
