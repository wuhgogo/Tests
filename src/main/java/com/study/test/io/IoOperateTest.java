package com.study.test.io;

import java.io.UnsupportedEncodingException;

import org.junit.Test;

public class IoOperateTest {

	@Test
	public void StringCodeTest(){
		
		String name = "I am 君山";
		System.out.println(name.toCharArray());
		HexUtil.toHex(name.toCharArray());
		HexUtil.toHex(name.getBytes());
		
		try {
			byte[] iso8859 = name.getBytes("ISO-8859-1");
			HexUtil.toHex(iso8859);
			byte[] gb2312 = name.getBytes("GB2312");
			HexUtil.toHex(gb2312);
			byte[] gbk = name.getBytes("GBK");
			HexUtil.toHex(gbk);
			byte[] utf16 = name.getBytes("UTF-16");
			HexUtil.toHex(utf16);
			byte[] utf8 = name.getBytes("UTF-8");
			HexUtil.toHex(utf8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
	
	public static class HexUtil{
		public static void toHex(byte[] b){
	        String r = "";
	        
	        for (int i = 0; i < b.length; i++) {
	            String hex = Integer.toHexString(b[i] & 0xFF);
	            if (hex.length() == 1) {
	                hex = '0' + hex;
	            }
	            r += hex.toUpperCase() + " ";
	        }
	        
	        System.out.println(r);
		}
		public static void toHex(char[] c){
			String r = "";
			
			for (int i = 0; i < c.length; i++) {
				String hex = Integer.toHexString((int)c[i]);
				if (hex.length() %2 == 1) {
					hex = '0' + hex;
				}
				r += hex.toUpperCase() + " ";
			}
			
			System.out.println(r);
		}
	}
}
