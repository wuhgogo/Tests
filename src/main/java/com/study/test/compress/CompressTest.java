package com.study.test.compress;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.junit.Test;

import net.jpountz.lz4.LZ4BlockOutputStream;
import net.jpountz.lz4.LZ4Factory;

public class CompressTest {

	@Test
	public void zipTest() throws Exception {
		SimpleDateFormat tsdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Random random = new Random();
		//需打包的文件路径
		String filePath = "D:\\othertest";
		//打包目的地的文件路径
		String zipFilePath = "D:\\";
		//打包次数
		int num = 5;
		Long startTimes = System.currentTimeMillis();
		Long startTime;
		for(int i=0;i<num;i++){
			startTime = System.currentTimeMillis();
			System.out.println("第"+(i+1)+"次开始");
//			ZipTool.zip(filePath, zipFilePath);
			Zip4jUtil.zip(filePath, zipFilePath+tsdf.format(new Date())+ (random.nextInt(89)+10) + ".zip", null);
			System.out.println("第"+(i+1)+"次共耗时："+(System.currentTimeMillis()-startTime)/1000+"秒");
		}
	   	System.out.println("总共耗时："+(System.currentTimeMillis()-startTimes)/1000+"秒");
	   	startTimes = System.currentTimeMillis();
	   	for(int i=0;i<num;i++){
	   		startTime = System.currentTimeMillis();
	   		System.out.println("第"+(i+1)+"次开始");
	   		ZipTool.zip(filePath, zipFilePath+tsdf.format(new Date())+ (random.nextInt(89)+10) + ".zip");
//			Zip4jUtil.zip(filePath, zipFilePath, null);
	   		System.out.println("第"+(i+1)+"次共耗时："+(System.currentTimeMillis()-startTime)/1000+"秒");
	   	}
	   	System.out.println("总共耗时："+(System.currentTimeMillis()-startTimes)/1000+"秒");
	}
}
