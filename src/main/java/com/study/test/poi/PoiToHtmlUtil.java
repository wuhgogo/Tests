package com.study.test.poi;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.converter.ExcelToHtmlConverter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.w3c.dom.Document;

/**
 * 
 * @author wuh
 * 
 */
public class PoiToHtmlUtil {

	public String excelToHtml(String srcFile) {
		HSSFWorkbook excelBook = null;
		ExcelToHtmlConverter excelToHtmlConverter = null;
		try {
			InputStream input = new FileInputStream(srcFile);
			excelBook = new HSSFWorkbook(input);
			excelToHtmlConverter = new ExcelToHtmlConverter(
					DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument());
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}

		// //加载html页面时图片路径
		// XHTMLOptions options = XHTMLOptions.create().URIResolver( new
		// BasicURIResolver(getImageUrl(path)));
		// //图片保存文件夹路径
		// options.setExtractor(new FileImageExtractor(new
		// File(getImageSavePath(path))));
		excelToHtmlConverter.setOutputRowNumbers(false);
		excelToHtmlConverter.setOutputHiddenRows(false);
		excelToHtmlConverter.setOutputColumnHeaders(false);
		excelToHtmlConverter.setOutputHiddenColumns(true);
		excelToHtmlConverter.processWorkbook(excelBook);
		// List pics = excelBook.getAllPictures();
		// if (pics != null) {
		// for (int i = 0; i < pics.size(); i++) {
		// HSSFPictureData pic = (HSSFPictureData) pics.get (i);
		// try {
		//// pic.writeImageContent (new FileOutputStream (path +
		// pic.suggestFullFileName() ) );
		// new FileOutputStream (path + "11" ).write(pic.getData());
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		//
		// }
		// }
		Document htmlDocument = excelToHtmlConverter.getDocument();
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		DOMSource domSource = new DOMSource(htmlDocument);
		StreamResult streamResult = new StreamResult(outStream);
		TransformerFactory tf = TransformerFactory.newInstance();
		try {
			Transformer serializer = tf.newTransformer();
			serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			serializer.setOutputProperty(OutputKeys.INDENT, "yes");
			serializer.setOutputProperty(OutputKeys.METHOD, "html");
			serializer.transform(domSource, streamResult);
		} catch (TransformerException e) {
			e.printStackTrace();
		} finally {
			try {
				outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new String(outStream.toByteArray());
	}

}
