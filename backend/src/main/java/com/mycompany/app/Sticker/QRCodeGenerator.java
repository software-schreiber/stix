package com.mycompany.app.Sticker;

import java.io.IOException;
import java.nio.file.FileSystems;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Generates a QR code of specified content.
 * <br>
 * Can be safed as an image via {@link #saveQRCode()}. or retrieved as a {@link BitMatrix} via {@link #createQRBitMatrix()}.
 *
 * @author Kevin Forst
 */
public class QRCodeGenerator {

	private static final int WIDTH_AND_HEIGHT = 400;
	private static final String IMAGE_FORMAT = "PNG";
	private static final BarcodeFormat BARCODE_FORMAT = BarcodeFormat.QR_CODE;

	private final String content;
	private final String fileName;

	/**
	 * Constructs a QRCodeGenerator with content and file name.
	 * 
	 * @param content  the content to be encoded in the QR code.
	 * @param fileName the name of the file to save the QR code image as (without file extension).
	 */
	QRCodeGenerator(String content, String fileName) {
		this.content = content;
		this.fileName = fileName + ".png";
	} 

	/**
	 * Constructs a QRCodeGenerator with content (e.g. www.example.com or any other kind data).
	 * 
	 * @param content the content to be encoded in the QR code.
	 */
	QRCodeGenerator(String content) {
		this(content, removeLinkCharacteristics(content));
	}

	private static String removeLinkCharacteristics(String s) {
		return s.split("\\.")[1];
	}
 
	/**
	 * Creates a {@link BitMatrix} of the QR code.
	 * 
	 * @return a {@link BitMatrix} of the QR code.
	 * 
	 * @throws WriterException if an error occurs during QR code generation.
	 */
	public BitMatrix createQRBitMatrix() {
		try {
			return new QRCodeWriter().encode(content, BARCODE_FORMAT, WIDTH_AND_HEIGHT, WIDTH_AND_HEIGHT);
		} catch (WriterException e) {
			System.err.println("Error generating QR Code in Method createQRBitMatrix: \n" + e.getMessage());
			throw new RuntimeException(e);
		}
	}

	/**
	 * Saves the QR code as an image file, in projects root directory.
	 * 
	 * @throws IOException if an error occurs during file writing.
	 */
	public void saveQRCode() {
		try {
			MatrixToImageWriter.writeToPath(createQRBitMatrix(), IMAGE_FORMAT, FileSystems.getDefault().getPath(fileName));
		} catch (IOException e) {
			System.err.println("Error generating QR Code in Method saveQRCode: \n" + e.getMessage());
		}
	}
	
}
