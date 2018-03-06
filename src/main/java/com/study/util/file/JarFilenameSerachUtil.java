package com.study.util.file;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Arrays;

public class JarFilenameSerachUtil {

	private static String[] fileSuffixs = {".jar"};
	private static String fileSeparators = ";";
	/**
	 * 寻找当前路径下的jar包
	 * @param path 遍历路径
	 * @return 结果路径字符串
	 */
	private static String search(String path){
		String fileSuffixStrs = "";
		String fileSuffixStr = "";
		//判断路径的合法性
		File file = new File(path);
		String fileName = "";
		if (file.exists()) {
			//获取当前文件夹下所有文件
			for(File currentFile:file.listFiles()){
				//判断当前是文件还是文件夹
				if (!currentFile.isDirectory()) {
					//文件夹直接比较后缀
					fileName = currentFile.getName();
					if (Arrays.asList(fileSuffixs).contains("."+fileName.substring(fileName.lastIndexOf(".")+1))) {
						fileSuffixStrs = fileSuffixStrs + currentFile.getPath() + fileSeparators;
					}
				}else{
					//文件夹继续遍历
					fileSuffixStr = search(currentFile.getPath());
					if (!"".equals(fileSuffixStr)) {
						fileSuffixStrs = fileSuffixStrs + fileSuffixStr;
					}
				}
			}
		}
		return fileSuffixStrs;
	}
	
	public static void main(String[] args) {
		String path = "D:\\test\\lib";
		System.out.println(search(path));
	}

}
