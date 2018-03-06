/**
 * 
 */
package  com.study.test.compress;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import nochump.util.extend.ZipOutput2Flex;
import nochump.util.zip.FileUtils;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * @author walulu
 * @description 抽取自上海成考项目
 */
public class ZipTool {
	
	/**
	 * 入口方法
	 * @param inputFileName 要打包的文件夹，将把文件夹中的所有文件打包
	 * @param outputzipname zip文件地址及文件名
	 * @throws Exception
	 */
	public static void zip(String inputFileName,String outputzipname) throws Exception 
	{ 
	    String zipFileName = outputzipname; //打包后文件名字 
	    zip(zipFileName, new File(inputFileName)); 
	} 
	
	public static void zipWithPassword(String inputFileName,String outPutZipName,String password){
		File file = new File(inputFileName);
		if(!file.exists())return;
        byte[] zipByte = ZipOutput2Flex.getEncryptZipByte(file.isDirectory()?file.listFiles():new File[]{file}, password);  
        FileUtils.writeByteFile(zipByte, new File(outPutZipName));  
	}
	
	private static void zip(String zipFileName, File inputFile) throws Exception 
	{ 
	    ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName)); 
	    zip(out, inputFile, "");  
	    out.close(); 
	} 
	
	private static void zip(ZipOutputStream out, File f, String base) throws Exception 
	{ 
	    if (f.isDirectory()) 
	    { 
	       File[] fl = f.listFiles(); 
	       out.putNextEntry(new ZipEntry(base + "/")); 
	       base = base.length() == 0 ? "" : base + "/"; 
	       for (int i = 0; i < fl.length; i++) 
	       { 
	    	   String filename=  fl[i].getName();
	    	   zip(out, fl[i], base +filename); 
	       } 
	    }
	    else 
	    { 
	       out.putNextEntry(new ZipEntry(base)); 
	       FileInputStream in = new FileInputStream(f); 
	       int b; 
	       while ( (b = in.read()) != -1) 
	       { 
	    	   out.write(b); 
	       } 
	       out.setEncoding("gbk");
	     in.close(); 
	   } 
	} 

}
