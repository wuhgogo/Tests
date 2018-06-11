package com.study.test.ocr;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.ImageHelper;

public class MyTest {

	public BufferedImage getSource(String source) throws Exception {
		File imageFile = new File(source);
		// // 这里对图片黑白处理,增强识别率.这里先通过截图,截取图片中需要识别的部分
		// BufferedImage textImage =
		// ImageHelper.convertImageToGrayscale(ImageHelper.getSubImage(panel.image,
		// startX, startY, endX, endY));
		// // 图片锐化,自己使用中影响识别率的主要因素是针式打印机字迹不连贯,所以锐化反而降低识别率
		// textImage = ImageHelper.convertImageToBinary(textImage);
		// // 图片放大5倍,增强识别率(很多图片本身无法识别,放大5倍时就可以轻易识,但是考滤到客户电脑配置低,针式打印机打印不连贯的问题,这里就放大5倍)
		// textImage = ImageHelper.getScaledInstance(textImage, endX * 5, endY * 5);
		// BufferedImage grayImage =
		// ImageHelper.convertImageToBinary(ImageIO.read(imageFile));
		// ImageIO.write(grayImage, "png", new File("C:\\Users\\wuh\\Desktop",
		// "test2.png"));
		BufferedImage textImage = null;
		InputStream in = new FileInputStream(imageFile);
		BufferedImage image = ImageIO.read(in);
		textImage = ImageHelper
				.convertImageToGrayscale(ImageHelper.getSubImage(image, 0, 0, image.getWidth(), image.getHeight())); // 对图片进行处理
		textImage = ImageHelper.getScaledInstance(image, image.getWidth() * 5, image.getHeight() * 5); // 将图片扩大5倍
		return textImage;
	}
	
	String read(BufferedImage parms) throws Exception {
		ITesseract instance = new Tesseract(); // JNA Interface Mapping
		instance.setDatapath(
				"C:\\Wuh\\Work\\Workspaces\\Repository\\Git\\Tests\\src\\main\\resources\\orc\\tessreact-ocr\\tessdata");
		// instance.setLanguage("chi_sim");
		// ITesseract instance = new Tesseract1(); // JNA Direct Mapping

		// String result = instance.doOCR(imageFile);
		return instance.doOCR(parms);
	}
	
	void handle(String result) {
		System.out.println(result);
	}
	
	void doRead(String source) throws Exception {
		//获取需要进行识别的数据
		//识别
		//处理结果
		handle(read(getSource(source)));
	}
	
	public static void main(String[] args) {
		MyTest myTest = new MyTest();
		try {
			myTest.doRead("C:\\Users\\wuh\\Desktop\\calc.jpg");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
