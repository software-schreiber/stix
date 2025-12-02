package com.mycompany.app;

import com.mycompany.app.FourDigitCodeGenerator.FourDigitCode;

public class StickerGenerator {
	private final Sticker sticker;

	public Sticker getSticker() {
		return sticker;
	}

	StickerGenerator(String content) {
		this.sticker = new Sticker(content);
	}

	public class Sticker {
		private final QRCodeGenerator qrCodeGenerator;
		private final FourDigitCode code;

		public QRCodeGenerator getQrCodeGenerator() {
			return qrCodeGenerator;
		}

		public FourDigitCode getFourDigitCode() {
			return code;
		}

		Sticker(String content) {
			this.qrCodeGenerator = new QRCodeGenerator(content);
			this.code = new FourDigitCodeGenerator().newCode();
		}
	}
}
