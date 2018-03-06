package com.study.test.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;

import org.junit.Test;

public class FileTest {
	
	@Test
	public void createFileByUrl() throws Exception {
        URL url;
		url = new URL("file:///d:/photo/1.txt");
        URLConnection connection = url.openConnection();
//        connection.setDoOutput(true);
//        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
//		out.write("string=aaaaaaaaaaaasasaasasssssssssssssssssssssssssssssssa");
//		out.flush();
//		out.close();
		connection.setDoInput(true);
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String decodedString;
		while ((decodedString = in.readLine()) != null) {
			System.out.println(decodedString);
		}
	}
	
}
