package com.csj.gold.utils.qrcode;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.csj.gold.utils.StaticValues;
import com.csj.gold.utils.SystemPropertiesUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeUtils {
	private static final int BLACK = 0xFF000000;
	private static final int WHITE = 0xFFFFFFFF;

	public static BufferedImage toBufferedImage(BitMatrix matrix) {
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		BufferedImage image = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
			}
		}
		return image;
	}

	public static String writeToFile(Long userId,String content){
		String format = "jpg";
		File file = new File(SystemPropertiesUtils.getSystemProperties(StaticValues.WEB_APPLICATION_HOME)+SystemPropertiesUtils.getSystemProperties(StaticValues.QRCODE_IMAGE_FILE_PATH), new Date().getTime() + "_"+userId+".jpg");
		System.out.println(SystemPropertiesUtils.getSystemProperties(StaticValues.WEB_APPLICATION_HOME));
		System.out.println(SystemPropertiesUtils.getSystemProperties(StaticValues.QRCODE_IMAGE_FILE_PATH));
		try {
		MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
	    Map hints = new HashMap();
	    hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
	    BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 400, 400,hints);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdir();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			BufferedImage image = toBufferedImage(bitMatrix);
			if (!ImageIO.write(image, format, file)) {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
		return file.getAbsolutePath();
	}

	public static void writeToStream(BitMatrix matrix, String format,
			OutputStream stream,Long userId) throws IOException {
		BufferedImage image = toBufferedImage(matrix);
		if (!ImageIO.write(image, format, stream)) {
			throw new IOException("Could not write an image of format "
					+ format);
		}
	}
	
}
